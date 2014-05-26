package com.example.ucscmap;

import info.example.slidingmenu.adapter.DrawerListAdapter;
import info.example.slidingmenu.model.DrawerItem;

import java.util.ArrayList;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.common.GooglePlayServicesUtil;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;

@SuppressLint("NewApi") public class MapActivity extends FragmentActivity{
	
	private static LatLng USER;
	private GoogleMap map;
	boolean userMarker = false;
	Marker myMark = null;
	String title;
	
	//Drawer variables
	private DrawerLayout drawer;
	private ListView drawerList;
	private ActionBarDrawerToggle drawerToggle;
	
	private CharSequence drawerTitle;
	private CharSequence appTitle;
	
	private String[] navMenuItems;
	private TypedArray navMenuIcons;
	
	private ArrayList<DrawerItem> drawerItems;
	private DrawerListAdapter drawerAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_map);
    	
    	ActionBar actionBar = getActionBar();
    	actionBar.setIcon(R.drawable.home_icon);
    	
    	MapsInitializer.initialize(getApplicationContext());
    	GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        
        //Sets up drawer items
        appTitle = drawerTitle = getTitle();
        
        //Gets Array of Menu Items
        navMenuItems = getResources().getStringArray(R.array.nav_drawer_items);
        
        //Gets Array of Menu Icons
        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);
        
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.list_slidermenu);
        
        //Creates new array list of Drawer Items
        drawerItems = new ArrayList<DrawerItem>();
        
        //Home Item
        drawerItems.add(new DrawerItem(navMenuItems[0], navMenuIcons.getResourceId(0, -1)));
        //Buildings Item
        drawerItems.add(new DrawerItem(navMenuItems[1], navMenuIcons.getResourceId(1, -1)));
        //Classroom Item
        drawerItems.add(new DrawerItem(navMenuItems[2], navMenuIcons.getResourceId(2, -1)));
        //Schedule Item
        drawerItems.add(new DrawerItem(navMenuItems[3], navMenuIcons.getResourceId(3, -1)));
        //Logout Item
        drawerItems.add(new DrawerItem(navMenuItems[4], navMenuIcons.getResourceId(4, -1)));
        
        navMenuIcons.recycle();
        
        drawerAdapter = new DrawerListAdapter(getApplicationContext(), drawerItems);
        drawerList.setAdapter(drawerAdapter);
        
        drawerToggle = new ActionBarDrawerToggle(this, drawer, 
        		R.drawable.ic_drawer,
        		R.string.drawer_open,
        		R.string.drawer_close
        ){
        	public void onDrawerClosed(View view){
        		getActionBar().setTitle(appTitle);
        		invalidateOptionsMenu();
        	}
        	
        	public void onDrawerOpened(View drawerView){
        		getActionBar().setTitle(drawerTitle);
        		invalidateOptionsMenu();
        	}
        };
        drawer.setDrawerListener(drawerToggle);
        drawerList.setOnItemClickListener(new SlideMenuClickListener());
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        
        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.activity_map_actions, menu);
        
        //Sets up the search widget
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        
        return super.onCreateOptionsMenu(menu);
    }
    
    //Options menu Button Selector
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	if(drawerToggle.onOptionsItemSelected(item)){
    		return true;
    	}
        switch(item.getItemId()){
        
        case R.id.action_search:
        	return true;
        case R.id.action_location_found:
        	Toast.makeText(this, "Placing marker at current location", Toast.LENGTH_SHORT).show();
        	getCurrentLocation();
        	return true;
        case R.id.action_refresh:
        	Toast.makeText(this, "Refreshing map", Toast.LENGTH_SHORT).show();
        	return true;
        case R.id.action_help:
        	return true;
        case R.id.action_check_updates:
        	Toast.makeText(this, "Checking for updates", Toast.LENGTH_SHORT).show();
        	return true;
        default:
        	return super.onOptionsItemSelected(item);
        } 
    }
    
    //Click Listener for Slider Menu
    private class SlideMenuClickListener implements ListView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int pos,
				long id) {
			//Chooses the fragment to display based on user selection
			displayView(pos);
		}
    }
    
    //Chooses which fragment to display depending on button click
    private void displayView(int pos){
    	Fragment fragment = null;
    switch(pos){
    	//Returns home
    	case 0:
    		fragment = new mapFragment();
    		break;
    	//Starts Buildings Fragment
    	case 1:
    		fragment = new BuildingFragment();
    		break;
    	//Starts Classroom Fragment
    	case 2:
    		fragment = new ClassroomFragment();
    		break;
    	//Starts Schedule Fragment
    	case 3:
    		fragment = new ScheduleFragment();
    		break;
    	//Logs out
    	case 4:
    		Intent intent = new Intent(MapActivity.this, MainActivity.class);
    		startActivity(intent);
    		finish();
    		break;
    	default:
    		break;
    	}
    
    	//Switches to the correct fragment
    	if(fragment != null){
    		 
    		FragmentManager fragmentManager = getFragmentManager();
    		fragmentManager.beginTransaction().replace(R.id.frame_container , fragment).commit();
    		
    		drawerList.setItemChecked(pos, true);
    		drawerList.setSelection(pos);
    		setTitle(navMenuItems[pos]);
    		drawer.closeDrawer(drawerList);
    	}else{
    		Log.e("MapActivity", "Error Creating Fragment");
    	}
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState){
    	super.onPostCreate(savedInstanceState);
    	drawerToggle.syncState();
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig){
    	super.onConfigurationChanged(newConfig);
    }

    //Gets the Users Current Location
    void getCurrentLocation(){
    	map.setMyLocationEnabled(true);
    	Location myLoc  = map.getMyLocation();
    	
    	if(myLoc != null){
    		double myLat = myLoc.getLatitude();
    		double myLong = myLoc.getLongitude();
    		USER = new LatLng(myLat, myLong);
    		
    		if(userMarker) myMark.remove();
    		
    		myMark = map.addMarker(new MarkerOptions()
        				.position(USER)
        				.title("YOU")
        				.icon(BitmapDescriptorFactory
        				.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
    		
    		userMarker = true;
    		
    		map.moveCamera(CameraUpdateFactory.newLatLngZoom(USER, 15));
    		
    	}else{
    		Toast.makeText(this, "Unable to get your current location", Toast.LENGTH_SHORT).show();
    	}
    	
    }
    
}