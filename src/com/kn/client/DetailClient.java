package com.kn.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kn.entity.Detail;

public class DetailClient extends BaseClient {
	
	private static final String TAG = "DetailClient";

	public static List<Detail> detailList(int param) {
		ArrayList list = new ArrayList();
		HashMap localHashMap = new HashMap();
		localHashMap.put("keyValue", Integer.valueOf(param));
		localHashMap.put("keyName", "grade_3_id");

		return list;
	}
}