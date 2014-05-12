package com.example.ucscmap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.os.Build;

public class MapActivity extends FragmentActivity{
	
	private static final LatLng UCSC = new LatLng(36.991386 , -122.060872);
	private GoogleMap map;
	ActionBar actionBar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_map);
    	
    	//actionBar = getSupportActionBar();
    	//actionBar.setIcon(R.drawable.logo);
    	
    	GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        createMap();
        
        //Places starting marker at center of Campus
        Marker ucsc = map.addMarker(new MarkerOptions()
        	.position(UCSC)
        	.title("UCSC")
        	.icon(BitmapDescriptorFactory
        	.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
     
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
    	MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.activity_map_actions, menu);
        
        //Sets up the search widget
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
        switch(item.getItemId()){
        case R.id.action_search:
        	return true;
        case R.id.action_location_found:
        	return true;
        case R.id.action_refresh:
        	return true;
        case R.id.action_help:
        	return true;
        case R.id.action_check_updates:
        	return true;
        default:
        	return super.onOptionsItemSelected(item);
        } 
    }
    
}