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
		ArrayList localArrayList = new ArrayList();
		HashMap localHashMap = new HashMap();
		localHashMap.put("keyValue", Integer.valueOf(paramInt));
		localHashMap.put("keyName", "grade_2_id");
		try {
			SoapObject localSoapObject1 = getSoapObject(localHashMap,
					"grade_3", "findEntityListByForeignKey");
			if (localSoapObject1 == null) {
				Log.e("Grade_2Client", "soapObject为空");
				return null;
			}
			SoapObject localSoapObject2 = (SoapObject) localSoapObject1
					.getProperty(0);
			Log.e("Grade_2Client", "*" + localSoapObject2.getPropertyCount());
			for (int i = 0; i < localSoapObject2.getPropertyCount(); i++) {
				SoapObject localSoapObject3 = (SoapObject) localSoapObject2
						.getProperty(i);
				Grade_3 localGrade_3 = new Grade_3();
				localGrade_3.setId(Integer.parseInt(localSoapObject3
						.getPropertyAsString("id")));
				localGrade_3.setGrade_3_name(localSoapObject3
						.getPropertyAsString("grade_3_name"));
				localGrade_3.setGrade_2_id(paramInt);
				localArrayList.add(localGrade_3);
				Log.e("Grade_2Client", "*:" + localGrade_3);
			}
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return localArrayList;
	}
}

/*
 * Location: C:\Users\davidsky\Desktop\AUTOID7\AutoidPDA_22336439500900.jar
 * Qualified Name: com.seuic.client.Grade_3Client JD-Core Version: 0.6.0
 */