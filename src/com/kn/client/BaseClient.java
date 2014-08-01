package com.kn.client;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class BaseClient {
	private static final String BASE_LOCATION = "http://192.168.40.153:8080/SeuicService/services/";
	private static final String TAG = "BaseClient";
	private static final String TARGET_NAMESPACE = "http://service.whl.seuic.com/";

	public static SoapObject getSoapObject(
			HashMap<String, Object> paramHashMap, String paramString1,
			String paramString2) throws Exception {
		SoapSerializationEnvelope localSoapSerializationEnvelope = new SoapSerializationEnvelope(
				110);
		SoapObject localSoapObject = new SoapObject(
				"http://service.whl.seuic.com/", paramString2);
		Iterator localIterator = null;
		if (paramHashMap != null)
			localIterator = paramHashMap.entrySet().iterator();
		while (true) {
			if (!localIterator.hasNext()) {
				localSoapSerializationEnvelope.bodyOut = localSoapObject;
				HttpTransportSE localHttpTransportSE = new HttpTransportSE(
						"http://192.168.40.153:8080/SeuicService/services/"
								+ paramString1);
				localHttpTransportSE.debug = true;
				localHttpTransportSE.call("http://service.whl.seuic.com/"
						+ paramString2, localSoapSerializationEnvelope);
				if (localSoapSerializationEnvelope.getResponse() == null)
					break;
				return (SoapObject) localSoapSerializationEnvelope.bodyIn;
			}
			Map.Entry localEntry = (Map.Entry) localIterator.next();
			String str = (String) localEntry.getKey();
			Object localObject = localEntry.getValue();
			Log.d("BaseClient", "paramName=" + str);
			Log.d("BaseClient", "paramValue=" + localObject.toString());
			localSoapObject.addProperty(str, localObject);
		}
		return null;
	}
}
