package com.bmw.salesengine.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bmw.salesengine.model.GroupModel;
import com.bmw.salesengine.model.GroupSimilar;

@Mapper
public interface MaterialsMapper {
	// all
	@Select("SELECT \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yeartype\"||':'|| \"configCode\"||':'||\"addCode\" as groupname , count(\"colorCode\" || \"upholsteryCode\" ||\"yeartype\"|| \"configCode\"||\"addCode\") as groupnumber\n" + 
			"	FROM sales.materials where \"orderId\" is null group by groupname")
	List<GroupModel> groupMaterials();
	// color + upholstery + cartype
	@Select("SELECT \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'||  \"yeartype\"||':'|| \"configCode\" as groupname , count(\"colorCode\" ||\"upholsteryCode\" ||\"yeartype\"|| \"configCode\") as groupnumber\n" + 
			"	FROM sales.materials where \"orderId\" is null group by groupname")
	List<GroupModel> group1Materials();
	
	// color + cartype
	@Select("SELECT \"colorCode\"  ||':'||  \"yeartype\"||':'|| \"configCode\" as groupname , count(\"colorCode\" ||\"yeartype\"|| \"configCode\") as groupnumber\n" + 
			"	FROM sales.materials where \"orderId\" is null group by groupname")
	List<GroupModel> group2Materials();
	
	//color
	@Select("SELECT \"colorCode\" as groupname , count(\"colorCode\") as groupnumber\n" + 
			"	FROM sales.materials where \"orderId\" is null group by groupname")
	List<GroupModel> group3Materials();
	
	//car type
	@Select("SELECT \"yeartype\"||':'|| \"configCode\" as groupname , count(\"yeartype\"|| \"configCode\") as groupnumber\n" + 
			"	FROM sales.materials where \"orderId\" is null group by groupname")
	List<GroupModel> group4Materials();
	
	//upholstery
	@Select("SELECT \"upholsteryCode\" as groupname , count(\"upholsteryCode\") as groupnumber\n" + 
			"	FROM sales.materials where \"orderId\" is null group by groupname")
	List<GroupModel> group5Materials();
	
	//addcode
	@Select("SELECT \"addCode\"  as groupname , count(\"addCode\") as groupnumber\n" + 
			"	FROM sales.materials where \"orderId\" is null group by groupname")
	List<GroupModel> group6Materials();
	
	//similar
	
	@Select("SELECT \"materialsId\" as id,\"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yeartype\"||':'|| \"configCode\"||':'||\"addCode\" as groupname \n" + 
			"	FROM sales.materials where \"orderId\" is null ")
	List<GroupSimilar> groupSimilar();

}
