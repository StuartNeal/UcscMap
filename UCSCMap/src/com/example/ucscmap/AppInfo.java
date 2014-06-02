package com.example.ucscmap;

import java.util.ArrayList;
import java.util.Locale;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

public class AppInfo {
	//the singleton instance of the AppInfo
	private static AppInfo instance;
	
	//declare any other variables here
	/**
	 * Holds the current GPS latitude and longitude between activities
	 */
	public LatLng currentLocation;
	
	/**
	 * An ArrayList that holds the buildings
	 */
	public ArrayList<Building> buildings;
	
	/**
	 * Holds the string returned by the Downloader from various contexts.
	 */
	public String downloadedString;
	
	/**
	 * Holds the current instance of the downloader
	 */
	private Downloader downloader;
	
	public MainActivity mainActivityReference;
	
	/**
	 * Constructor is protected to defeat instantiation
	 */
	protected AppInfo(){
		//initialize any other variables here
		//get the current location from the GPS, and download the ArrayList of buildings?
		currentLocation = null;
		buildings = null;
		downloadedString = null;
		downloader = null;
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

	/**
	 * Takes a string URL and visits it.  
	 * Meant for use with the ucscMapServer to download information.
	 * @param url The URL to download from
	 */
	public void downloadFrom(String url, MainActivity ma){
		Log.d("AppInfo", "Creating a new Downloader");
		downloader = new Downloader();
		mainActivityReference = ma;
		Log.d("AppInfo", "Executing on URL " + url);
		downloader.execute(url);
	}
}
