package com.kn.client;

import android.util.Log;
import com.kn.entity.Grade_1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class Grade_1Client extends BaseClient {

	private static final String TAG = "Grade_1Client";

	public static List<Grade_1> grade_1List() {
		ArrayList list = new ArrayList();
		HashMap hashMap = new HashMap();
		try {
			SoapObject so1 = getSoapObject(hashMap, "grade_1", "findAll");
			if (so1 == null) {
				Log.e(TAG, "soapObject为空");
				return null;
			}
			SoapObject so2 = (SoapObject) so1.getProperty(0);
			Log.e(TAG, "*" + so2.getPropertyCount());
			for (int i = 0; i < so2.getPropertyCount(); i++) {
				SoapObject so3 = (SoapObject) so2.getProperty(i);
				Grade_1 grade_1 = new Grade_1();
				grade_1.setId(Integer.parseInt(so3
						.getPropertyAsString("id")));
				grade_1.setGrade_1_name(so3
						.getPropertyAsString("grade_1_name"));
				list.add(grade_1);
				Log.e(TAG, "*:" + grade_1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
