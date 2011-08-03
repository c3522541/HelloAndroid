package com.example.helloandroid;

import com.example.helloandroid.storage.Cache;
import com.example.helloandroid.utilities.ImageDownloader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imageview_layout);
		ImageView imageView = (ImageView) findViewById(R.id.targetimage);
		
		String url = "http://s0.2mdn.net/1946273/MID_1636616_2011-06-03_1223.png";
		Bitmap bitmap = Cache.getCacheFile(url);
		TextView textView = (TextView) findViewById(R.id.statustext);
		if(bitmap == null)
		{
			ImageDownloader imageDownloader = new ImageDownloader(imageView);
			imageDownloader.execute(url);
			textView.setText("Downloaded Image");
		}
		else
		{
			imageView.setImageBitmap(bitmap);
			textView.setText("Cached Image");
		}
	}

}
