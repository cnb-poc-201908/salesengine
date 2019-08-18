package com.bmw.salesengine.model;

public class GroupModel {
	
	private String groupname;
	private Integer groupnumber;
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public Integer getGroupnumber() {
		return groupnumber;
	}
	public void setGroupnumber(Integer groupnumber) {
		this.groupnumber = groupnumber;
	}
	public GroupModel(String groupname, Integer groupnumber) {
		super();
		this.groupname = groupname;
		this.groupnumber = groupnumber;
	}
	public GroupModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GroupModel [groupname=" + groupname + ", groupnumber=" + groupnumber + "]";
	}
	
	
	
	

}
