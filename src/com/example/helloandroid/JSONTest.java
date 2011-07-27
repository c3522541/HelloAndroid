package com.example.helloandroid;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.helloandroid.model.UserInfo;
import com.example.helloandroid.model.UserInfoFromTeamBuy;
import com.example.helloandroid.utilities.Utils;

public class JSONTest {
	public static UserInfo getUserInfo(String Url)
	{
		JSONObject json = Utils.getJSONfromURL(Url);

		UserInfo userInfo = new UserInfo();
		
		try {
			userInfo.id = json.getString("id");
			userInfo.username = json.getString("username");
			userInfo.email = json.getString("email");
			userInfo.first_name = json.getString("first_name");
			userInfo.last_name = json.getString("last_name");
			userInfo.picture = json.getString("picture");
			userInfo.address = json.getString("address");
			userInfo.address2 = json.getString("address2");
			userInfo.city = json.getString("city");
			userInfo.province = json.getString("province");
			userInfo.postal_code = json.getString("postal_code");
			userInfo.area_code = json.getString("area_code");
			userInfo.phone_number = json.getString("phone_number");
			userInfo.sex = json.getString("sex");
			userInfo.dob = json.getString("dob");
			userInfo.preferred_city = json.getString("preferred_city");
			userInfo.language = json.getString("language");
			userInfo.teambucks = json.getString("teambucks");
			userInfo.mybuys = json.getString("mybuys");
			userInfo.mygifts = json.getString("mygifts");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return userInfo;
	}
	
	public static UserInfo getUserInfoFromTeamBuy(String Url)
	{
		JSONObject json = Utils.getJSONfromURL(Url);
		UserInfoFromTeamBuy userInfoFromTeamBuy = new UserInfoFromTeamBuy();
		try {
			userInfoFromTeamBuy.id = json.getString("id");
			userInfoFromTeamBuy.username = json.getString("username");
			userInfoFromTeamBuy.email = json.getString("email");
			userInfoFromTeamBuy.first_name = json.getString("first_name");
			userInfoFromTeamBuy.last_name = json.getString("last_name");
			userInfoFromTeamBuy.picture = json.getString("picture");
			userInfoFromTeamBuy.address = json.getString("address");
			userInfoFromTeamBuy.address2 = json.getString("address2");
			userInfoFromTeamBuy.city = json.getString("city");
			userInfoFromTeamBuy.province = json.getString("province");
			userInfoFromTeamBuy.postal_code = json.getString("postal_code");
			userInfoFromTeamBuy.area_code = json.getString("area_code");
			userInfoFromTeamBuy.phone_number = json.getString("phone_number");
			userInfoFromTeamBuy.sex = json.getString("sex");
			userInfoFromTeamBuy.dob = json.getString("dob");
			userInfoFromTeamBuy.preferred_city = json.getString("preferred_city");
			userInfoFromTeamBuy.language = json.getString("language");
			userInfoFromTeamBuy.teambucks = json.getString("teambucks");
			userInfoFromTeamBuy.mybuys = json.getString("mybuys");
			userInfoFromTeamBuy.mygifts = json.getString("mygifts");
			userInfoFromTeamBuy.usedbuys = json.getString("usedbuys");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return userInfoFromTeamBuy;
	}
	
}
