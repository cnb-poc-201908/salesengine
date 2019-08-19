package com.bmw.salesengine.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bmw.salesengine.algorithm.AddWeight;
import com.bmw.salesengine.algorithm.Aggregation;
import com.bmw.salesengine.algorithm.Recursive;
import com.bmw.salesengine.algorithm.RecursiveGroup;
import com.bmw.salesengine.algorithm.SimilarStyle;
import com.bmw.salesengine.client.ModelSvcClient;
import com.bmw.salesengine.mapper.MaterialsIdMapper;
import com.bmw.salesengine.mapper.MaterialsMapper;
import com.bmw.salesengine.mapper.OrderIdMapper;
import com.bmw.salesengine.mapper.OrderMapper;
import com.bmw.salesengine.model.GroupModel;
import com.bmw.salesengine.model.GroupSimilar;
import com.bmw.salesengine.rspmodel.RspModel;
import com.bmw.salesengine.ulity.GenerateGroup;
import com.bmw.salesengine.ulity.ModelWeight;
import com.bmw.salesengine.ulity.ProcessModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(description = "BMW微服务销售调度分配服务接口")
public class EngineController {

	@Autowired
	private ModelSvcClient modelclient;

	@Autowired
	private MaterialsMapper materialsmapper;

	@Autowired
	private OrderMapper ordermapper;

	@Autowired
	private Aggregation aggreationSvc;

	@Autowired
	private AddWeight addweightSvc;

	@Autowired
	private Recursive recursiveSvc;

	@Autowired
	private RecursiveGroup recursiveGroup;

	@Autowired
	private OrderIdMapper orderidmapper;

	@Autowired
	private MaterialsIdMapper materialsidmapper;

	@RequestMapping(value = "/smartEngine", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "微服务信息查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public ResponseEntity<RspModel> enable() {

		ResponseEntity<Object> result = modelclient.getModels();

		JSONObject modelresult = getResult(result);

		Map<String, String> models = ModelWeight.iterateModel(modelresult);

		ArrayList<Object> sortedmodel = ProcessModel.sortModel(models);

		List<GroupModel> groupmaterials = materialsmapper.groupMaterials();

		List<GroupModel> grouporder = ordermapper.groupOrder();
		
		//Init pahse
		System.out.println("===================> Reset match");
		materialsidmapper.resetMaterialsId();
		
		orderidmapper.resetOrderId();


		// pahse1
		System.out.println("===================> Pahse 1 ");

		ArrayList<Object> phaseOne = GenerateGroup.iterateMatch(groupmaterials, grouporder);
		ArrayList<Object> paseTwo = aggreationSvc.processPhaseOne(phaseOne);

		// pahse2
		System.out.println("===================> Pahse 2 ");
		addweightSvc.processPhaseTwo(paseTwo, sortedmodel);
		

		// pahse3

		ResponseEntity<Object> oemresult = modelclient.getOemModels();

		JSONObject oemmodelresult = getResult(oemresult);

		Map<String, String> oemmodels = ModelWeight.iterateOemModel(oemmodelresult);

		ArrayList<Object> sortedoemmodel = ProcessModel.sortModel(oemmodels);

		ArrayList<Object> phaseOne1 = recursiveSvc.processPhaseThree();

		// recursive pahse2

		ArrayList<Object> paseTwo1 = aggreationSvc.processPhaseOne1(phaseOne1);
		addweightSvc.processPhaseTwo1(paseTwo1, sortedmodel);

		// recursive1 pahse2

		ArrayList<Object> phaseRecursiveOne1 = recursiveSvc.processPhaseThree1();
		ArrayList<Object> paseTwo2 = aggreationSvc.processPhaseOne2(phaseRecursiveOne1);
		addweightSvc.processPhaseTwo2(paseTwo2, sortedmodel);

		// recursive by oem model

		recursiveGroup.processRecusive(sortedoemmodel, sortedmodel);

		System.out.println("===================> Pahse 3 ");
		// pahse4 similarity

		List<GroupSimilar> materials = materialsmapper.groupSimilar();
		List<GroupSimilar> orders = ordermapper.groupSimilar();

		Map<String, String> hm = new HashMap<String, String>();
		for (int y = 0; y < orders.size(); y++) {
			String s1 = orders.get(y).getGroupname();
			ArrayList<Double> max = new ArrayList<>();
			for (int z = 0; z < materials.size(); z++) {
				SimilarStyle similarity = new SimilarStyle(s1, materials.get(z).getGroupname());
				Double similar = similarity.sim();
				max.add(similar);
			}
			Double maxVal = Collections.max(max);
			Integer maxIdx = max.indexOf(maxVal);
			hm.put(orders.get(y).getId(), materials.get(maxIdx).getId());
			materials.remove(materials.get(maxIdx));
		}

		for (Map.Entry<String, String> entry : hm.entrySet()) {

			System.out.println(entry.getKey() + "--------" + entry.getValue());

			orderidmapper.updateOrderId2(entry.getKey(), entry.getValue());
			materialsidmapper.updateMaterialsId2(entry.getValue(), entry.getKey());

		}

		RspModel rsp = new RspModel();
		rsp.setCode(200);
		rsp.setMessage("成功");
		return new ResponseEntity<RspModel>(rsp, HttpStatus.OK);

	}

	private JSONObject getResult(ResponseEntity<Object> result) {
		Gson gson = new Gson();
		String jsonResultStr = gson.toJson(result.getBody());
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(jsonResultStr).getAsJsonObject().get("data").getAsJsonObject();

		JSONObject jsonobject = new JSONObject(object.toString());

		return jsonobject;

	}

}
