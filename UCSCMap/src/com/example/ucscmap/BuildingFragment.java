package com.example.ucscmap;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Loader;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.SearchView.OnQueryTextListener;

@SuppressLint("NewApi") public class BuildingFragment extends Fragment 
				implements OnQueryTextListener{
	
	public BuildingFragment(){}
	
	String curFilter;
	ListView lv;
    
	 	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
		 
	 		ArrayList<Building> building_list = MapActivity.building_list;
	  
	        View rootView = inflater.inflate(R.layout.fragment_buildings, container, false);
	        
	        ArrayAdapterBuilding adapter = new ArrayAdapterBuilding(getActivity().getBaseContext(), building_list);
	        
	        lv = (ListView)rootView.findViewById(R.id.list);
	        
	        lv.setAdapter(adapter);
	        lv.setTextFilterEnabled(true);
	        
	        lv.setOnItemClickListener(new ListView.OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> a, View v, int i, long l) {
					// TODO Auto-generated method stub
				}
				
			});
	          
	        return rootView;
	    }
	 	
	 	@Override
	 	public void onActivityCreated(Bundle savedInstanceState){
	 		setHasOptionsMenu(true);
	 		super.onActivityCreated(savedInstanceState);
	 	}
	 	
	 	@Override
	 	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
	 		menu.findItem(R.id.action_location_found).setVisible(false);
	 		menu.findItem(R.id.action_search).setVisible(true);
	 		
	 		SearchView searchView = new SearchView(getActivity());
	 		searchView.setQueryHint("Buildings");
	 		searchView.setOnQueryTextListener(this);
	 		
	 		super.onCreateOptionsMenu(menu, inflater);
	 	}

		@Override
		public boolean onQueryTextChange(String newText) {
			
			if(TextUtils.isEmpty(newText)){
				
				lv.clearTextFilter();
			}else{
				lv.setFilterText(newText.toString());
			}
			
			return true;
		}

		@Override
		public boolean onQueryTextSubmit(String arg0) {
			return false;
		}

}
