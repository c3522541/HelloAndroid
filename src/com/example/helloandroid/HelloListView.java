package com.example.helloandroid;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.helloandroid.utilities.Utils;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HelloListView extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		String[] countries = getResources().getStringArray(R.array.countries_array);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, countries));
		
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
			        int position, long id) {
			      // When clicked, show a toast with the TextView text
//				Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
				if(position == 0)
				{					
					Intent intent = new Intent().setClass(getApplicationContext(), HelloAndroid.class);
					startActivity(intent);
				}
				else if(position == 1)
				{
					Intent intent = new Intent().setClass(getApplicationContext(), LinearLayoutActivity.class);
					startActivity(intent);
				}
				else if(position == 2)
				{
					Intent intent = new Intent().setClass(getApplicationContext(), RelativeLayoutActivity.class);
					startActivity(intent);
				}
				else if (position == 3)
				{
//					JSONTest.getUserInfo(JSONTest.URL_CREATE_A_USER);
//					JSONTest.getUserInfoFromTeamBuy(JSONTest.URL_GET_A_USERS_INFO);
					JSONTest.getDealInfo(JSONTest.URL_GET_A_DEALS_INFO);
				}
				else if(position == 4)
				{
					Intent intent = new Intent().setClass(getApplicationContext(), HelloGridView.class);
					startActivity(intent);
				}
				else if(position == 5)
				{
					Intent intent = new Intent().setClass(getApplicationContext(), FBLoginActivity.class);
					startActivity(intent);
				}
				else if(position == 6)
				{
					Intent intent  = new Intent().setClass(getApplicationContext(), QRCodeActivity.class);
					startActivity(intent);
				}
			}
			
		});
	}

}
