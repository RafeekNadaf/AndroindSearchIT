package com.searchIt.adpter;

import java.io.Serializable;
import java.util.ArrayList;

import com.searchIt.Vo.ProviderDetails;
import com.searchIt.Vo.ServicesHelp;
import com.searchIt.androidsearchit.ProviderDetailsActivity;
import com.searchIt.androidsearchit.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ServiceDisplayAdapter extends BaseAdapter {
	
	Context context;
	ServicesHelp data;
	LayoutInflater inflater;
	ServicesHelp result=new ServicesHelp();
	
	public ServiceDisplayAdapter(Context context,ServicesHelp data){
		this.context=context;
		this.data=data;
		
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.getService_provides().size();
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
		
		TextView services;
		
	    inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View view=inflater.inflate(R.layout.servicedisplaytext,parent,false);
		
		services=(TextView)view.findViewById(R.id.services);
		services.setText(data.getService_provides().get(position).getService_provider_name());
		
		final int ps=position;
		
        view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ArrayList<ProviderDetails> providerDetails=data.getService_provides().get(ps).getProviderDetails();
				Intent i=new Intent(context,ProviderDetailsActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				Bundle b=new Bundle();
				b.putString("service_provider_name", data.getService_provides().get(ps).getService_provider_name());
				
				if(!data.getService_provides().get(ps).getProviderDetails().isEmpty()){
					b.putInt("isempty", 1);
					i.putExtra("service",(Serializable)providerDetails);
					b.putLong("service_provider_id", data.getService_provides().get(ps).getService_provider_id());
					i.putExtras(b);
					context.startActivity(i);
					Log.i("provider_details", data.getService_provides().get(ps).getProviderDetails().toString());
					
				}else{
					
					b.putInt("isempty", 2);
					i.putExtras(b);
					context.startActivity(i);
					Log.i("provider_details","there is no provides");
				}
				
			}
		});
		
		
		return view;
	}

}
