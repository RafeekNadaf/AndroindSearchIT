package com.searchIt.adpter;


import java.util.List;

import com.searchIt.Vo.Services;
import com.searchIt.Vo.ServicesHelp;
import com.searchIt.androidsearchit.MainActivity;
import com.searchIt.androidsearchit.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ServiceAdapter extends BaseAdapter{

	Context context;
	List<Services> data;
	LayoutInflater inflater;
	ServicesHelp result=new ServicesHelp();
	public static Long[] sertviceprovider; 
	
	public ServiceAdapter(Context context1,List<Services> data1) {
		this.context=context1;
		this.data=data1;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
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
	public View getView(final int position, View convertView, ViewGroup parent) {		
		final TextView services;
		final CheckBox check;
		
	    inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View view=inflater.inflate(R.layout.services_layout,parent,false);
		
		services=(TextView)view.findViewById(R.id.service_name);
		check=(CheckBox)view.findViewById(R.id.service_id);
		
		services.setText(data.get(position).getService_provider_name());
		
		check.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if(isChecked){
					
					if(data.get(position).getService_provider_name().equals(services.getText().toString())){
						check.setChecked(true);
						MainActivity.serviceids.add(data.get(position).getService_provider_id());
						Toast.makeText(context, ""+data.get(position).getService_provider_id(), Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
		
		return view;
	}
	
}
