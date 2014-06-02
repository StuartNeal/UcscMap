package com.example.ucscmap;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

public class BuildingList {
	
	public static ArrayList<Building> building_list = new ArrayList<Building>();
	
public static ArrayList<Building> createBuildingList(){
	
	//Colleges 
	LatLng COWELL = new LatLng(36.996648 , -122.054166);
	LatLng STEVENSON = new LatLng(36.996887 , -122.051917);
	LatLng CROWN = new LatLng(36.999614 , -122.054978);
	LatLng MERRILL = new LatLng(36.999395 , -122.053051);
	LatLng NINETEN = new LatLng(37.001386 , -122.058335);
	LatLng KRESGE = new LatLng(36.997786 , -122.065951);
	LatLng PORTER = new LatLng(36.994354 , -122.065468);
	LatLng EIGHT = new LatLng(36.991206, -122.064369);
	LatLng OAKES = new LatLng(36.989044 , -122.064408);
	
	building_list.add(new Building("Cowell", COWELL));
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
	LatLng CardiffHouse = new LatLng(36.979409, -122.05149);
	LatLng CarriageHouse = new LatLng(36.980019, -122.051987);
	LatLng CenterAO = new LatLng(36.998179, -122.060458);
	LatLng ClarkKerr = new LatLng(36.997017, -122.062005);
	LatLng ClassroomUnit = new LatLng(36.997943, -122.056842);
	LatLng Communications = new LatLng(37.000839, -122.061413);
	LatLng CoreWest = new LatLng(36.999074, -122.063605);
	LatLng DepartmentDigital = new LatLng(36.93860, -122.060517);
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
	LatLng KZSC = new LatLng(37.000610, -122.054135);
	LatLng MediaTheater = new LatLng(36.995192, -122.061649);
	LatLng MusicCenter = new LatLng(36.993020, -122.060662);
	LatLng NaturalSciencesTwo = new LatLng(36.998547, -122.060522);
	LatLng NorthPerimeter = new LatLng(37.002655, -122.065932);
	LatLng PhysicalSciences = new LatLng(36.999614, -122.062074);
	LatLng Police = new LatLng(36.979201, -122.052191);
	LatLng ScienceEngineering = new LatLng(36.999117, -122.060773);
	LatLng StudentUnion = new LatLng(36.997827, -122.055932);
	
	LatLng DepartmentMusic = new LatLng(36.993024, -122.060664);
	LatLng McHenry = new LatLng(36.995595, -122.058893);
	LatLng CareerCenter = new LatLng(36.997838, -122.05551);
	LatLng Joes = new LatLng(36.998123, -122.055797);
	
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
	building_list.add(new Building("KZSC Santa Cruz 88.1FM", KZSC));
	building_list.add(new Building("Media Theater", MediaTheater));
	building_list.add(new Building("Music Center", MusicCenter));
	building_list.add(new Building("Natural Sciences 2", NaturalSciencesTwo));
	building_list.add(new Building("North Perimeter Parking", NorthPerimeter));
	building_list.add(new Building("Physical Sciences", PhysicalSciences));
	building_list.add(new Building("Police", Police));
	building_list.add(new Building("Science and Engineering Library", ScienceEngineering));
	building_list.add(new Building("Student Union", StudentUnion));
	
	building_list.add(new Building("Music Department", DepartmentMusic));
	building_list.add(new Building("McHenry Library", McHenry));
	building_list.add(new Building("Career Center", CareerCenter));
	building_list.add(new Building("Joe's Pizza and Subs", Joes));
	
	return building_list;
}	
	
	

}
