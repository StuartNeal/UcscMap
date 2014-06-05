package com.example.ucscmap;

import java.util.ArrayList;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;

@SuppressLint("NewApi") public class BuildingFragment extends Fragment 
				implements OnQueryTextListener{
	
	public BuildingFragment(){}
	
	ListView lv;
    
	 	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
		 
	 		ArrayList<Building> building_list = MapActivity.building_list;
	  
	        View rootView = inflater.inflate(R.layout.fragment_buildings, container, false);
	        
	        final ArrayAdapterBuilding adapter = new ArrayAdapterBuilding(getActivity().getBaseContext(), building_list);
	        
	        lv = (ListView)rootView.findViewById(R.id.list_buildings);
	        
	        lv.setAdapter(adapter);
	        lv.setTextFilterEnabled(true);
	        
	        lv.setOnItemClickListener(new ListView.OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> a, View v, int i, long l) {
				//When clicking on a building, go to new fragment that contains building information
					BuildingInfoFragment frag = new BuildingInfoFragment();
					
					getView().setSelected(true);
					Building temp = (Building) lv.getItemAtPosition(i);
					
					frag.getCurrBuilding(temp);

					FragmentManager fragmentManager = getFragmentManager();
		    		fragmentManager.beginTransaction().replace(R.id.frame_container , frag).addToBackStack(null).commit();
		    		
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
		
		//Login Screen Fragment
		public static class BuildingInfoFragment extends Fragment implements OnClickListener{

			public BuildingInfoFragment() {
			}
			
			Building temp;
			GoogleMap m = mapFragment.map;
			Button button;
			ListView lv;

			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState) {
				
				View rootView = inflater.inflate(R.layout.fragment_building_info, container, false);
				
				lv = (ListView)rootView.findViewById(R.id.list_building_classrooms);
				
				if(temp != null){
					String name = temp.name;
					Log.d("Building Name:", name);
					TextView tv = (TextView)rootView.findViewById(R.id.building_id);
					tv.setText(name);
					
			        ArrayAdapterClassroom adapter = new ArrayAdapterClassroom(getActivity().getBaseContext(), temp.classrooms);

			        lv.setAdapter(adapter);
			        lv.setTextFilterEnabled(true);
				}
				
				button = (Button) rootView.findViewById(R.id.go_to_map);
				button.setOnClickListener(this);
				
				return rootView;
			}
			
			//Gets the selected building
			public void getCurrBuilding(Building b){
				temp = b;
			}

			//Goes to Building location on map
			@Override
			public void onClick(View v){
				mapFragment fragment = new mapFragment();
				fragment.setView = 1;
				fragment.getBuilding(temp);
				
				FragmentManager fragmentManager = getFragmentManager();
	    		fragmentManager.beginTransaction().add(R.id.frame_container , fragment).addToBackStack(null).commit();
				//m.moveCamera(CameraUpdateFactory.newLatLngZoom(temp.location, 5));
			}
			
		}

}
