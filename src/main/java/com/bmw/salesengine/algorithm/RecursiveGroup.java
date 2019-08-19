package com.bmw.salesengine.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmw.salesengine.mapper.MaterialsMapper;
import com.bmw.salesengine.mapper.OrderMapper;
import com.bmw.salesengine.model.GroupModel;
import com.bmw.salesengine.ulity.GenerateGroup;

@Service
public class RecursiveGroup {
	
	@Autowired
	private MaterialsMapper materials;

	@Autowired
	private OrderMapper orders;
	
	@Autowired
	private Aggregation aggreationSvc;
	
	@Autowired
	private AddWeight addweightSvc;

	public void processRecusive(ArrayList<Object> oemmodel, ArrayList<Object> dealermodel) {

		for (int x = 0; x < oemmodel.size(); x++) {

			if (oemmodel.get(x).equals("color")) {
				
				List<GroupModel> group3materials = materials.group3Materials();

				List<GroupModel> group3order = orders.group3Order();

				ArrayList<Object> phaseRecursiveGroup = GenerateGroup.iterateMatch(group3materials, group3order);

				ArrayList<Object> paseRecursiveTwo = aggreationSvc.processRecursiveGroup(phaseRecursiveGroup);
					
				addweightSvc.processPhaseColor(paseRecursiveTwo, dealermodel);
				

			} else if (oemmodel.get(x).equals("upholstery")) {
				
				List<GroupModel> group5materials = materials.group5Materials();

				List<GroupModel> group5order = orders.group5Order();

				ArrayList<Object> phaseRecursiveGroup = GenerateGroup.iterateMatch(group5materials, group5order);

				ArrayList<Object> paseRecursiveTwo = aggreationSvc.processRecursiveUpholstery(phaseRecursiveGroup);
					
				addweightSvc.processPhaseUpholstery(paseRecursiveTwo, dealermodel);


			} else if (oemmodel.get(x).equals("config")) {
				
				List<GroupModel> group4materials = materials.group4Materials();

				List<GroupModel> group4order = orders.group4Order();

				ArrayList<Object> phaseRecursiveGroup = GenerateGroup.iterateMatch(group4materials, group4order);

				ArrayList<Object> paseRecursiveTwo = aggreationSvc.processRecursiveConfig(phaseRecursiveGroup);
					
				addweightSvc.processPhaseConfig(paseRecursiveTwo, dealermodel);


			} else if (oemmodel.get(x).equals("addCode")) {
				
				List<GroupModel> group6materials = materials.group6Materials();

				List<GroupModel> group6order = orders.group6Order();

				ArrayList<Object> phaseRecursiveGroup = GenerateGroup.iterateMatch(group6materials, group6order);

				ArrayList<Object> paseRecursiveTwo = aggreationSvc.processRecursiveAddCode(phaseRecursiveGroup);
					
				addweightSvc.processPhaseAddCode(paseRecursiveTwo, dealermodel);

				
			}
			

		}
		

	}

}
