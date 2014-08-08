package com.kn.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v4.app.Fragment;

public class ConfigUtils {

	private static ConfigUtils instance = null;

	private static final String SERVICES_PROPERTIES_FILE = "services.properties";
	private static final String TARGET_NAMESPACE = "TARGET_NAMESPACE";
	private static final String SERVICE_URL = "SERVICE_URL";
	private static final String APK_UPDATE_URL = "APK_UPDATE_URL";
	private static final String APK_NAME_MAIN = "APK_NAME_MAIN";
	private static final String APK_NAME_SAOMIAO = "APK_NAME_SAOMIAO";
	private static final String NETWORK_TEST_DOMAIN = "NETWORK_TEST_DOMAIN";

	String serviceUrl = null;
	String targetNamespace = null;
	String apkUpdateUrl = null;
	String apkNameMain = null;
	String apkNameSaomiao = null;
	String networkTestDomain = null;

	public static ConfigUtils getInstance() {
		if (instance == null) {
			instance = new ConfigUtils(null);
		}
		return instance;
	}
	
	public ConfigUtils(Fragment fragment) {
		InputStream inputStream = null;
		Properties properties = new Properties();
		
		AssetManager am = fragment.getActivity().getAssets();
		
		try {
			inputStream = am.open(SERVICES_PROPERTIES_FILE);
			properties.load(inputStream);
			setServiceUrl(properties.getProperty(SERVICE_URL,
					"http://10.0.2.2:8080/KnService/apk/KnSoft.apk"));
			setTargetNamespace(properties.getProperty(TARGET_NAMESPACE,
					"http://service.whl.kn.com/"));
			setApkUpdateUrl(properties.getProperty(APK_UPDATE_URL,
					"http://10.0.2.2:8080/KnService/apk/KnSoft.apk"));
			setApkNameMain(properties.getProperty(APK_NAME_MAIN, "KnSoft.apk"));
			setApkNameSaomiao(properties.getProperty(APK_NAME_SAOMIAO,
					"ZXing.apk"));
			setNetworkTestDomain(properties.getProperty(NETWORK_TEST_DOMAIN,
					"www.csdn.net"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}

	public String getApkUpdateUrl() {
		return apkUpdateUrl;
	}

	public void setApkUpdateUrl(String apkUpdateUrl) {
		this.apkUpdateUrl = apkUpdateUrl;
	}

	public String getApkNameMain() {
		return apkNameMain;
	}

	public void setApkNameMain(String apkNameMain) {
		this.apkNameMain = apkNameMain;
	}

	public String getApkNameSaomiao() {
		return apkNameSaomiao;
	}

	public void setApkNameSaomiao(String apkNameSaomiao) {
		this.apkNameSaomiao = apkNameSaomiao;
	}

	public String getNetworkTestDomain() {
		return networkTestDomain;
	}

	public void setNetworkTestDomain(String networkTestDomain) {
		this.networkTestDomain = networkTestDomain;
	}
}
