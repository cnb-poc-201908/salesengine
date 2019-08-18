package com.bmw.salesengine.model;

public class DealerReportModel {
	
	private String dealerId;
	private Integer total;
	private Integer unmatch;
	private String ratio;
	public String getDealerId() {
		return dealerId;
	}
	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getUnmatch() {
		return unmatch;
	}
	public void setUnmatch(Integer unmatch) {
		this.unmatch = unmatch;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public DealerReportModel(String dealerId, Integer total, Integer unmatch, String ratio) {
		super();
		this.dealerId = dealerId;
		this.total = total;
		this.unmatch = unmatch;
		this.ratio = ratio;
	}
	public DealerReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DealerReportModel [dealerId=" + dealerId + ", total=" + total + ", unmatch=" + unmatch + ", ratio="
				+ ratio + "]";
	}
	
	
	

}
