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
	  private static final String[] COUNTRIES = new String[] {
		    "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
		    "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
		    "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
		    "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
		    "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
		    "Bosnia and Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
		    "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi",
		    "Cote d'Ivoire", "Cambodia", "Cameroon", "Canada", "Cape Verde",
		    "Cayman Islands", "Central African Republic", "Chad", "Chile", "China",
		    "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo",
		    "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic",
		    "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
		    "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea",
		    "Estonia", "Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji", "Finland",
		    "Former Yugoslav Republic of Macedonia", "France", "French Guiana", "French Polynesia",
		    "French Southern Territories", "Gabon", "Georgia", "Germany", "Ghana", "Gibraltar",
		    "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau",
		    "Guyana", "Haiti", "Heard Island and McDonald Islands", "Honduras", "Hong Kong", "Hungary",
		    "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
		    "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kuwait", "Kyrgyzstan", "Laos",
		    "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
		    "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
		    "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia", "Moldova",
		    "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia",
		    "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand",
		    "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "North Korea", "Northern Marianas",
		    "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru",
		    "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar",
		    "Reunion", "Romania", "Russia", "Rwanda", "Sqo Tome and Principe", "Saint Helena",
		    "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
		    "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Saudi Arabia", "Senegal",
		    "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
		    "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "South Korea",
		    "Spain", "Sri Lanka", "Sudan", "Suriname", "Svalbard and Jan Mayen", "Swaziland", "Sweden",
		    "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Bahamas",
		    "The Gambia", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
		    "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Virgin Islands", "Uganda",
		    "Ukraine", "United Arab Emirates", "United Kingdom",
		    "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan",
		    "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Wallis and Futuna", "Western Sahara",
		    "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"
		  };
	
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
			}
			
		});
	}

}
