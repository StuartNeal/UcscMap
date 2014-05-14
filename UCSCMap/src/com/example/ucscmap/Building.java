package com.example.ucscmap;

import java.util.ArrayList;
import com.google.android.gms.maps.model.LatLng;

/**
 * A data object to store the name, location, and constituent classrooms of a building.
 * @author Saul Winer
 */
public class Building {
	/**
	 * The name of the building.
	 */
	public String name;
	/**
	 * The arraylist containing all of the classrooms within the building.
	 */
	public ArrayList<Classroom> classrooms;
	/**
	 * The LatLng location of the building.
	 */
	public LatLng location;
	private ArrayList<LatLng> tags;
	
	/**
	 * @param _location The LatLng location of the building.
	 */
	public Building(LatLng _location){
		classrooms = new ArrayList<Classroom>();
		tags = new ArrayList<LatLng>();
		recalculateLocation(_location);
	}
	
	/**
	 * Adds a new classroom to the building.
	 * @param nameNumber The name or number of the classroom.
	 * @param _location The tagged location of the classroom.
	 */
	public void addClassroom(String nameNumber, LatLng _location){
		//first check to see whether the classroom is a duplicate.
		//if so, update the location of the classroom.
		//otherwise, add a new classroom to the list with the new location and name.
		classrooms.add(new Classroom(nameNumber, _location));
	}
	
	/**
	 * Takes a LatLng and adds it to the tagged locations for the building, 
	 * recalculating the averaged tag location of the building.
	 * @param newTag The new tagged latitude/longitude location of the building.
	 */
	public void recalculateLocation(LatLng newTag){
		tags.add(newTag);
		//do math to average these tags to get a location
	}
}