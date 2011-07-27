package com.example.helloandroid.utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Utils {
	public static String downloadData(String url)
	{
		InputStream is = null;
		String result = "";
		//http post
		try{
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(url);
			HttpResponse getResponse = httpclient.execute(getRequest);
			HttpEntity entity = getResponse.getEntity();

			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}
		return result;
	}
	public static JSONObject getJSONfromURL(String url){
		JSONObject json = null;

		//try parse the string to a JSON object
		try{
			json = new JSONObject(Utils.downloadData(url));
		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}

		return json;
	}
}
