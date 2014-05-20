package com.example.ucscmap;

import java.util.ArrayList;
import java.util.Locale;

import com.google.android.gms.maps.model.LatLng;

public class AppInfo {
	//the singleton instance of the AppInfo
	private static AppInfo instance;
	
	//declare any other variables here
	/**
	 * Holds the current GPS latitude and longitude between activities
	 */
	public LatLng currentLocation;
	
	public ArrayList<Building> buildings;
	
	/**
	 * Constructor is protected to defeat instantiation
	 */
	protected AppInfo(){
		//initialize any other variables here
		//get the current location from the GPS, and download the ArrayList of buildings?
	}
	
	/**
	 * A method to return the singleton instance
	 * @return AppInfo instance
	 */
	public static AppInfo getInstance(){
		if (instance == null){
			instance = new AppInfo();
		}
		return instance;
	}
	
	/**
	 * Adds a building to the ArrayList, or updates the location if the building already exists. 
	 * @param name The name of the building to be added.
	 * @param location The location of the tag.
	 */
	public void addBuilding(String name, LatLng location){
		//format the name correctly
		name.replaceAll("\\s+", " ");
		//check for duplicate buildings
		for(Building b : buildings){
			//if we find one, update the location.
			if (name.toLowerCase(Locale.ENGLISH).equals(b.name.toLowerCase(Locale.ENGLISH))){
				b.recalculateLocation(location);
				return;
			}
		}
		//else, add a new building.
		buildings.add(new Building(name, location));
	}

}
