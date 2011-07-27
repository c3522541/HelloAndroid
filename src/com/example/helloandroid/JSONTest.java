package com.example.helloandroid;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.helloandroid.model.DealInfo;
import com.example.helloandroid.model.DealOption;
import com.example.helloandroid.model.UserInfo;
import com.example.helloandroid.model.UserInfoFromTeamBuy;
import com.example.helloandroid.utilities.Utils;

public class JSONTest {
	static final String URL_CREATE_A_USER = "http://sandbox.playwithplastic.com/appreleases/tests/createauser.json";
	static final String URL_GET_A_USERS_INFO = "http://sandbox.playwithplastic.com/appreleases/tests/getausersinformation.json";
	static final String URL_GET_A_DEALS_INFO = "http://sandbox.playwithplastic.com/appreleases/tests/getadealsinformation.json";

	public static UserInfo getUserInfo(String Url)
	{
		JSONObject json = Utils.getJSONfromURL(Url);

		UserInfo result = new UserInfo();
		
		try {
			result.id = json.getString("id");
			result.username = json.getString("username");
			result.email = json.getString("email");
			result.first_name = json.getString("first_name");
			result.last_name = json.getString("last_name");
			result.picture = json.getString("picture");
			result.address = json.getString("address");
			result.address2 = json.getString("address2");
			result.city = json.getString("city");
			result.province = json.getString("province");
			result.postal_code = json.getString("postal_code");
			result.area_code = json.getString("area_code");
			result.phone_number = json.getString("phone_number");
			result.sex = json.getString("sex");
			result.dob = json.getString("dob");
			result.preferred_city = json.getString("preferred_city");
			result.language = json.getString("language");
			result.teambucks = json.getString("teambucks");
			result.mybuys = json.getString("mybuys");
			result.mygifts = json.getString("mygifts");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
	}
	
	public static UserInfo getUserInfoFromTeamBuy(String Url)
	{
		JSONObject json = Utils.getJSONfromURL(Url);
		UserInfoFromTeamBuy result = new UserInfoFromTeamBuy();
		try {
			result.id = json.getString("id");
			result.username = json.getString("username");
			result.email = json.getString("email");
			result.first_name = json.getString("first_name");
			result.last_name = json.getString("last_name");
			result.picture = json.getString("picture");
			result.address = json.getString("address");
			result.address2 = json.getString("address2");
			result.city = json.getString("city");
			result.province = json.getString("province");
			result.postal_code = json.getString("postal_code");
			result.area_code = json.getString("area_code");
			result.phone_number = json.getString("phone_number");
			result.sex = json.getString("sex");
			result.dob = json.getString("dob");
			result.preferred_city = json.getString("preferred_city");
			result.language = json.getString("language");
			result.teambucks = json.getString("teambucks");
			result.mybuys = json.getString("mybuys");
			result.mygifts = json.getString("mygifts");
			result.usedbuys = json.getString("usedbuys");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
	}
	
	public static DealInfo getDealInfo(String Url)
	{
		JSONObject json = Utils.getJSONfromURL(Url);
		DealInfo result = new DealInfo();
		try {
			result.id = json.getString("id");
			result.title = json.getString("title");
			result.full_date = json.getString("full_date");
			result.end_date = json.getString("end_date");
			result.city = json.getString("city");
			result.logo_image = json.getString("logo_image");
			result.main_image1 = json.getString("main_image1");
			result.main_image1_url = json.getString("main_image1_url");
			result.value = json.getString("value");
			result.discount = json.getString("discount");
			result.saved = json.getString("saved");
			result.discount_percentage = json.getString("discount_percentage");
			
			JSONArray dealOptionArray = json.getJSONArray("deal_option");
			for(int i = 0; i < dealOptionArray.length(); i++)
			{
				DealOption dealOption = new DealOption();
				JSONObject jsonObject = dealOptionArray.getJSONObject(i);
				dealOption.id = jsonObject.getString("id");
				dealOption.title = jsonObject.getString("title");
				dealOption.date_modified = jsonObject.getString("date_modified");
				dealOption.date_created = jsonObject.getString("date_created");
				dealOption.value = jsonObject.getString("value");
				dealOption.price = jsonObject.getString("price");
				dealOption.alt_title = jsonObject.getString("alt_title");
				dealOption.option_title = jsonObject.getString("option_title");
				dealOption.alt_option_title = jsonObject.getString("alt_option_title");
				dealOption.max_option_buys = jsonObject.getString("max_option_buys");
				dealOption.added_buys = jsonObject.getString("added_buys");
				dealOption.deal_id = jsonObject.getString("deal_id");
				dealOption.is_default = jsonObject.getString("is_default");
				
				result.deal_option.add(dealOption);
			}
			result.purchase_limit = json.getString("purchase_limit");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
}
