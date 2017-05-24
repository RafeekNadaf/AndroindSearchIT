package com.searchIt.adpter;

import java.util.ArrayList;

import com.searchIt.Vo.ProviderDetails;
import com.searchIt.androidsearchit.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProviderdetailsAdpater extends BaseAdapter {
	
	Context context;
	LayoutInflater inflater;
	ArrayList<ProviderDetails> providerDetails;
	
	public ProviderdetailsAdpater(Context context,ArrayList<ProviderDetails> providerDetails){
		this.context=context;
		this.providerDetails=providerDetails;
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return providerDetails.size();
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
		
		
		inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		View view=inflater.inflate(R.layout.provider_list,parent,false);
		
		TextView provider_name=(TextView)view.findViewById(R.id.provider_name);
		TextView provider_adress=(TextView)view.findViewById(R.id.provider_adress);
		
		ImageButton call=(ImageButton)view.findViewById(R.id.provider_call);
		ImageButton email=(ImageButton)view.findViewById(R.id.provider_emailbtn);
		
		TextView provider_email=(TextView)view.findViewById(R.id.provider_email);
		TextView provider_number=(TextView)view.findViewById(R.id.provider_number);
		
	    provider_email.setText(providerDetails.get(position).getUser_email());
		provider_number.setText(providerDetails.get(position).getUser_phone_no());
		
		provider_name.setText(providerDetails.get(position).getUser_name());
		provider_adress.setText(providerDetails.get(position).getProvider_address());
		
		
		
		return view;
	}
	
}
