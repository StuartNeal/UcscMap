package info.example.slidingmenu.model;

public class DrawerItem {
	private String title;
	private int icon;
	private boolean isCounterVisible = false;
	
	//Constructors
	public DrawerItem(){}
	
	public DrawerItem(String title, int icon){
		this.title = title;
		this.icon = icon;
	}
	
	//Get and Set methods
	public String getTitle(){
		return this.title;
	}
	
	public int getIcon(){
		return this.icon;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setIcon(int icon){
		this.icon = icon;
	}
}
