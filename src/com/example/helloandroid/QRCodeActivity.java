package com.example.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QRCodeActivity extends Activity {
	
	private final int ACTIVITY_REQUEST_CODE_QRCODE	= 1;
	
	private Button btnQRCode;
	private TextView txtQRcodeResult;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcode_layout);
        
        btnQRCode = (Button) findViewById(R.id.ID_MAIN_BTN_QRCODE);
        btnQRCode.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				doExecuteQRCodeReader();
			}
		});
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != RESULT_OK) {
			return;
		}

		if (requestCode == ACTIVITY_REQUEST_CODE_QRCODE) {
			if (txtQRcodeResult == null) {
				txtQRcodeResult = (TextView) findViewById(R.id.ID_MAIN_TXT_QRCODE_RESULT);
			}
			
			txtQRcodeResult.setText(data.getStringExtra("SCAN_RESULT"));
		}
	}
    
    private void doExecuteQRCodeReader() {
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, ACTIVITY_REQUEST_CODE_QRCODE);
	}
    
}