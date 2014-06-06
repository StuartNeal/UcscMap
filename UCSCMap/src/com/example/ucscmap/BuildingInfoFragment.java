package com.example.ucscmap;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

//Building Info Fragment
		@SuppressLint("NewApi") public class BuildingInfoFragment extends Fragment implements OnClickListener{

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
				
	    		getActivity().getActionBar().setIcon(R.drawable.building_icon);
				
				lv.setOnItemClickListener(new ListView.OnItemClickListener(){

					@Override
					public void onItemClick(AdapterView<?> a, View v, int i, long l) {
					//When clicking on a classroom, go to new fragment that contains class information
						ClassroomInfoFragment frag = new ClassroomInfoFragment();
						
						getView().setSelected(true);
						Classroom temp = (Classroom) lv.getItemAtPosition(i);
						
						frag.getCurrClass(temp);

						FragmentManager fragmentManager = getFragmentManager();
			    		fragmentManager.beginTransaction().replace(R.id.frame_container , frag).addToBackStack(null).commit();	
					}
					
				});
				
				//Checks to see if there is a building
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
			
			 @Override
			 	public void onActivityCreated(Bundle savedInstanceState){
			 		setHasOptionsMenu(true);
			 		super.onActivityCreated(savedInstanceState);
			 	}
			 	
			 	@Override
			 	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
			 		menu.findItem(R.id.action_location_found).setVisible(false);
			 		super.onCreateOptionsMenu(menu, inflater);
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
	    		
			}
			
		}
