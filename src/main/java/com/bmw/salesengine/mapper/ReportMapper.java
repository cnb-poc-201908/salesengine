package com.bmw.salesengine.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bmw.salesengine.model.DealerReportModel;
import com.bmw.salesengine.model.ReportModel;

@Mapper
public interface ReportMapper {
	
	@Select("select (select count(*) FROM sales.\"order\") as summary, (SELECT count(*) FROM sales.\"order\" where \"matchStatus\" = '1') as best, (SELECT count(*) FROM sales.\"order\" where \"matchStatus\" = '2') as prefer, (SELECT count(*) FROM sales.\"order\" where \"matchStatus\" = '3') as recommand from sales.\"order\" group by summary")
	ReportModel report();
	
	@Select("SELECT a.\"dealerId\",b.count as total,a.count as unmatch, round( cast ( a.count as numeric )/ cast( b.count as numeric),2)*100 as ratio from (SELECT \"dealerId\",count(\"dealerId\")\n" + 
			"	FROM sales.\"order\" where \"matchStatus\" != '1' group by \"dealerId\")a, (SELECT \"dealerId\",count(\"dealerId\")\n" + 
			"	FROM sales.\"order\" group by \"dealerId\") b where a.\"dealerId\" =b.\"dealerId\" order by ratio desc")
	List<DealerReportModel> dealreport();
	

}
