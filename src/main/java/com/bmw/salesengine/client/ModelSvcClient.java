package com.bmw.salesengine.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "bmw-sales-gateway")
public interface ModelSvcClient {
	@RequestMapping(value = "/model/models", method = RequestMethod.GET)
	ResponseEntity<Object> getModels();
	
	@RequestMapping(value = "/model/models/oem", method = RequestMethod.GET)
	ResponseEntity<Object> getOemModels();

}