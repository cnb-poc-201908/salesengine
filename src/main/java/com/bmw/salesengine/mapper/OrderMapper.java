package com.bmw.salesengine.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bmw.salesengine.model.GroupModel;
import com.bmw.salesengine.model.GroupSimilar;

@Mapper
public interface OrderMapper {

	@Select("SELECT \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yearType\"||':'|| \"configCode\"||':'||\"addCode\" as groupname , count(\"colorCode\" || \"upholsteryCode\" ||\"yearType\"|| \"configCode\"||\"addCode\") as groupnumber\n"
			+ "	FROM sales.order where \"materialsId\" is null group by groupname")
	List<GroupModel> groupOrder();

	// color + upholstery + cartype
	@Select("SELECT \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yearType\"||':'|| \"configCode\" as groupname , count(\"colorCode\" || \"upholsteryCode\" ||\"yearType\"|| \"configCode\") as groupnumber\n"
			+ "	FROM sales.order where \"materialsId\" is null group by groupname")
	List<GroupModel> group1Order();

	// color + cartype
	@Select("SELECT \"colorCode\"  ||':'|| \"yearType\"||':'|| \"configCode\" as groupname , count(\"colorCode\" ||\"yearType\"|| \"configCode\") as groupnumber\n"
			+ "	FROM sales.order where \"materialsId\" is null group by groupname")
	List<GroupModel> group2Order();

	// color
	@Select("SELECT \"colorCode\" as groupname , count(\"colorCode\") as groupnumber\n"
			+ "	FROM sales.order where \"materialsId\" is null group by groupname")
	List<GroupModel> group3Order();

	// car type
	@Select("SELECT \"yearType\"||':'|| \"configCode\" as groupname , count(\"yearType\"|| \"configCode\") as groupnumber\n"
			+ "	FROM sales.order where \"materialsId\" is null group by groupname")
	List<GroupModel> group4Order();

	// upholstery
	@Select("SELECT \"upholsteryCode\" as groupname , count(\"upholsteryCode\") as groupnumber\n"
			+ "	FROM sales.order where \"materialsId\" is null group by groupname")
	List<GroupModel> group5Order();

	// addcode
	@Select("SELECT \"addCode\" as groupname , count(\"addCode\") as groupnumber\n" + 
			"	FROM sales.order where \"materialsId\" is null group by groupname")
	List<GroupModel> group6Order();
	
	@Select("SELECT \"orderId\" as id, \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yearType\"||':'|| \"configCode\"||':'||\"addCode\" as groupname \n" + 
			"	FROM sales.order where \"materialsId\" is null")
	List<GroupSimilar> groupSimilar();

}
