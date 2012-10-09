package com.yuz.calc;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	Button btnMult;
	Button btnDev;
	Button btnPlus;
	Button btnMinus;
	Button btnClr;
	TextView tv1;
	TextView tv2;
	TextView tv3;
	EditText et1;
	EditText et2;
	private static final String TAG = "myCalc";
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnMult = (Button) findViewById(R.id.button1);
		btnMult.setOnClickListener(this);
		
		btnDev = (Button) findViewById(R.id.button2);
		btnDev.setOnClickListener(this);
		
		btnPlus = (Button) findViewById(R.id.button3);
		btnPlus.setOnClickListener(this);
		
		btnMinus = (Button) findViewById(R.id.button4);
		btnMinus.setOnClickListener(this);
		
		btnClr = (Button) findViewById(R.id.btnClr);
		btnClr.setOnClickListener(this);
		
		et1 = (EditText) findViewById(R.id.widget34);
		et1.requestFocus();
		
		et2 = (EditText) findViewById(R.id.widget32);
		
		tv3 = (TextView) findViewById(R.id.textView2);
		
		tv2 = (TextView) findViewById(R.id.widget36);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	
	@Override
	public void onClick(View v) {
		float summ;
		AlphaAnimation animation = new AlphaAnimation(0, 1);
		
		if (TextUtils.isEmpty(et1.getText().toString())
	        || TextUtils.isEmpty(et2.getText().toString())) 
		{
	    	Toast.makeText(MainActivity.this, "!!!Введите данные!!!", Toast.LENGTH_SHORT).show(); 
	    	return;
	    }
	    tv3.setText("");
	    
	    
		switch (v.getId()) {
	     
		case R.id.button1:
	       summ = Float.parseFloat(et1.getText().toString()) * Float.parseFloat(et2.getText().toString());
	       String s = Float.toString(summ);
	       
	       animation.setStartOffset(500);
	       tv2.setVisibility(TextView.VISIBLE);
	       animation.setDuration(500);
	       tv2.startAnimation(animation);
	       
	       tv2.setText(s);
	       tv3.setText("*");
	       Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
	       Log.d(TAG, "кнопка Mult нажата");
	       break;
	      
		case R.id.button2:
	       summ = Float.parseFloat(et1.getText().toString()) / Float.parseFloat(et2.getText().toString());
	       String s1 = Float.toString(summ);
	    		 if (summ == Float.POSITIVE_INFINITY || summ == Float.NEGATIVE_INFINITY)  {
	    			 Toast.makeText(MainActivity.this, "!!!Деление на ноль!!!", Toast.LENGTH_SHORT).show();
	    			 tv2.setText("!!!Деление на ноль!!!");
	    			 tv3.setText("/");
	    			 return;
	    		 }
	    		 else{
	    		 tv2.setText(s1);
	    		 
	    		 animation.setStartOffset(500);
			       tv2.setVisibility(TextView.VISIBLE);
			       animation.setDuration(500);
			       tv2.startAnimation(animation);
	    		 
	    		 tv3.setText("/");
			       Toast.makeText(MainActivity.this, s1, Toast.LENGTH_SHORT).show();
			       Log.d(TAG, "кнопка Dev нажата");
	    		}
	      break;
	     
		case R.id.button3:
		       summ = Float.parseFloat(et1.getText().toString()) + Float.parseFloat(et2.getText().toString());
		       String s2 = Float.toString(summ);
		       tv2.setText(s2);
		       
		       animation.setStartOffset(500);
		       tv2.setVisibility(TextView.VISIBLE);
		       animation.setDuration(500);
		       tv2.startAnimation(animation);
		       
		       tv3.setText("+");
		       Toast.makeText(MainActivity.this, s2, Toast.LENGTH_SHORT).show();
		       Log.d(TAG, "кнопка Plus нажата");
		       animation.setStartOffset(500);
		       tv2.setVisibility(TextView.VISIBLE);
		       animation.setDuration(500);
		       tv2.startAnimation(animation);
		       break;
	     
		case R.id.button4:
		       summ = Float.parseFloat(et1.getText().toString()) - Float.parseFloat(et2.getText().toString());
		       String s3 = Float.toString(summ);
		       tv2.setText(s3);
		       
		       animation.setStartOffset(500);
		       tv2.setVisibility(TextView.VISIBLE);
		       animation.setDuration(500);
		       tv2.startAnimation(animation);
		       
		       tv3.setText("-");
		       Toast.makeText(MainActivity.this, s3, Toast.LENGTH_SHORT).show();
		       Log.d(TAG, "кнопка Minus нажата");
		       break;
	    
		case R.id.btnClr:
			   Vibrator vibro = (Vibrator) getSystemService(MainActivity.VIBRATOR_SERVICE);
			   vibro.vibrate(50);
			   tv2.setText("");
			   tv3.setText("");
			   et1.setText("");
			   et2.setText("");
			   Toast.makeText(MainActivity.this, "!!! Cleared !!!", Toast.LENGTH_SHORT).show();
		       Log.d(TAG, "кнопка Clear нажата");
		       break;       
		}	
	}
}
