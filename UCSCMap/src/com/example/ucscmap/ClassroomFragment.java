package com.example.ucscmap;

import java.util.ArrayList;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

@SuppressLint("NewApi") public class ClassroomFragment extends Fragment implements OnQueryTextListener {
	
	public ClassroomFragment(){}
	
	ListView lv;
	
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		 
		 	ArrayList<Building> building_list = MapActivity.building_list;
		 	
		 	ArrayList<Classroom> class_list = new ArrayList<Classroom>();
		 	
		 	//Runs through the building list and grabs classrooms if the building has them
		 	for(int i = 0; i < building_list.size(); i++){
		 		
		 		Building curr = building_list.get(i);
		 		
		 		if(!building_list.get(i).classrooms.isEmpty()){
		 			for(int j = 0; j < curr.classrooms.size(); j++){
		 				class_list.add(curr.classrooms.get(j));
		 			}
		 		}
		 	}
	  
	        View rootView = inflater.inflate(R.layout.fragment_classrooms, container, false);
	        
	        ArrayAdapterClassroom adapter = new ArrayAdapterClassroom(getActivity().getBaseContext(), class_list);
	        
	        lv = (ListView)rootView.findViewById(R.id.list_classrooms);
	        
	        lv.setAdapter(adapter);
	        lv.setTextFilterEnabled(true);
	        
	        lv.setOnItemClickListener(new ListView.OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> a, View v, int i, long l) {
				//When clicking on a classroom, go to new fragment that contains class information
					
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
