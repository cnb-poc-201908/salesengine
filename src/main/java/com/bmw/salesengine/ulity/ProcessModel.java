package com.bmw.salesengine.ulity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProcessModel {

	// public static void main(String[] args) {
	//
	// ArrayList<Object> dealersweight = new ArrayList<>();
	//
	// ArrayList<Object> dealers = new ArrayList<>();
	// Map<String, String> map = new TreeMap<String, String>();
	// map.put("D001", "1");
	// map.put("D002", "2");
	// map.put("D003", "5");
	// map.put("D004", "3");
	// Map<String, String> resultMap = sortMapByValue(map); //按Value进行排序
	// for (Map.Entry<String, String> entry : resultMap.entrySet()) {
	// System.out.println(entry.getKey() + " " + entry.getValue());
	// dealersweight.add(entry.getValue());
	// }
	// for (int i = dealersweight.size() - 1; i >= 0; i--) {
	// dealers.add(dealersweight.get(i));
	// }
	//
	// System.out.println(dealers.toString());
	// }

	public static ArrayList<Object> sortModel(Map<String, String> map) {
		ArrayList<Object> dealersweight = new ArrayList<>();

		ArrayList<Object> dealers = new ArrayList<>();

		Map<String, String> resultMap = sortMapByValue(map); // 按Value进行排序
		for (Map.Entry<String, String> entry : resultMap.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//			dealersweight.add(entry.getValue());
			dealersweight.add(entry.getKey());
		}
		for (int i = dealersweight.size() - 1; i >= 0; i--) {
			dealers.add(dealersweight.get(i));
		}

		return dealers;

	}

	/**
	 * 使用 Map按value进行排序
	 * 
	 * @param map
	 * @return
	 */
	private static Map<String, String> sortMapByValue(Map<String, String> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, String> sortedMap = new LinkedHashMap<String, String>();
		List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		Collections.sort(entryList, new MapValueComparator());
		Iterator<Map.Entry<String, String>> iter = entryList.iterator();
		Map.Entry<String, String> tmpEntry = null;
		while (iter.hasNext()) {
			tmpEntry = iter.next();
			sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
		}
		return sortedMap;
	}

}
