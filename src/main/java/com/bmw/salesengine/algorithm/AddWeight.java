package com.bmw.salesengine.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmw.salesengine.mapper.MaterialsIdMapper;
import com.bmw.salesengine.mapper.OrderIdMapper;
import com.bmw.salesengine.model.DealerOrders;
import com.bmw.salesengine.ulity.ProcessModel;

@Service
public class AddWeight {

	@Autowired
	private OrderIdMapper orderidmapper;

	@Autowired
	private MaterialsIdMapper materialsidmapper;

	public void processPhaseTwo(ArrayList<Object> phasetwo, ArrayList<Object> dealermodels) {

		for (int i = 0; i < phasetwo.size(); i++) {
			// System.out.println(phasetwo.get(i).toString());
			String gn = phasetwo.get(i).toString().split("!!")[0];
			ArrayList<Object> materialslist = materialsidmapper.materialsList(gn);
			List<DealerOrders> dealerorderlist = orderidmapper.dealerorderList(gn);
			Map<String, String> dealermap = new TreeMap<String, String>();
			for (int d = 0; d < dealerorderlist.size(); d++) {
				dealerorderlist.get(d).setWeight(dealermodels.indexOf(dealerorderlist.get(d).getDealerId()));
				dealermap.put(dealerorderlist.get(d).getOrderId(), dealerorderlist.get(d).getWeight().toString());
			}
			ArrayList<Object> weightorderlist = ProcessModel.sortModel(dealermap);
			// System.out.println(materialslist.toString());
			// System.out.println(weightorderlist.toString());
			for (int m = 0; m < materialslist.size(); m++) {

				System.out.println(weightorderlist.get(m) + "--------" + materialslist.get(m));
				orderidmapper.updateOrderId(weightorderlist.get(m).toString(), materialslist.get(m).toString());
				materialsidmapper.updateMaterialsId(materialslist.get(m).toString(), weightorderlist.get(m).toString());

			}

		}

	}

	public void processPhaseTwo1(ArrayList<Object> phasetwo, ArrayList<Object> dealermodels) {

		for (int i = 0; i < phasetwo.size(); i++) {
			// System.out.println(phasetwo.get(i).toString());
			String gn = phasetwo.get(i).toString().split("!!")[0];
			ArrayList<Object> materialslist = materialsidmapper.materialsList1(gn);
			List<DealerOrders> dealerorderlist = orderidmapper.dealerorderList1(gn);
			Map<String, String> dealermap = new TreeMap<String, String>();
			for (int d = 0; d < dealerorderlist.size(); d++) {
				dealerorderlist.get(d).setWeight(dealermodels.indexOf(dealerorderlist.get(d).getDealerId()));
				dealermap.put(dealerorderlist.get(d).getOrderId(), dealerorderlist.get(d).getWeight().toString());
			}
			ArrayList<Object> weightorderlist = ProcessModel.sortModel(dealermap);
			// System.out.println(materialslist.toString());
			// System.out.println(weightorderlist.toString());
			for (int m = 0; m < materialslist.size(); m++) {

				System.out.println(weightorderlist.get(m) + "--------" + materialslist.get(m));
				orderidmapper.updateOrderId1(weightorderlist.get(m).toString(), materialslist.get(m).toString());
				materialsidmapper.updateMaterialsId1(materialslist.get(m).toString(), weightorderlist.get(m).toString());

			}

		}

	}
	
	
	public void processPhaseTwo2(ArrayList<Object> phasetwo, ArrayList<Object> dealermodels) {

		for (int i = 0; i < phasetwo.size(); i++) {
			// System.out.println(phasetwo.get(i).toString());
			String gn = phasetwo.get(i).toString().split("!!")[0];
			ArrayList<Object> materialslist = materialsidmapper.materialsList2(gn);
			List<DealerOrders> dealerorderlist = orderidmapper.dealerorderList2(gn);
			Map<String, String> dealermap = new TreeMap<String, String>();
			for (int d = 0; d < dealerorderlist.size(); d++) {
				dealerorderlist.get(d).setWeight(dealermodels.indexOf(dealerorderlist.get(d).getDealerId()));
				dealermap.put(dealerorderlist.get(d).getOrderId(), dealerorderlist.get(d).getWeight().toString());
			}
			ArrayList<Object> weightorderlist = ProcessModel.sortModel(dealermap);
			// System.out.println(materialslist.toString());
			// System.out.println(weightorderlist.toString());
			for (int m = 0; m < materialslist.size(); m++) {

				System.out.println(weightorderlist.get(m) + "--------" + materialslist.get(m));
				orderidmapper.updateOrderId1(weightorderlist.get(m).toString(), materialslist.get(m).toString());
				materialsidmapper.updateMaterialsId1(materialslist.get(m).toString(), weightorderlist.get(m).toString());

			}

		}

	}
	
	public void processPhaseColor(ArrayList<Object> phasetwo, ArrayList<Object> dealermodels) {

		for (int i = 0; i < phasetwo.size(); i++) {
			// System.out.println(phasetwo.get(i).toString());
			String gn = phasetwo.get(i).toString().split("!!")[0];
			ArrayList<Object> materialslist = materialsidmapper.materialsListColor(gn);
			List<DealerOrders> dealerorderlist = orderidmapper.dealerorderListColor(gn);
			Map<String, String> dealermap = new TreeMap<String, String>();
			for (int d = 0; d < dealerorderlist.size(); d++) {
				dealerorderlist.get(d).setWeight(dealermodels.indexOf(dealerorderlist.get(d).getDealerId()));
				dealermap.put(dealerorderlist.get(d).getOrderId(), dealerorderlist.get(d).getWeight().toString());
			}
			ArrayList<Object> weightorderlist = ProcessModel.sortModel(dealermap);
			// System.out.println(materialslist.toString());
			// System.out.println(weightorderlist.toString());
			for (int m = 0; m < materialslist.size(); m++) {

				System.out.println(weightorderlist.get(m) + "--------" + materialslist.get(m));
				orderidmapper.updateOrderId1(weightorderlist.get(m).toString(), materialslist.get(m).toString());
				materialsidmapper.updateMaterialsId1(materialslist.get(m).toString(), weightorderlist.get(m).toString());

			}

		}

	}
	
	public void processPhaseUpholstery(ArrayList<Object> phasetwo, ArrayList<Object> dealermodels) {

		for (int i = 0; i < phasetwo.size(); i++) {
			// System.out.println(phasetwo.get(i).toString());
			String gn = phasetwo.get(i).toString().split("!!")[0];
			ArrayList<Object> materialslist = materialsidmapper.materialsListUpholstery(gn);
			List<DealerOrders> dealerorderlist = orderidmapper.dealerorderListUpholstery(gn);
			Map<String, String> dealermap = new TreeMap<String, String>();
			for (int d = 0; d < dealerorderlist.size(); d++) {
				dealerorderlist.get(d).setWeight(dealermodels.indexOf(dealerorderlist.get(d).getDealerId()));
				dealermap.put(dealerorderlist.get(d).getOrderId(), dealerorderlist.get(d).getWeight().toString());
			}
			ArrayList<Object> weightorderlist = ProcessModel.sortModel(dealermap);
			// System.out.println(materialslist.toString());
			// System.out.println(weightorderlist.toString());
			for (int m = 0; m < materialslist.size(); m++) {

				System.out.println(weightorderlist.get(m) + "--------" + materialslist.get(m));
				orderidmapper.updateOrderId1(weightorderlist.get(m).toString(), materialslist.get(m).toString());
				materialsidmapper.updateMaterialsId1(materialslist.get(m).toString(), weightorderlist.get(m).toString());

			}

		}

	}
	
	
	public void processPhaseConfig(ArrayList<Object> phasetwo, ArrayList<Object> dealermodels) {

		for (int i = 0; i < phasetwo.size(); i++) {
			// System.out.println(phasetwo.get(i).toString());
			String gn = phasetwo.get(i).toString().split("!!")[0];
			ArrayList<Object> materialslist = materialsidmapper.materialsListConfig(gn);
			List<DealerOrders> dealerorderlist = orderidmapper.dealerorderListConfig(gn);
			Map<String, String> dealermap = new TreeMap<String, String>();
			for (int d = 0; d < dealerorderlist.size(); d++) {
				dealerorderlist.get(d).setWeight(dealermodels.indexOf(dealerorderlist.get(d).getDealerId()));
				dealermap.put(dealerorderlist.get(d).getOrderId(), dealerorderlist.get(d).getWeight().toString());
			}
			ArrayList<Object> weightorderlist = ProcessModel.sortModel(dealermap);
			// System.out.println(materialslist.toString());
			// System.out.println(weightorderlist.toString());
			for (int m = 0; m < materialslist.size(); m++) {

				System.out.println(weightorderlist.get(m) + "--------" + materialslist.get(m));
				orderidmapper.updateOrderId1(weightorderlist.get(m).toString(), materialslist.get(m).toString());
				materialsidmapper.updateMaterialsId1(materialslist.get(m).toString(), weightorderlist.get(m).toString());

			}

		}

	}
	
	
	public void processPhaseAddCode(ArrayList<Object> phasetwo, ArrayList<Object> dealermodels) {
		System.out.println(phasetwo);

		for (int i = 0; i < phasetwo.size(); i++) {
			// System.out.println(phasetwo.get(i).toString());
			String gn = phasetwo.get(i).toString().split("!!")[0];
			ArrayList<Object> materialslist = materialsidmapper.materialsListAddCode(gn);
			List<DealerOrders> dealerorderlist = orderidmapper.dealerorderListAddCode(gn);
			Map<String, String> dealermap = new TreeMap<String, String>();
			for (int d = 0; d < dealerorderlist.size(); d++) {
				dealerorderlist.get(d).setWeight(dealermodels.indexOf(dealerorderlist.get(d).getDealerId()));
				dealermap.put(dealerorderlist.get(d).getOrderId(), dealerorderlist.get(d).getWeight().toString());
			}
			ArrayList<Object> weightorderlist = ProcessModel.sortModel(dealermap);
			// System.out.println(materialslist.toString());
			// System.out.println(weightorderlist.toString());
			for (int m = 0; m < materialslist.size(); m++) {

				System.out.println(weightorderlist.get(m) + "--------" + materialslist.get(m));
				orderidmapper.updateOrderId1(weightorderlist.get(m).toString(), materialslist.get(m).toString());
				materialsidmapper.updateMaterialsId1(materialslist.get(m).toString(), weightorderlist.get(m).toString());

			}

		}

	}

}
