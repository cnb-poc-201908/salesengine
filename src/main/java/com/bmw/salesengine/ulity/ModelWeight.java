package com.bmw.salesengine.ulity;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONObject;

public class ModelWeight {

	public static Map<String, String> iterateModel(JSONObject modeldata) {

		Map<String, String> modelmap = new TreeMap<String, String>();
		Iterator<String> sIterator = modeldata.keys();
		while (sIterator.hasNext()) {

			String key = sIterator.next().toString();

			JSONObject value = modeldata.getJSONObject(key);
			Iterator<String> sIterator1 = value.keys();
			// System.out.println(key);
			Double keyweight1 = 0.00;
			Integer weightvalue = 0;
			while (sIterator1.hasNext()) {

				String key1 = sIterator1.next().toString();

				JSONObject value1 = value.getJSONObject(key1);
				Float keyweight = value1.getInt("weight") * value1.getFloat("value");

				keyweight1 = keyweight1 + keyweight;
				weightvalue = weightvalue + value1.getInt("weight");
			}

			DecimalFormat df2 = new DecimalFormat("#.###");
			// System.out.println(df2.format(keyweight1/weightvalue));
			modelmap.put(key, df2.format(keyweight1 / weightvalue));

		}

		return modelmap;

	}

	public static Map<String, String> iterateOemModel(JSONObject modeldata) {

		Map<String, String> modelmap = new TreeMap<String, String>();
		Iterator<String> sIterator = modeldata.keys();
		while (sIterator.hasNext()) {

			String key = sIterator.next().toString();

			Integer value = modeldata.getJSONObject(key).getInt("weight");

			modelmap.put(key, value.toString());

		}

		return modelmap;

	}

}
