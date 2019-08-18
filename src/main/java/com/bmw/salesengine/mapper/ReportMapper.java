package com.bmw.salesengine.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bmw.salesengine.model.ReportModel;

@Mapper
public interface ReportMapper {
	
	@Select("select (select count(*) FROM sales.\"order\") as summary, (SELECT count(*) FROM sales.\"order\" where \"matchStatus\" = '1') as best, (SELECT count(*) FROM sales.\"order\" where \"matchStatus\" = '2') as prefer, (SELECT count(*) FROM sales.\"order\" where \"matchStatus\" = '3') as recommand from sales.\"order\" group by summary")
	ReportModel report();
	

}
