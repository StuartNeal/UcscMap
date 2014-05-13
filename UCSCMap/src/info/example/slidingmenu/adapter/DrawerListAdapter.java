package info.example.slidingmenu.adapter;

import com.example.ucscmap.R;

import info.example.slidingmenu.model.DrawerItem;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerListAdapter extends BaseAdapter{
	
	private Context context;
	private ArrayList<DrawerItem> drawerItems;
	
	public DrawerListAdapter(Context context, ArrayList<DrawerItem> drawerItems){
		this.context = context;
		this.drawerItems = drawerItems;
	}
	
	@Override
	public int getCount(){
		return drawerItems.size();
	}
	
	@Override
	public Object getItem(int pos){
		return drawerItems.get(pos);
	}
	
	@Override
	public long getItemId(int pos){
		return pos;
	}
	
	@Override
	public View getView(int pos, View convertView, ViewGroup parent){
		if(convertView == null){
			LayoutInflater mInflator = (LayoutInflater)
					context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflator.inflate(R.layout.drawer_list_item, null);
		}
		ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
		TextView title = (TextView) convertView.findViewById(R.id.title);
		
		icon.setImageResource(drawerItems.get(pos).getIcon());
		title.setText(drawerItems.get(pos).getTitle());
		
		return convertView;
	}
		
}
