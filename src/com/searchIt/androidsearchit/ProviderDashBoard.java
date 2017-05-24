package com.searchIt.androidsearchit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ProviderDashBoard extends AppCompatActivity{
	
		  private String[] drawerListViewItems;
	      private DrawerLayout drawerLayout;
	      private ListView drawerListView;
	      private ActionBarDrawerToggle actionBarDrawerToggle;
		  Toolbar toolbar;
		  private FrameLayout frame;
		  private View navHeader;
		  LinearLayout layout;
	    
	    @Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.providerdashboard);
			
			toolbar=(Toolbar)findViewById(R.id.toolbar);
			setSupportActionBar(toolbar);
			
			drawerListViewItems = getResources().getStringArray(R.array.items);
			
			// 2. App Icon 
			drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
			layout=(LinearLayout)findViewById(R.id.menu);

			// get ListView defined in activity_main.xml
			drawerListView = (ListView) findViewById(R.id.left_drawer);
			
			frame = (FrameLayout) findViewById(R.id.fragment_container);
			
			// Set the adapter for the list view
			drawerListView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_listview_item, drawerListViewItems));
	      
			

			// 2.1 create ActionBarDrawerToggle
			actionBarDrawerToggle = new ActionBarDrawerToggle( this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
			
			// 2.2 Set actionBarDrawerToggle as the DrawerListener
	        drawerLayout.setDrawerListener(actionBarDrawerToggle);
	        
	        
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true); 
	        getSupportActionBar().setHomeButtonEnabled(true);
	        actionBarDrawerToggle.syncState();
	       
	        drawerListView.setOnItemClickListener(new DrawerItemClickListener());
			
		}
	    
	    private class DrawerItemClickListener implements ListView.OnItemClickListener {
		    
	    	@Override
			public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {
	    		
	    		ShowItems(position);
	    		
	    		drawerLayout.closeDrawer(layout); //
			}

			private void ShowItems(int position) {
				
				if(position==0){
					
					Toast.makeText(getApplicationContext(), "profile clicked", Toast.LENGTH_SHORT).show();
					Fragment fragment = new ProfileFragment();
					FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
	                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
	                fragmentTransaction.replace(R.id.fragment_container, fragment,"Profile");
	                fragmentTransaction.commitAllowingStateLoss();
					
				}
				
				if(position==1){
					
					Fragment fragment1 = new ServiceFragment();
					FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
	                fragmentTransaction1.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
	                fragmentTransaction1.replace(R.id.fragment_container, fragment1,"Service");
	                fragmentTransaction1.commitAllowingStateLoss();
					
				}
				
				if(position==2){
					
					Fragment fragment2 = new SettingFragment();
					FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
					fragmentTransaction2.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
					fragmentTransaction2.replace(R.id.fragment_container, fragment2,"Setting profile");
					fragmentTransaction2.commitAllowingStateLoss();
					
				}
				
				
			}
		}
	    
	    
}
