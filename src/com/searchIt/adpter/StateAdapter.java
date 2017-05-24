package com.searchIt.adpter;

import java.util.List;

import com.searchIt.Vo.ServicesHelp;
import com.searchIt.Vo.States;
import com.searchIt.androidsearchit.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StateAdapter extends BaseAdapter{
	
	Context cxt;
	List<States> states;
	LayoutInflater inflater;
	ServicesHelp servicesHelp;
	
	public StateAdapter(Context context,List<States> servicesHelp){
		this.cxt=context;
		this.states=servicesHelp;
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return states.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		inflater=(LayoutInflater)cxt.getSystemService(cxt.LAYOUT_INFLATER_SERVICE);
		View view=inflater.inflate(R.layout.spinner_list,parent,false);
		
		TextView text=(TextView)view.findViewById(R.id.state_name);
		text.setText(states.get(position).getState_name());
		
		
		/*view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
			}
		});*/
		
		return view;
	}
	
	

}
