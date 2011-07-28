package com.example.helloandroid;

import com.facebook.android.C;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FBLoginActivity extends Activity implements View.OnClickListener {

	  private Facebook mFacebook = new Facebook(C.FACEBOOK_APP_ID);
	  private Button mBtnLogin, mBtnFeed, mBtnLogout;
	 
	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.fb_login_layout);
	   
	    mBtnLogin = (Button) findViewById(R.id.btnLogin);
	    mBtnFeed = (Button) findViewById(R.id.btnFeed);
	    mBtnLogout = (Button) findViewById(R.id.btnLogout);
	   
	    mBtnLogin.setOnClickListener(this);
	    mBtnFeed.setOnClickListener(this);
	    mBtnLogout.setOnClickListener(this);
	  }

	  public void onClick(View v) {
		  // TODO Auto-generated method stub
		  switch(v.getId())
		  {
			  case R.id.btnLogin:
				  login();
				  break;
			  case R.id.btnFeed:
				  feed();
				  break;
			  case R.id.btnLogout:
				  logout();
				  break;
			  default:
				  break;
		  }
	  }

	  private void login()
	  {
		  mFacebook.authorize2(this, new String[] {"publish_stream, user_photos, email"}, new AuthorizeListener());
	  }
	 
	  private void feed()
	  {
	   
	  }
	 
	  private void logout()
	  {
	   
	  }

	  @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		  if (resultCode == RESULT_OK)
		  {
			  if (requestCode == 32665)
			  {
				  mFacebook.authorizeCallback(requestCode, resultCode, data);
			  }
		  }
		  else
		  {
			  if (requestCode == 32665)
			  {
				  mFacebook.authorizeCallback(requestCode, resultCode, data);
			  }     
		  }
	}

	public class AuthorizeListener implements DialogListener
	  {
			public void onComplete(Bundle values) {
				// TODO Auto-generated method stub
				if (C.D) Log.v(C.LOG_TAG, "::: onComplete :::");		
			}

			public void onFacebookError(FacebookError e) {
				// TODO Auto-generated method stub
				Log.v(C.LOG_TAG, "::: onFacebookError :::");		
			}

			public void onError(DialogError e) {
				// TODO Auto-generated method stub
				Log.v(C.LOG_TAG, "::: onError :::");		
			}

			public void onCancel() {
				// TODO Auto-generated method stub
				Log.v(C.LOG_TAG, "::: onCancel :::");		
			}
	  }
}
