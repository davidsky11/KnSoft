package com.kn.client;

import android.util.Log;
import com.kn.entity.Grade_2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class Grade_2Client extends BaseClient {
	private static final String TAG = "Grade_2Client";

	public static List<Grade_2> grade_2List(int paramInt) {
		ArrayList localArrayList = new ArrayList();
		HashMap localHashMap = new HashMap();
		localHashMap.put("keyValue", Integer.valueOf(paramInt));
		localHashMap.put("keyName", "grade_1_id");
		try {
			SoapObject localSoapObject1 = getSoapObject(localHashMap,
					"grade_2", "findEntityListByForeignKey");
			if (localSoapObject1 == null) {
				Log.e(TAG, "soapObject为空");
				return null;
			}
			SoapObject localSoapObject2 = (SoapObject) localSoapObject1
					.getProperty(0);
			Log.e(TAG, "*" + localSoapObject2.getPropertyCount());
			for (int i = 0; i < localSoapObject2.getPropertyCount(); i++) {
				SoapObject localSoapObject3 = (SoapObject) localSoapObject2
						.getProperty(i);
				Grade_2 localGrade_2 = new Grade_2();
				localGrade_2.setId(Integer.parseInt(localSoapObject3
						.getPropertyAsString("id")));
				localGrade_2.setGrade_2_name(localSoapObject3
						.getPropertyAsString("grade_2_name"));
				localGrade_2.setGrade_1_id(paramInt);
				localArrayList.add(localGrade_2);
				Log.e(TAG, "*:" + localGrade_2);
			}
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return localArrayList;
	}
}
