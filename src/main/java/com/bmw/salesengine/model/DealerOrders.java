package com.bmw.salesengine.model;

public class DealerOrders {
	
	private String orderId;
	private String dealerId;
	private Integer weight;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDealerId() {
		return dealerId;
	}
	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public DealerOrders(String orderId, String dealerId, Integer weight) {
		super();
		this.orderId = orderId;
		this.dealerId = dealerId;
		this.weight = weight;
	}
	public DealerOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DealerOrders [orderId=" + orderId + ", dealerId=" + dealerId + ", weight=" + weight + "]";
	}
	
	
	
	
	
	

}
