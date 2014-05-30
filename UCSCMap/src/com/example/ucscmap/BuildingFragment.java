package com.example.ucscmap;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi") public class BuildingFragment extends ListFragment {
	
	public BuildingFragment(){}
    
	 	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
		 
		 	ArrayList<Building> building_list = new ArrayList<Building>();
		    
		    LatLng OAKES = new LatLng(36.989044 , -122.064408);
		    
		    building_list.add(new Building("Test", OAKES));
		    building_list.add(new Building("Test2", OAKES));
		    building_list.add(new Building("Test3", OAKES));
		    building_list.add(new Building("Test4", OAKES));
		    building_list.add(new Building("Test5", OAKES));
		    building_list.add(new Building("Test", OAKES));
		    building_list.add(new Building("Test2", OAKES));
		    building_list.add(new Building("Test3", OAKES));
		    building_list.add(new Building("Test4", OAKES));
		    building_list.add(new Building("Test5", OAKES));
		    building_list.add(new Building("Test", OAKES));
		    building_list.add(new Building("Test2", OAKES));
		    building_list.add(new Building("Test3", OAKES));
		    building_list.add(new Building("Test4", OAKES));
		    building_list.add(new Building("Test5", OAKES));
		    building_list.add(new Building("Test", OAKES));
		    building_list.add(new Building("Test2", OAKES));
		    building_list.add(new Building("Test3", OAKES));
		    building_list.add(new Building("Test4", OAKES));
		    building_list.add(new Building("Test5", OAKES));
	  
	        View rootView = inflater.inflate(R.layout.fragment_buildings, container, false);
	        
	        ArrayAdapterBuilding adapter = new ArrayAdapterBuilding(getActivity().getBaseContext(), building_list);
	        
	        setListAdapter(adapter);
	          
	        return rootView;
	    }

}
