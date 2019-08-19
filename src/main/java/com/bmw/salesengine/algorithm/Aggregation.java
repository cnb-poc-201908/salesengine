package com.bmw.salesengine.algorithm;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmw.salesengine.mapper.MaterialsIdMapper;
import com.bmw.salesengine.mapper.OrderIdMapper;

@Service
public class Aggregation {

	@Autowired
	private OrderIdMapper orderidmapper;

	@Autowired
	private MaterialsIdMapper materialsidmapper;

	public ArrayList<Object> processPhaseOne(ArrayList<Object> phase) {

		ArrayList<Object> phase2 = new ArrayList<>();

		for (int i = 0; i < phase.size(); i++) {
			if (Integer.valueOf(phase.get(i).toString().split("!!")[1]) >= Integer
					.valueOf(phase.get(i).toString().split("!!")[2])) {

				String gn = phase.get(i).toString().split("!!")[0];
				ArrayList<Object> orderlist = orderidmapper.orderList(gn);
				ArrayList<Object> materialslist = materialsidmapper.materialsList(gn);

				for (int e = 0; e < orderlist.size(); e++) {
					System.out.println(orderlist.get(e) + "--------" + materialslist.get(e));
					orderidmapper.updateOrderId(orderlist.get(e).toString(), materialslist.get(e).toString());
					materialsidmapper.updateMaterialsId(materialslist.get(e).toString(), orderlist.get(e).toString());
				}

			} else {
				// String gn = phase.get(i).toString().split("!!")[0];
				// System.out.println("pahseTwo");
				// System.out.println(phase.get(i));
				phase2.add(phase.get(i));
			}
		}

		return phase2;

	}

	public ArrayList<Object> processPhaseOne1(ArrayList<Object> phase) {

		ArrayList<Object> phase2 = new ArrayList<>();

		for (int i = 0; i < phase.size(); i++) {
			if (Integer.valueOf(phase.get(i).toString().split("!!")[1]) >= Integer
					.valueOf(phase.get(i).toString().split("!!")[2])) {

				String gn = phase.get(i).toString().split("!!")[0];
				ArrayList<Object> orderlist = orderidmapper.orderList1(gn);
				ArrayList<Object> materialslist = materialsidmapper.materialsList1(gn);

				for (int e = 0; e < orderlist.size(); e++) {
					System.out.println(orderlist.get(e) + "--------" + materialslist.get(e));
					orderidmapper.updateOrderId1(orderlist.get(e).toString(), materialslist.get(e).toString());
					materialsidmapper.updateMaterialsId1(materialslist.get(e).toString(), orderlist.get(e).toString());
				}

			} else {
				// String gn = phase.get(i).toString().split("!!")[0];
				// System.out.println("pahseTwo");
				// System.out.println(phase.get(i));
				phase2.add(phase.get(i));
			}
		}

		return phase2;

	}

	public ArrayList<Object> processPhaseOne2(ArrayList<Object> phase) {

		ArrayList<Object> phase2 = new ArrayList<>();

		for (int i = 0; i < phase.size(); i++) {
			if (Integer.valueOf(phase.get(i).toString().split("!!")[1]) >= Integer
					.valueOf(phase.get(i).toString().split("!!")[2])) {

				String gn = phase.get(i).toString().split("!!")[0];
				ArrayList<Object> orderlist = orderidmapper.orderList2(gn);
				ArrayList<Object> materialslist = materialsidmapper.materialsList2(gn);

				for (int e = 0; e < orderlist.size(); e++) {
					System.out.println(orderlist.get(e) + "--------" + materialslist.get(e));
					orderidmapper.updateOrderId1(orderlist.get(e).toString(), materialslist.get(e).toString());
					materialsidmapper.updateMaterialsId1(materialslist.get(e).toString(), orderlist.get(e).toString());
				}

			} else {
				// String gn = phase.get(i).toString().split("!!")[0];
				// System.out.println("pahseTwo");
				// System.out.println(phase.get(i));
				phase2.add(phase.get(i));
			}
		}

		return phase2;

	}

	public ArrayList<Object> processRecursiveGroup(ArrayList<Object> phase) {

		ArrayList<Object> phase2 = new ArrayList<>();

		for (int i = 0; i < phase.size(); i++) {
			if (Integer.valueOf(phase.get(i).toString().split("!!")[1]) >= Integer
					.valueOf(phase.get(i).toString().split("!!")[2])) {

				String gn = phase.get(i).toString().split("!!")[0];
				ArrayList<Object> orderlist = orderidmapper.orderListColor(gn);
				ArrayList<Object> materialslist = materialsidmapper.materialsListColor(gn);

				for (int e = 0; e < orderlist.size(); e++) {
					System.out.println(orderlist.get(e) + "--------" + materialslist.get(e));
					orderidmapper.updateOrderId1(orderlist.get(e).toString(), materialslist.get(e).toString());
					materialsidmapper.updateMaterialsId1(materialslist.get(e).toString(), orderlist.get(e).toString());
				}

			} else {
				// String gn = phase.get(i).toString().split("!!")[0];
				// System.out.println("pahseTwo");
				// System.out.println(phase.get(i));
				phase2.add(phase.get(i));
			}
		}

		return phase2;

	}

	public ArrayList<Object> processRecursiveUpholstery(ArrayList<Object> phase) {

		ArrayList<Object> phase2 = new ArrayList<>();

		for (int i = 0; i < phase.size(); i++) {
			if (Integer.valueOf(phase.get(i).toString().split("!!")[1]) >= Integer
					.valueOf(phase.get(i).toString().split("!!")[2])) {

				String gn = phase.get(i).toString().split("!!")[0];
				ArrayList<Object> orderlist = orderidmapper.orderListUpholstery(gn);
				ArrayList<Object> materialslist = materialsidmapper.materialsListUpholstery(gn);

				for (int e = 0; e < orderlist.size(); e++) {
					System.out.println(orderlist.get(e) + "--------" + materialslist.get(e));
					orderidmapper.updateOrderId1(orderlist.get(e).toString(), materialslist.get(e).toString());
					materialsidmapper.updateMaterialsId1(materialslist.get(e).toString(), orderlist.get(e).toString());
				}

			} else {
				// String gn = phase.get(i).toString().split("!!")[0];
				// System.out.println("pahseTwo");
				// System.out.println(phase.get(i));
				phase2.add(phase.get(i));
			}
		}

		return phase2;

	}

	public ArrayList<Object> processRecursiveConfig(ArrayList<Object> phase) {

		ArrayList<Object> phase2 = new ArrayList<>();

		for (int i = 0; i < phase.size(); i++) {
			if (Integer.valueOf(phase.get(i).toString().split("!!")[1]) >= Integer
					.valueOf(phase.get(i).toString().split("!!")[2])) {

				String gn = phase.get(i).toString().split("!!")[0];
				ArrayList<Object> orderlist = orderidmapper.orderListConfig(gn);
				ArrayList<Object> materialslist = materialsidmapper.materialsListConfig(gn);

				for (int e = 0; e < orderlist.size(); e++) {
					System.out.println(orderlist.get(e) + "--------" + materialslist.get(e));
					orderidmapper.updateOrderId1(orderlist.get(e).toString(), materialslist.get(e).toString());
					materialsidmapper.updateMaterialsId1(materialslist.get(e).toString(), orderlist.get(e).toString());
				}

			} else {
				// String gn = phase.get(i).toString().split("!!")[0];
				// System.out.println("pahseTwo");
				// System.out.println(phase.get(i));
				phase2.add(phase.get(i));
			}
		}

		return phase2;

	}

	public ArrayList<Object> processRecursiveAddCode(ArrayList<Object> phase) {

		ArrayList<Object> phase2 = new ArrayList<>();

		for (int i = 0; i < phase.size(); i++) {
			if (Integer.valueOf(phase.get(i).toString().split("!!")[1]) >= Integer
					.valueOf(phase.get(i).toString().split("!!")[2])) {

				String gn = phase.get(i).toString().split("!!")[0];
				ArrayList<Object> orderlist = orderidmapper.orderListAddCode(gn);
				ArrayList<Object> materialslist = materialsidmapper.materialsListAddCode(gn);

				for (int e = 0; e < orderlist.size(); e++) {
					System.out.println(orderlist.get(e) + "--------" + materialslist.get(e));
					orderidmapper.updateOrderId1(orderlist.get(e).toString(), materialslist.get(e).toString());
					materialsidmapper.updateMaterialsId1(materialslist.get(e).toString(), orderlist.get(e).toString());
				}

			} else {
				// String gn = phase.get(i).toString().split("!!")[0];
				// System.out.println("pahseTwo");
				phase2.add(phase.get(i));
			}
		}

		return phase2;

	}

}
