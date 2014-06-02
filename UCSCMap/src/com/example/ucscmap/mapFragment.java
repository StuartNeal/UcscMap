package com.example.ucscmap;

import java.util.ArrayList;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi") public class mapFragment extends Fragment {
	
	//UCSC Center
	private static final LatLng UCSC = new LatLng(36.991386 , -122.060872);
	
	MapView mapView;
	static GoogleMap map;
	
	Marker myMark = null;
	String title;

	public mapFragment(){}
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	  
	        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
	        
	        mapView = (MapView) rootView.findViewById(R.id.mapView); 
	        mapView.onCreate(savedInstanceState);
	        
	        map = mapView.getMap();
	        map.getUiSettings().setMyLocationButtonEnabled(false);
	        
	        ArrayList<Building> building_list = MapActivity.building_list;
	        
	        //Adds markers for buildings
	        for(int i = 0; i < building_list.size(); i++ ){
	        	Marker temp = null;
	        	addMarker(temp, building_list.get(i).location, building_list.get(i).name);
	        	
	        }
	        
	        //Moves Camera to starting Position of UCSC Campus
	        map.moveCamera(CameraUpdateFactory.newLatLngZoom(UCSC, 14));
	        
	        return rootView;
	    }
	 
	 @Override
	 public void onResume() {
		 super.onResume();
		 mapView.onResume();
	 }
	 
	 @Override
	 public void onPause() {
		 super.onPause();
		 mapView.onPause();
	 }
	 
	 @Override
	 public void onDestroy() {
		 super.onDestroy();
		 mapView.onDestroy();
	 }
	 
	//Adds marker
	private void addMarker(Marker m, LatLng loc, String title){
	    m = map.addMarker(new MarkerOptions()
	    	.position(loc)
	    	.title(title)
	    	.icon(BitmapDescriptorFactory
	    	.fromResource(R.drawable.building_icon)));
	} 
}