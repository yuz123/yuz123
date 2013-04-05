package com.yuz123.dashboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		// final Context mContext = this;

		Button btnNewMessage = (Button) findViewById(R.id.home_btn_new_message);
		btnNewMessage.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// по нажатию на кнопку dashboard'a запускаем наши другие
				// Activity
			}
		});

		Button btnMessages = (Button) findViewById(R.id.home_btn_messages);
		btnMessages.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			}
		});

		Button btnPreferences = (Button) findViewById(R.id.home_btn_preferences);
		btnPreferences.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			}
		});

		Button btnFullVersion = (Button) findViewById(R.id.home_btn_full_version);
		btnFullVersion.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			}
		});
	}
}