package com.bmw.salesengine.model;

public class GroupSimilar {
	
	private String id;
	private String groupname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public GroupSimilar(String id, String groupname) {
		super();
		this.id = id;
		this.groupname = groupname;
	}

	
	public GroupSimilar() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GroupSimilar [id=" + id + ", groupname=" + groupname + "]";
	}
	
	
	
	
	
	

}
