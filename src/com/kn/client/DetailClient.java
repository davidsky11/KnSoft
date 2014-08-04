package com.kn.client;

import android.util.Log;
import com.kn.entity.Detail;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class DetailClient extends BaseClient {
	private static final String TAG = "DetailClient";

	public static List<Detail> detailList(int paramInt) {
		ArrayList localArrayList = new ArrayList();
		HashMap localHashMap = new HashMap();
		localHashMap.put("keyValue", Integer.valueOf(paramInt));
		localHashMap.put("keyName", "grade_3_id");

		return localArrayList;
	}
}