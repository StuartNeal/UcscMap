package com.example.ucscmap;

import java.util.ArrayList;
import android.app.Activity;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

public class BuildingList {
	
	private static BuildingList instance;
			
	protected BuildingList(){}
	
	public static BuildingList getInstance(){
		if (instance == null){
			instance = new BuildingList();
		}
		return instance;
	}
	
	public ArrayList<Building> building_list = new ArrayList<Building>();
	
	private class BuildingDownloader extends Downloader{
		@Override
		protected void onPostExecute(String s){
			Gson gson = new Gson();
			ArrayList<Building> newList = null;
			try{
				newList = gson.fromJson(s, ArrayList.class);
			} catch (Exception e){
			}
			building_list = newList;
			MapActivity.building_list = newList;
		}
	}
	
	public void downloadBuildingList(Activity activity){
		//Create a downloader to download the Json string of buildings
		BuildingDownloader downloader = new BuildingDownloader();
		downloader.execute(activity.getString(R.string.text_url_base) + "getBuildings/?secret=becausesecret");
	}
	
public ArrayList<Building> createBuildingList(){
	
	//Colleges 
	LatLng COWELL = new LatLng(36.996648 , -122.054166);
		//Cowell Locations
		LatLng Adams = new LatLng(36.997236, -122.054063);
		LatLng Parkman = new LatLng(36.997360, -122.054455);
		LatLng Prescott = new LatLng(36.997043, -122.054594);
		LatLng Beard = new LatLng(36.996568, -122.054487);
		LatLng Morison = new LatLng(36.996838, -122.054267);
		LatLng Parrington = new LatLng(36.996379, -122.054155);
		LatLng Turner = new LatLng(36.996653, -122.053854);
		LatLng CApartments_1 = new LatLng(36.996842, -122.054745);
		LatLng CApartments_2 = new LatLng(36.996585, -122.055093);
		LatLng CApartments_3 = new LatLng(36.996238, -122.054653);
		LatLng CApartments_4 = new LatLng(36.997604, -122.054557);
		LatLng CommunityRoom = new LatLng(36.996157, -122.054399);
		LatLng ComputerLab = new LatLng(36.996945, -122.055013);
		LatLng CAdmin = new LatLng(36.997309, -122.05343);
		LatLng CDining = new LatLng(36.996855, -122.053044);
		
	LatLng STEVENSON = new LatLng(36.996887 , -122.051917);
	LatLng CROWN = new LatLng(36.999614 , -122.054978);
	LatLng MERRILL = new LatLng(36.999395 , -122.053051);
	LatLng NINETEN = new LatLng(37.001386 , -122.058335);
	LatLng KRESGE = new LatLng(36.997786 , -122.065951);
	LatLng PORTER = new LatLng(36.994354 , -122.065468);
	LatLng EIGHT = new LatLng(36.991206, -122.064369);
	LatLng OAKES = new LatLng(36.989044 , -122.064408);
	
	building_list.add(new Building("Cowell", COWELL));
		building_list.get(0).addClassroom("Adams House", Adams);
		building_list.get(0).addClassroom("Parkman House", Parkman);
		building_list.get(0).addClassroom("Prescott House", Prescott);
		building_list.get(0).addClassroom("Beard House", Beard);
		building_list.get(0).addClassroom("Morison House", Morison);
		building_list.get(0).addClassroom("Parrington House", Parrington);
		building_list.get(0).addClassroom("Turner House", Turner);
		building_list.get(0).addClassroom("Cowell Apartments 1", CApartments_1);
		building_list.get(0).addClassroom("Cowell Apartments 2", CApartments_2);
		building_list.get(0).addClassroom("Cowell Apartments 3", CApartments_3);
		building_list.get(0).addClassroom("Cowell Apartments 4", CApartments_4);
		building_list.get(0).addClassroom("Apartment Community Room", CommunityRoom);
		building_list.get(0).addClassroom("Computer Lab", ComputerLab);
		building_list.get(0).addClassroom("Cowell Administration", CAdmin);
		building_list.get(0).addClassroom("Cowell Dining Commons", CDining);
		
	building_list.add(new Building("Stevenson", STEVENSON));
	building_list.add(new Building("Crown", CROWN));
	building_list.add(new Building("Merrill", MERRILL));
	building_list.add(new Building("Nine Ten", NINETEN));
	building_list.add(new Building("Kresge", KRESGE));
	building_list.add(new Building("Porter", PORTER));
	building_list.add(new Building("Eight", EIGHT));
	building_list.add(new Building("Oakes", OAKES));
	
	//Buildings
	LatLng EOP = new LatLng(36.994310, -122.059422);
	LatLng Arboretum = new LatLng(36.982716, -122.059883);
	LatLng DepartmentArt = new LatLng(36.994483, -122.060971);
	LatLng BaobabLounge = new LatLng(37.000064, -122.05326);
	LatLng BarnG = new LatLng(36.980371, -122.052738);
	LatLng BarnTheater = new LatLng(36.977650, -122.054301);
	LatLng BaskinEngineering = new LatLng(37.000365, -121.063146);
	LatLng Baytree = new LatLng(36.997992, -122.05558);
	LatLng BioMed = new LatLng(36.999749, -122.061097);
	LatLng CampusTours = new LatLng(36.978933, -122.054515);
	LatLng CantuQueer = new LatLng(37.000592, -122.05388);
	LatLng CareerCenter = new LatLng(36.997838, -122.05551);
	LatLng CardiffHouse = new LatLng(36.979409, -122.05149);
	LatLng CarriageHouse = new LatLng(36.980019, -122.051987);
	LatLng CenterAO = new LatLng(36.998179, -122.060458);
	LatLng ClarkKerr = new LatLng(36.997017, -122.062005);
	LatLng ClassroomUnit = new LatLng(36.997943, -122.056842);
	LatLng Communications = new LatLng(37.000839, -122.061413);
	LatLng CoreWest = new LatLng(36.999074, -122.063605);
	LatLng DepartmentDigital = new LatLng(36.993873, -122.060565);
	LatLng EarthMarine = new LatLng(36.997857, -122.059378);
	LatLng EastField = new LatLng(36.994438, -122.054879);
	LatLng EastRemote = new LatLng(36.991028, -122.053251);
	LatLng EngineeringTwo = new LatLng(37.000933, -122.062779);
	LatLng EnvironHealthSafety = new LatLng(37.001567, -122.061509);
	LatLng ExperimentalTheater = new LatLng(36.995312, -122.061972);
	LatLng FamilyStudent = new LatLng(36.990951, -122.06769);
	LatLng FilmDigitalLab = new LatLng(36.997180, -122.065522);
	LatLng FireHouse = new LatLng(37.001829, -122.055608);
	LatLng RedwoodGroveApt = new LatLng(36.997823, -122.064108);
	LatLng HBarn = new LatLng(36.979561, -122.053487);
	LatLng HahnArt = new LatLng(36.997909, -122.052717);
	LatLng HealthCenter = new LatLng(36.999545, -122.057684);
	LatLng HumanitiesOne = new LatLng(36.998018, -122.054604);
	LatLng HumanitiesSocialSciences = new LatLng(36.998391, -122.054668);
	LatLng InfoKiosk = new LatLng(36.978666, -122.054068);
	LatLng InterdisciplinarySciences = new LatLng(36.998643, -122.059786);
	LatLng Joes = new LatLng(36.998123, -122.055797);
	LatLng KZSC = new LatLng(37.000610, -122.054135);
	LatLng McHenry = new LatLng(36.995595, -122.058893);
	LatLng MediaTheater = new LatLng(36.995192, -122.061649);
	LatLng MusicCenter = new LatLng(36.993020, -122.060662);
	LatLng NaturalSciencesTwo = new LatLng(36.998547, -122.060522);
	LatLng NorthPerimeter = new LatLng(37.002655, -122.065932);
	LatLng PhysicalSciences = new LatLng(36.999614, -122.062074);
	LatLng Police = new LatLng(36.979201, -122.052191);
	LatLng ScienceEngineering = new LatLng(36.999117, -122.060773);
	LatLng StudentUnion = new LatLng(36.997827, -122.055932);
	LatLng TheaterArts = new LatLng(36.995972, -122.061983);
	LatLng ThimannLabs = new LatLng(36.998119, -122.062051);
	LatLng ThimannLecture = new LatLng(36.997981, -122.061305);
	LatLng TicketOffice = new LatLng(36.994918, -122.062208);
	LatLng TrailerPark = new LatLng(37.001319, -122.066157);
	LatLng UniversityCenter = new LatLng(37.001004, -122.057686);
	LatLng UniversityHouse = new LatLng(36.992416, -122.061973);
	LatLng Village = new LatLng(36.986893, -122.055254);
	LatLng WagstaffFireside = new LatLng(36.996896, -122.051619);
	LatLng WellnessCenter = new LatLng(36.993581, -122.054539);
	LatLng WestFieldHouse = new LatLng(36.991390, -122.064139);
	
	LatLng DepartmentMusic = new LatLng(36.993024, -122.060664);
	
	building_list.add(new Building("Academic Resources Center - EOP", EOP));
	building_list.add(new Building("Arboretum", Arboretum));
	building_list.add(new Building("Art Department", DepartmentArt));
	building_list.add(new Building("Baobab Lounge", BaobabLounge));
	building_list.add(new Building("Barn G", BarnG));
	building_list.add(new Building("Barn Theater", BarnTheater));
	building_list.add(new Building("Baskin Engineering", BaskinEngineering));
	building_list.add(new Building("Baytree Bookstore", Baytree));
	building_list.add(new Building("Biomedical Sciences", BioMed));
	building_list.add(new Building("Campus Tours", CampusTours));
	building_list.add(new Building("Cantu Queer Center", CantuQueer));
	building_list.add(new Building("Career Center", CareerCenter));
	building_list.add(new Building("Cardiff House", CardiffHouse));
	building_list.add(new Building("Carriage House", CarriageHouse));
	building_list.add(new Building("Center for Adaptive Optics", CenterAO));
	building_list.add(new Building("Clark Kerr Hall", ClarkKerr));
	building_list.add(new Building("Classroom Unit", ClassroomUnit));
	building_list.add(new Building("Communications Building", Communications));
	building_list.add(new Building("Core West Parking", CoreWest));
	building_list.add(new Building("Digital Arts and New Media", DepartmentDigital));
	building_list.add(new Building("Earth and Marine Sciences", EarthMarine));
	building_list.add(new Building("East Field House", EastField));
	building_list.add(new Building("East Remote Parking", EastRemote));
	building_list.add(new Building("Engineering 2", EngineeringTwo));
	building_list.add(new Building("Environmental Health and Safety", EnvironHealthSafety));
	building_list.add(new Building("Experimental Theater", ExperimentalTheater));
	building_list.add(new Building("Family Student Housing", FamilyStudent));
	building_list.add(new Building("Film and Digital Media Social Documentation Lab", FilmDigitalLab));
	building_list.add(new Building("Fire House", FireHouse));
	building_list.add(new Building("Redwood Grove Apartments", RedwoodGroveApt));
	building_list.add(new Building("H Barn", HBarn));
	building_list.add(new Building("Hahn Art Facility", HahnArt));
	building_list.add(new Building("Health Center", HealthCenter));
	building_list.add(new Building("Humanities 1", HumanitiesOne));
	building_list.add(new Building("Humanities and Social Sciences", HumanitiesSocialSciences));
	building_list.add(new Building("Information Kiosk", InfoKiosk));
	building_list.add(new Building("Interdisciplinary Sciences", InterdisciplinarySciences));
	building_list.add(new Building("Joe's Pizza and Subs", Joes));
	building_list.add(new Building("KZSC Santa Cruz 88.1FM", KZSC));
	building_list.add(new Building("McHenry Library", McHenry));
	building_list.add(new Building("Media Theater", MediaTheater));
	building_list.add(new Building("Music Center", MusicCenter));
	building_list.add(new Building("Natural Sciences 2", NaturalSciencesTwo));
	building_list.add(new Building("North Perimeter Parking", NorthPerimeter));
	building_list.add(new Building("Physical Sciences", PhysicalSciences));
	building_list.add(new Building("Police", Police));
	building_list.add(new Building("Science and Engineering Library", ScienceEngineering));
	building_list.add(new Building("Student Union", StudentUnion));
	building_list.add(new Building("Theater Arts", TheaterArts));
	building_list.add(new Building("Thimann Labs", ThimannLabs));
	building_list.add(new Building("Thimann Lecture Hall", ThimannLecture));
	building_list.add(new Building("Ticket Office", TicketOffice));
	building_list.add(new Building("Trailer Park", TrailerPark));
	building_list.add(new Building("University Center", UniversityCenter));
	building_list.add(new Building("University House", UniversityHouse));
	building_list.add(new Building("The Village", Village));
	building_list.add(new Building("Wagstaff Fireside Lounge", WagstaffFireside));
	building_list.add(new Building("Wellness Center", WellnessCenter));
	building_list.add(new Building("West Field House", WestFieldHouse));
	
	
	building_list.add(new Building("Music Department", DepartmentMusic));
	
	
	return building_list;
}	

}
