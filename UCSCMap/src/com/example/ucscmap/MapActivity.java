package com.example.ucscmap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MapActivity extends FragmentActivity {
	
	private static final LatLng UCSC = new LatLng(36.991386 , -122.060872);
	private GoogleMap map;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_map);
    	
    	GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        createMap();
        
        //Places starting marker at center of Campus
        Marker ucsc = map.addMarker(new MarkerOptions()
        	.position(UCSC)
        	.title("UCSC")
        	.icon(BitmapDescriptorFactory
        	.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
     
        //Moves Camera to starting Position of UCSC Campus
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(UCSC, 15));
    }
    
    //Creates the map object
    private void createMap(){
    	//checks to see if there already is a map
    	if(map == null){
    		 map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
