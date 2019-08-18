package com.bmw.salesengine.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bmw.salesengine.model.DealerOrders;

@Mapper
public interface OrderIdMapper {
	@Select("SELECT \"orderId\"\n" + 
			"	FROM sales.\"order\" where \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yearType\"||':'|| \"configCode\"||':'||\"addCode\" = #{gn} and \"materialsId\" is null")
	ArrayList<Object> orderList(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\"\n" + 
			"	FROM sales.\"order\" where \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yearType\"||':'|| \"configCode\" = #{gn} and \"materialsId\" is null")
	ArrayList<Object> orderList1(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\"\n" + 
			"	FROM sales.\"order\" where \"colorCode\"  ||':'||  \"yearType\"||':'|| \"configCode\" = #{gn} and \"materialsId\" is null")
	ArrayList<Object> orderList2(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\"\n" + 
			"	FROM sales.\"order\" where \"colorCode\"  = #{gn} and \"materialsId\" is null")
	ArrayList<Object> orderListColor(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\"\n" + 
			"	FROM sales.\"order\" where \"upholsteryCode\"  = #{gn} and \"materialsId\" is null")
	ArrayList<Object> orderListUpholstery(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\"\n" + 
			"	FROM sales.\"order\" where  \"yearType\"||':'|| \"configCode\"  = #{gn} and \"materialsId\" is null")
	ArrayList<Object> orderListConfig(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\"\n" + 
			"	FROM sales.\"order\" where \"addCode\"  = #{gn} and \"materialsId\" is null")
	ArrayList<Object> orderListAddCode(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\", \"dealerId\"\n" + 
			"	FROM sales.order where \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yearType\"||':'|| \"configCode\"||':'||\"addCode\" = #{gn} and \"materialsId\" is null")
	List<DealerOrders> dealerorderList(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\", \"dealerId\"\n" + 
			"	FROM sales.order where \"colorCode\"  ||':'|| \"upholsteryCode\" ||':'|| \"yearType\"||':'|| \"configCode\" = #{gn} and \"materialsId\" is null")
	List<DealerOrders> dealerorderList1(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\", \"dealerId\"\n" + 
			"	FROM sales.order where \"colorCode\"  ||':'||  \"yearType\"||':'|| \"configCode\" = #{gn} and \"materialsId\" is null")
	List<DealerOrders> dealerorderList2(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\", \"dealerId\"\n" + 
			"	FROM sales.order where \"colorCode\" = #{gn} and \"materialsId\" is null")
	List<DealerOrders> dealerorderListColor(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\", \"dealerId\"\n" + 
			"	FROM sales.order where \"upholsteryCode\" = #{gn} and \"materialsId\" is null")
	List<DealerOrders> dealerorderListUpholstery(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\", \"dealerId\"\n" + 
			"	FROM sales.order where \"yearType\"||':'|| \"configCode\" = #{gn} and \"materialsId\" is null")
	List<DealerOrders> dealerorderListConfig(@Param("gn") String gn);
	
	@Select("SELECT \"orderId\", \"dealerId\"\n" + 
			"	FROM sales.order where \"addCode\" = #{gn} and \"materialsId\" is null")
	List<DealerOrders> dealerorderListAddCode(@Param("gn") String gn);
	

	@Update("UPDATE sales.\"order\"\n" + 
			"	SET \"materialsId\"=#{materialsId}, \"matchStatus\" ='1', \"dealerStatus\" ='1'\n" + 
			"	WHERE \"orderId\" = #{orderId}")
	void updateOrderId(@Param("orderId")String orderId, @Param("materialsId")String materialsId);
	
	@Update("UPDATE sales.\"order\"\n" + 
			"	SET \"materialsId\"=#{materialsId}, \"matchStatus\" ='2', \"dealerStatus\" ='1'\n" + 
			"	WHERE \"orderId\" = #{orderId}")
	void updateOrderId1(@Param("orderId")String orderId, @Param("materialsId")String materialsId);
	
	@Update("UPDATE sales.\"order\"\n" + 
			"	SET \"materialsId\"=#{materialsId}, \"matchStatus\" ='3', \"dealerStatus\" ='1'\n" + 
			"	WHERE \"orderId\" = #{orderId}")
	void updateOrderId2(@Param("orderId")String orderId, @Param("materialsId")String materialsId);
	
	@Update("UPDATE sales.\"order\"\n" + 
			"	SET \"materialsId\" = null, \"matchStatus\" = null, \"dealerStatus\" = 0")
	void resetOrderId();

}
