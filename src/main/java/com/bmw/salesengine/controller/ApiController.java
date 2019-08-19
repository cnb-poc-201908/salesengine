package com.bmw.salesengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bmw.salesengine.mapper.ReportMapper;
import com.bmw.salesengine.model.DealerReportModel;
import com.bmw.salesengine.model.ReportModel;
import com.bmw.salesengine.rspmodel.RspDealerReportModel;
import com.bmw.salesengine.rspmodel.RspReportModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(description = "BMW微服务销售调度分配报告接口")
public class ApiController {

	@Autowired
	private ReportMapper reportMapper;

	@RequestMapping(value = "/report", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "匹配报告信息查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public ResponseEntity<RspReportModel> getSummary() {

		ReportModel report = reportMapper.report();

		RspReportModel rsp = new RspReportModel();
		rsp.setCode(200);
		rsp.setMessage("成功");
		rsp.setData(report);
		return new ResponseEntity<RspReportModel>(rsp, HttpStatus.OK);

	}

	@RequestMapping(value = "/dealerreport", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "经销商匹配报告信息查询")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功"), @ApiResponse(code = 400, message = "错误的请求"),
			@ApiResponse(code = 401, message = "没有权限查看此资源"), @ApiResponse(code = 404, message = "资源不存在"),
			@ApiResponse(code = 500, message = "内部错误请联系管理员") })
	public ResponseEntity<RspDealerReportModel> getDealer() {

		List<DealerReportModel> report = reportMapper.dealreport();

		RspDealerReportModel rsp = new RspDealerReportModel();
		rsp.setCode(200);
		rsp.setMessage("成功");
		rsp.setData(report);
		return new ResponseEntity<RspDealerReportModel>(rsp, HttpStatus.OK);

	}

}
