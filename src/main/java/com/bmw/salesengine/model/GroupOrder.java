package com.bmw.salesengine.model;

public class GroupOrder {
	
	private String cargroup;
	private Integer carnumber;
	public String getCargroup() {
		return cargroup;
	}
	public void setCargroup(String cargroup) {
		this.cargroup = cargroup;
	}
	public Integer getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(Integer carnumber) {
		this.carnumber = carnumber;
	}
	public GroupOrder(String cargroup, Integer carnumber) {
		super();
		this.cargroup = cargroup;
		this.carnumber = carnumber;
	}
	public GroupOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GroupOrder [cargroup=" + cargroup + ", carnumber=" + carnumber + "]";
	}
	
	

}
