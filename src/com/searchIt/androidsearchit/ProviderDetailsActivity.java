package com.searchIt.androidsearchit;

import java.util.ArrayList;

import com.searchIt.Vo.ProviderDetails;
import com.searchIt.adpter.ProviderdetailsAdpater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ProviderDetailsActivity extends AppCompatActivity{
	
	Toolbar toolbar;
	
	TextView  service_provider_name;
	TextView noprovider;
	ListView  provider_list;
	ProviderdetailsAdpater serviceProvidesAdapter;
	FragmentManager fm = getSupportFragmentManager();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.providerdetails);
		
		toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		service_provider_name=(TextView)findViewById(R.id.service_name);
		noprovider=(TextView)findViewById(R.id.empty);
		provider_list=(ListView)findViewById(R.id.provider_list);
		
		Intent innt=this.getIntent();
		Bundle bundel=innt.getExtras();
		
	
		
		Long service_provider_id=bundel.getLong("service_provider_id");
		int isempty=bundel.getInt("isempty");
		 service_provider_name.setText(bundel.getString("service_provider_name"));
		
		if(isempty==1){
	    	serviceProvidesAdapter=new ProviderdetailsAdpater(getApplicationContext(),(ArrayList<ProviderDetails>)innt.getSerializableExtra("service"));
		    provider_list.setAdapter(serviceProvidesAdapter);
	    }
		if(isempty==2){
			Log.i("isempty",String.valueOf(isempty));
			noprovider.setVisibility(View.VISIBLE);
			provider_list.setVisibility(View.GONE);
	  }
		
		
		
	}

}
