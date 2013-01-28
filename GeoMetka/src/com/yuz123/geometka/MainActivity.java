package com.yuz123.geometka;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPositionCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import android.R.string;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener {
	
	TextView latitude;
	TextView longitude;
	//String lat = "0";
	//String longi = "0";
	Button btn1;
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		        .getMap();
		map.setMyLocationEnabled(true);
		
	
//		latitude = (TextView) findViewById(R.id.textView1);
//		longitude = (TextView) findViewById(R.id.textView2);
		LocationManager lm =
	              (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	       lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
	      // lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	  	   
	       
	       
//	    Button btn1 = (Button) findViewById(R.id.button1); 
//	    
//	    btn1.setOnClickListener(new View.OnClickListener(){
//			public void onClick(View v) {
//				latitude.setText(lat);
//		        longitude.setText(longi);
//		        
//			}});
//	    
	    }
	
	    @Override
	    public void onLocationChanged(Location location) 
	    {
	    	  //lat = location.getLatitude(); 	
	    	  //longi = ("Долгота="+location.getLongitude());
	    	  LatLng MyPosition = new LatLng(location.getLatitude(), location.getLongitude());
	    	  map.animateCamera(CameraPositionCreator.tilt(90));
	    	  map.moveCamera(CameraUpdateFactory.newLatLngZoom(MyPosition, 15));
	    	  //latitude.setText("Широта="+location.getLatitude());
	          //longitude.setText("Долгота="+location.getLongitude());
	       
	    }


	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
}
	
