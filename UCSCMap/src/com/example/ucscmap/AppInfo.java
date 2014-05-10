package com.example.ucscmap;

public class AppInfo {
	//the singleton instance of the AppInfo
	private static AppInfo instance;
	
	//declare any other variables here
	
	/**
	 * Constructor is protected to defeat instantiation
	 */
	protected AppInfo(){
		//initialize any other variables here
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

}
