package com.example.helloandroid.model;

import java.util.ArrayList;

public class DealInfo {
	public String id;
	public String title;
	public String full_date;
	public String end_date;
	public String city;
	public String logo_image;
	public String main_image1;
	public String main_image1_url;
	public String value;
	public String discount;
	public String saved;
	public String discount_percentage;
	public ArrayList<DealOption> deal_option = new ArrayList<DealOption>();
	public String purchase_limit;
}
