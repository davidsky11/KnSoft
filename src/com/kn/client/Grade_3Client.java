package com.kn.client;

import android.util.Log;
import com.kn.entity.Grade_3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class Grade_3Client extends BaseClient {

	private static final String TAG = "Grade_2Client";

	public static List<Grade_3> grade_3List(int paramInt) {
		ArrayList list = new ArrayList();
		HashMap hm = new HashMap();
		hm.put("keyValue", Integer.valueOf(paramInt));
		hm.put("keyName", "grade_2_id");
		try {
			SoapObject so1 = getSoapObject(hm, "grade_3",
					"findEntityListByForeignKey");
			if (so1 == null) {
				Log.e(TAG, "soapObject为空");
				return null;
			}
			SoapObject so2 = (SoapObject) so1.getProperty(0);
			Log.e(TAG, "*" + so2.getPropertyCount());
			for (int i = 0; i < so2.getPropertyCount(); i++) {
				SoapObject so3 = (SoapObject) so2.getProperty(i);
				Grade_3 grade_3 = new Grade_3();
				grade_3.setId(Integer.parseInt(so3.getPropertyAsString("id")));
				grade_3.setGrade_3_name(so3.getPropertyAsString("grade_3_name"));
				grade_3.setGrade_2_id(paramInt);
				list.add(grade_3);
				Log.e(TAG, "*:" + grade_3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
