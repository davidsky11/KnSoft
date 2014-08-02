package com.kn.client;

import android.util.Log;
import com.kn.entity.Grade_1;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.SoapObject;

public class Grade_1Client extends BaseClient {
	private static final String TAG = "Grade_1Client";

	public static List<Grade_1> grade_1List() {
		ArrayList localArrayList = new ArrayList();
		try {
			SoapObject localSoapObject1 = getSoapObject(null, "grade_1",
					"findAll");
			if (localSoapObject1 == null) {
				Log.e("Grade_1Client", "soapObject为空");
				return null;
			}
			SoapObject localSoapObject2 = (SoapObject) localSoapObject1
					.getProperty(0);
			Log.e("Grade_1Client", "*" + localSoapObject2.getPropertyCount());
			for (int i = 0; i < localSoapObject2.getPropertyCount(); i++) {
				SoapObject localSoapObject3 = (SoapObject) localSoapObject2
						.getProperty(i);
				Grade_1 localGrade_1 = new Grade_1();
				localGrade_1.setId(Integer.parseInt(localSoapObject3
						.getPropertyAsString("id")));
				localGrade_1.setGrade_1_name(localSoapObject3
						.getPropertyAsString("grade_1_name"));
				localArrayList.add(localGrade_1);
				Log.e("Grade_1Client", "*:" + localGrade_1);
			}
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return localArrayList;
	}
}

/*
 * Location: C:\Users\davidsky\Desktop\AUTOID7\AutoidPDA_22336439500900.jar
 * Qualified Name: com.seuic.client.Grade_1Client JD-Core Version: 0.6.0
 */