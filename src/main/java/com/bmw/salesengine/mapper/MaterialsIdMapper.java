package com.bmw.salesengine.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MaterialsIdMapper {
	
	@Select("SELECT \"materialsId\"\n" + 
			"	FROM sales.materials where \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yeartype\"||':'|| \"configCode\"||':'||\"addCode\" = #{gn} and \"orderId\" is null")
	ArrayList<Object>materialsList(@Param("gn") String gn);
	
	@Select("SELECT \"materialsId\"\n" + 
			"	FROM sales.materials where \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yeartype\"||':'|| \"configCode\" = #{gn} and \"orderId\" is null")
	ArrayList<Object>materialsList1(@Param("gn") String gn);
	
	@Select("SELECT \"materialsId\"\n" + 
			"	FROM sales.materials where \"colorCode\"  ||':'|| \"yeartype\"||':'|| \"configCode\" = #{gn} and \"orderId\" is null")
	ArrayList<Object>materialsList2(@Param("gn") String gn);
	
	
	@Select("SELECT \"materialsId\"\n" + 
			"	FROM sales.materials where \"colorCode\" = #{gn} and \"orderId\" is null")
	ArrayList<Object>materialsListColor(@Param("gn") String gn);

	
	@Select("SELECT \"materialsId\"\n" + 
			"	FROM sales.materials where \"upholsteryCode\" = #{gn} and \"orderId\" is null")
	ArrayList<Object>materialsListUpholstery(@Param("gn") String gn);
	
	@Select("SELECT \"materialsId\"\n" + 
			"	FROM sales.materials where \"yeartype\"||':'|| \"configCode\" = #{gn} and \"orderId\" is null")
	ArrayList<Object>materialsListConfig(@Param("gn") String gn);
	
	@Select("SELECT \"materialsId\"\n" + 
			"	FROM sales.materials where  \"addCode\" = #{gn} and \"orderId\" is null")
	ArrayList<Object>materialsListAddCode(@Param("gn") String gn);
	
	@Update("UPDATE sales.\"materials\"\n" + 
			"	SET \"orderId\"=#{orderId}, \"matchStatus\" ='1' \n" + 
			"	WHERE \"materialsId\" = #{materialsId};")
	void updateMaterialsId(@Param("materialsId")String materialsId, @Param("orderId")String orderId);
	
	@Update("UPDATE sales.\"materials\"\n" + 
			"	SET \"orderId\"=#{orderId}, \"matchStatus\" ='2' \n" + 
			"	WHERE \"materialsId\" = #{materialsId};")
	void updateMaterialsId1(@Param("materialsId")String materialsId, @Param("orderId")String orderId);
	
	@Update("UPDATE sales.\"materials\"\n" + 
			"	SET \"orderId\"=#{orderId}, \"matchStatus\" ='3' \n" + 
			"	WHERE \"materialsId\" = #{materialsId};")
	void updateMaterialsId2(@Param("materialsId")String materialsId, @Param("orderId")String orderId);
	
	@Update("UPDATE sales.\"materials\"\n" + 
			"	SET \"orderId\" = null, \"matchStatus\" = null")
	void resetMaterialsId();

}
