package com.example.ucscmap;

import java.util.ArrayList;
import com.google.android.gms.maps.model.LatLng;

/**
 * A data object to store the name and location of a classroom.
 * @author Saul Winer
 */
public class Classroom {
	/**
	 * The name or number of the classroom.
	 */
	public String nameNumber;
	/**
	 * The LatLng location of the classroom.
	 */
	public LatLng location;
	/**
	 * The arraylist containing all of the tagged locations for the classroom.
	 */
	private ArrayList<LatLng> tags;
	
	/**
	 * @param _nameNumber The name or number of the classroom.
	 * @param _location The latitude/longitude of the classroom.
	 */
	public Classroom(String _nameNumber, LatLng _location){
		nameNumber = _nameNumber;
		tags = new ArrayList<LatLng>();
		recalculateLocation(_location);
	}
	
	/**
	 * Takes a LatLng and adds it to the tagged locations for the classroom, 
	 * recalculating the averaged tag location of the classroom.
	 * @param newTag The new tagged latitude/longitude location of the classroom
	 */
	public void recalculateLocation(LatLng newTag){
		tags.add(newTag);
		//do math to average these tags to get a location
	}
}
