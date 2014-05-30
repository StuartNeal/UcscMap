package com.example.ucscmap;

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
	
	//Colleges 
	private static final LatLng COWELL = new LatLng(36.996648 , -122.054166);
	private static final LatLng STEVENSON = new LatLng(36.996887 , -122.051917);
	private static final LatLng CROWN = new LatLng(36.999614 , -122.054978);
	private static final LatLng MERRILL = new LatLng(36.999395 , -122.053051);
	private static final LatLng NINETEN = new LatLng(37.001386 , -122.058335);
	private static final LatLng KRESGE = new LatLng(36.997786 , -122.065951);
	private static final LatLng PORTER = new LatLng(36.994354 , -122.065468);
	private static final LatLng EIGHT = new LatLng(36.991206, -122.064369);
	private static final LatLng OAKES = new LatLng(36.989044 , -122.064408);
	
	MapView mapView;
	static GoogleMap map;
	
	Marker myMark = null;
	String title;
	
	private static LatLng USER;
	boolean userMarker = false;
	
	public mapFragment(){}
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	  
	        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
	        
	        mapView = (MapView) rootView.findViewById(R.id.mapView); 
	        mapView.onCreate(savedInstanceState);
	        
	        map = mapView.getMap();
	        map.getUiSettings().setMyLocationButtonEnabled(false);
	        
	        //UCSC Marker
	        Marker ucsc = null;
	        title = "UCSC";
	        addMarker(ucsc, UCSC, title);
	        //Cowell Marker
	        Marker cowell = null;
	        title = "Cowell";
	        addMarker(cowell, COWELL, title);
	        //Stevenson Marker
	        Marker stevenson = null;
	        title = "Steveson";
	        addMarker(stevenson, STEVENSON, title);
	        //Crown Marker
	        Marker crown = null;
	        title = "Crown";
	        addMarker(crown, CROWN, title);
	        //Merrill Marker
	        Marker merrill = null;
	        title = "Merrill";
	        addMarker(merrill, MERRILL, title);
	        //Nine Ten Marker
	        Marker nineten = null;
	        title = "Nine Ten";
	        addMarker(nineten, NINETEN, title);
	        //Kresge Marker
	        Marker kresge = null;
	        title = "Kresge";
	        addMarker(kresge, KRESGE, title);
	        //Porter Marker
	        Marker porter = null;
	        title = "Porter";
	        addMarker(porter, PORTER, title);
	        //Eight Marker
	        Marker eight = null;
	        title = "Eight";
	        addMarker(eight, EIGHT, title);
	        //Oakes Marker
	        Marker oakes = null;
	        title = "Oakes";
	        addMarker(oakes, OAKES, title);
	        
	        //Moves Camera to starting Position of UCSC Campus
	        map.moveCamera(CameraUpdateFactory.newLatLngZoom(UCSC, 15));
	        
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
	    	.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
	} 
}