package com.example.ucscmap;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;

//Classroom Info Fragment
	@SuppressLint("NewApi") public class ClassroomInfoFragment extends Fragment implements OnClickListener{

				public ClassroomInfoFragment() {
				}
				
				Classroom temp;
				GoogleMap m = mapFragment.map;
				Button buttonMap, buttonSchedule;

			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState) {	
					
				View rootView = inflater.inflate(R.layout.fragment_classroom_info, container, false);

				buttonMap = (Button) rootView.findViewById(R.id.go_to_map_class);
				buttonSchedule = (Button) rootView.findViewById(R.id.button_add_to_schedule);
				buttonMap.setOnClickListener(this);
				buttonSchedule.setOnClickListener(this);
				
				if(temp != null){
					String name = temp.nameNumber;
					TextView tv = (TextView)rootView.findViewById(R.id.classroom_id);
					tv.setText(name);
				}
					
				return rootView;
			}
			
			//Goes to classroom location on map or adds class to schedule
			@Override
			public void onClick(View v){
				
				switch(v.getId()){
					case R.id.go_to_map_class:
						mapFragment fragment = new mapFragment();
						fragment.setView = 2;
						fragment.getClassroom(temp);
						FragmentManager fragmentManager = getFragmentManager();
			    		fragmentManager.beginTransaction().add(R.id.frame_container , fragment).addToBackStack(null).commit();	
					break;
					
					case R.id.button_add_to_schedule:
						
					break;
					
					default:
					break;
				}
						
	    	}
			
			//Gets the selected building
			public void getCurrClass(Classroom c){
				temp = c;
			}
		}
