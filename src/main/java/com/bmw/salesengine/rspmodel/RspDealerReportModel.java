package com.bmw.salesengine.rspmodel;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.bmw.salesengine.model.DealerReportModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "返回模型")
public class RspDealerReportModel {
	@ApiModelProperty(notes = "返回码", example = "200", required = true, dataType = "java.lang.Integer")
	@NotNull
	private Integer code;

	@ApiModelProperty(notes = "返回信息", example = "成功", required = true, dataType = "java.lang.String")
	@NotNull
	private String message;

	@ApiModelProperty(notes = "返回数据", required = true, dataType = "java.lang.Object")
	private List<DealerReportModel> data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DealerReportModel> getData() {
		return data;
	}

	public void setData(List<DealerReportModel> data) {
		this.data = data;
	}

	
	
	

}
