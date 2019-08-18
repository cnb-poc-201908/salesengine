package com.bmw.salesengine.ulity;

import java.util.ArrayList;
import java.util.List;

import com.bmw.salesengine.model.GroupModel;

public class GenerateGroup {

	public static ArrayList<Object> iterateMatch(List<GroupModel> listobject, List<GroupModel> listobject1) {

		ArrayList<Object> m_group = new ArrayList<>();
		ArrayList<Object> m_group_number = new ArrayList<>();
		ArrayList<Object> o_group = new ArrayList<>();
		ArrayList<Object> o_group_number = new ArrayList<>();

		for (int i = 0; i < listobject.size(); i++) {
			m_group.add(listobject.get(i).getGroupname());
			m_group_number.add(listobject.get(i).getGroupnumber());

		}

		for (int i = 0; i < listobject1.size(); i++) {
			o_group.add(listobject1.get(i).getGroupname());
			o_group_number.add(listobject1.get(i).getGroupnumber());

		}

		ArrayList<Object> phaseOne = new ArrayList<>();

		if (m_group.size() > o_group.size()) {
			for (int i = 0; i < m_group.size(); i++) {
				if (o_group.contains(m_group.get(i))) {

					String matchResult = m_group.get(i).toString() + "!!" + m_group_number.get(i) + "!!"
							+ o_group_number.get(o_group.indexOf(m_group.get(i)));

					phaseOne.add(matchResult);

				}
			}

		} else {
			for (int i = 0; i < o_group.size(); i++) {
				if (m_group.contains(o_group.get(i))) {

					String matchResult = o_group.get(i).toString() + "!!"
							+ m_group_number.get(m_group.indexOf(o_group.get(i))) + "!!" + o_group_number.get(i);

					phaseOne.add(matchResult);

				}
			}

		}

		return phaseOne;

	}

}
