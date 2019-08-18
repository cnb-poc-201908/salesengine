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
public class Recursive {

	@Autowired
	private MaterialsMapper materials;

	@Autowired
	private OrderMapper orders;

	@Autowired
	private Aggregation aggreationSvc;

	public ArrayList<Object> processPhaseThree() {

		List<GroupModel> group1materials = materials.group1Materials();

		List<GroupModel> group1order = orders.group1Order();

		ArrayList<Object> phaseRecursive = GenerateGroup.iterateMatch(group1materials, group1order);

		ArrayList<Object> paseRecursiveTwo = aggreationSvc.processPhaseOne1(phaseRecursive);

		return paseRecursiveTwo;

	}

	public ArrayList<Object> processPhaseThree1() {

		List<GroupModel> group2materials = materials.group2Materials();

		List<GroupModel> group2order = orders.group2Order();

		ArrayList<Object> phaseRecursive = GenerateGroup.iterateMatch(group2materials, group2order);

		ArrayList<Object> paseRecursiveTwo = aggreationSvc.processPhaseOne2(phaseRecursive);

		return paseRecursiveTwo;

	}

	public ArrayList<Object> processPhaseThree2() {

		List<GroupModel> group2materials = materials.group2Materials();

		List<GroupModel> group2order = orders.group2Order();

		ArrayList<Object> phaseRecursive = GenerateGroup.iterateMatch(group2materials, group2order);

		ArrayList<Object> paseRecursiveTwo = aggreationSvc.processPhaseOne2(phaseRecursive);

		return paseRecursiveTwo;

	}

}
