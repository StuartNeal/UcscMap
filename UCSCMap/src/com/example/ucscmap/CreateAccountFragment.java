package com.example.ucscmap;

import java.util.ArrayList;
import com.google.android.gms.maps.model.LatLng;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi") public class CreateAccountFragment extends Fragment{
	
	public CreateAccountFragment(){}
		
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_create_account, container, false);
	 
	 	return rootView;
    }
	

}
