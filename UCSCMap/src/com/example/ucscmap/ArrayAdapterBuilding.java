package com.example.ucscmap;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ArrayAdapterBuilding extends BaseAdapter {
	
	Context context;
	private ArrayList<Building> data;
	
	public ArrayAdapterBuilding(Context context, ArrayList<Building> data) {
		//super(context,  R.layout.listview_layout, data);
		
		this.context = context;
		this.data = data;
	}
	
	public View getView(int pos, View convertView, ViewGroup parent){
		
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listview_layout, null);	
		}
		
		TextView name = (TextView) convertView.findViewById(R.id.itemName);
		TextView loc = (TextView) convertView.findViewById(R.id.itemLocation);
		
		ImageView icon = (ImageView) convertView.findViewById(R.id.itemImage);
		
		name.setText(data.get(pos).getName());
		loc.setText(data.get(pos).getLatLng().toString());
		icon.setImageResource(R.drawable.building_symbol);
		
		return convertView;
		
	}

	@Override
	public int getCount(){
		return data.size();
	}
	
	@Override
	public Object getItem(int pos){
		return data.get(pos);
	}
	
	@Override
	public long getItemId(int pos){
		return pos;
	}

}
