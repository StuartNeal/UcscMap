package com.example.ucscmap;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ArrayAdapterClassroom extends BaseAdapter {
	
	Context context;
	private ArrayList<Classroom> data;
	
	public ArrayAdapterClassroom(Context context, ArrayList<Classroom> data) {
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
		
		name.setText(data.get(pos).getName());
		loc.setText(data.get(pos).getLatLng().toString());
		
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
