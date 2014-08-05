package com.kn.client;

import android.util.Log;
import com.kn.entity.Grade_2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class Grade_2Client extends BaseClient {

	private static final String TAG = "Grade_2Client";

	public static List<Grade_2> grade_2List(int param) {
		ArrayList list = new ArrayList();
		HashMap hm = new HashMap();
		hm.put("keyValue", Integer.valueOf(param));
		hm.put("keyName", "grade_1_id");
		try {
			SoapObject so1 = getSoapObject(hm, "grade_2",
					"findEntityListByForeignKey");
			if (so1 == null) {
				Log.e(TAG, "soapObject为空");
				return null;
			}
			SoapObject so2 = (SoapObject) so1.getProperty(0);
			Log.e(TAG, "*" + so2.getPropertyCount());
			for (int i = 0; i < so2.getPropertyCount(); i++) {
				SoapObject so3 = (SoapObject) so2.getProperty(i);
				Grade_2 grade_2 = new Grade_2();
				grade_2.setId(Integer.parseInt(so3.getPropertyAsString("id")));
				grade_2.setGrade_2_name(so3.getPropertyAsString("grade_2_name"));
				grade_2.setGrade_1_id(param);
				list.add(grade_2);
				Log.e(TAG, "*:" + grade_2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
