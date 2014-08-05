package com.kn.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class BaseClient {
	
	private static final String TAG = "BaseClient";
	
	private static final String TARGET_NAMESPACE = "http://service.whl.kn.com/";
	private static final String BASE_LOCATION = "http://10.0.2.2:8080/KnService/services/";

	/**
	 * 获取WebService的Soap对象
	 * @param hashMap
	 * @param str1	服务名
	 * @param str2	方法名
	 * @return
	 * @throws Exception
	 */
	public static SoapObject getSoapObject(
			HashMap<String, Object> hashMap, String str1,
			String str2) throws Exception {
		// 生成调用WebService方法的SOAP请求信息。版本号需要根据服务端WebService的版本号设置。
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);	
		// 指定WebService的命名空间和调用的方法名
		SoapObject request = new SoapObject(TARGET_NAMESPACE,
				str2);		
		Iterator iterator = null;
		if (hashMap != null)
			iterator = hashMap.entrySet().iterator();
		while (true) {
			if (!iterator.hasNext()) {
				envelope.bodyOut = request;
				// 创建HttpTransportSE对象，通过HttpTransportSE类的构造方法可以指定WebService的WSDL文档的URL
				HttpTransportSE ht = new HttpTransportSE(
						BASE_LOCATION + str1);
				ht.debug = true;
				// 使用call方法调用WebService方法
				ht.call(TARGET_NAMESPACE + str2, envelope);
				// 使用getResponse方法获得WebService方法的返回结果
				if (envelope.getResponse() == null)
					break;
				return (SoapObject) envelope.bodyIn;
			}
			Map.Entry entry = (Map.Entry) iterator.next();
			String str = (String) entry.getKey();
			Object obj = entry.getValue();
			Log.d(TAG, "paramName=" + str);
			Log.d(TAG, "paramValue=" + obj.toString());
			request.addProperty(str, obj);
		}
		return null;
	}
}
