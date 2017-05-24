package com.searchIt.androidsearchit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.searchIt.Vo.Districts;
import com.searchIt.Vo.ProviderDetails;
import com.searchIt.Vo.SearchITUrls;
import com.searchIt.Vo.ServicesHelp;
import com.searchIt.Vo.States;
import com.searchIt.adpter.ServiceAdapter;
import com.searchIt.adpter.StateAdapter;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	Toolbar toolbar;
	static CheckBox isProvider;
	EditText username;
	EditText email;
	EditText phone_number;
	EditText password;
	Button submit;
	int isActivedailogfalse;
	FragmentManager fm = getSupportFragmentManager();
	ProviderDetails providerDetails;
	static int notProvider=0;
	public static final List<Long> serviceids=new ArrayList<Long>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		
		username=(EditText)findViewById(R.id.username);
		email=(EditText)findViewById(R.id.emailId);
		phone_number=(EditText)findViewById(R.id.phoneNumber);
		password=(EditText)findViewById(R.id.password);
		isProvider=(CheckBox)findViewById(R.id.isprovider);
		submit=(Button)findViewById(R.id.btnSingIn);
		
		checkBoxActivity();
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				 if(ServiceProviderDailog.providerDetails!=null){
					 
					 if(ServiceProviderDailog.providerDetails.getIs_service_provider()==1){
						 
						    ServiceProviderDailog.providerDetails.setUser_name(username.getText().toString());
							ServiceProviderDailog.providerDetails.setUser_email(email.getText().toString());
							ServiceProviderDailog.providerDetails.setUser_phone_no(phone_number.getText().toString());
							ServiceProviderDailog.providerDetails.setProvider_password(password.getText().toString());
							ServiceProviderDailog.providerDetails.setServiceid(serviceids);
							
							Log.i("serviceids from multi select",serviceids.toString());
							Log.i("ServiceProviderDailog.providerDetails",ServiceProviderDailog.providerDetails.toString());
							
							StringRequest stringrequest=new StringRequest(Method.POST,SearchITUrls.SiIGNUP,new Response.Listener<String>() {

								@Override
								public void onResponse(String responce) {
									// TODO Auto-generated method stub
									Log.i("response",responce);
									AlertDailogBox(Integer.parseInt(responce));
								}
								
							},  new Response.ErrorListener() {

								@Override
								public void onErrorResponse(VolleyError arg0) {
									Toast.makeText(getApplicationContext(),arg0.toString(),Toast.LENGTH_SHORT).show();
								}
							}){
								
								@Override
								protected Map<String,String> getParams(){
									Log.i("usersignup", ServiceProviderDailog.providerDetails.toString());
									Map<String,String> map=new HashMap<String,String>();
									map.put("usersignup",new Gson().toJson(ServiceProviderDailog.providerDetails));
									return map;
								}
							};
							RequestQueue que=Volley.newRequestQueue(getApplicationContext());
						    que.add(stringrequest);
						 
					}else{
						Toast.makeText(getApplicationContext(), "is Is_service_provider not 1", Toast.LENGTH_LONG).show();
					}
					
				}else{
					providerDetails=new ProviderDetails();
					
					providerDetails.setUser_name(username.getText().toString());
					providerDetails.setUser_email(email.getText().toString());
					providerDetails.setUser_phone_no(phone_number.getText().toString());
					providerDetails.setProvider_password(password.getText().toString());
					providerDetails.setIs_service_provider(0);
					
					Log.i("ServiceProviderDailog.providerDetails",providerDetails.toString());
					
					StringRequest stringrequest=new StringRequest(Method.POST,SearchITUrls.SiIGNUP,new Response.Listener<String>() {

						@Override
						public void onResponse(String responce) {
							// TODO Auto-generated method stub
							Log.i("response",responce);
						     AlertDailogBox(Integer.parseInt(responce));
						}
						
					},  new Response.ErrorListener() {

						@Override
						public void onErrorResponse(VolleyError arg0) {
							Toast.makeText(getApplicationContext(),arg0.toString(),Toast.LENGTH_SHORT).show();
						}
					}){
						
						@Override
						protected Map<String,String> getParams(){
							Log.i("usersignup",providerDetails.toString());
							Map<String,String> map=new HashMap<String,String>();
							map.put("usersignup",new Gson().toJson(providerDetails));
							return map;
						}
					};
					RequestQueue que=Volley.newRequestQueue(getApplicationContext());
				    que.add(stringrequest);
				}
				
			}
		});
		
	}
	
	public void AlertDailogBox(final int message){
		
		Toast.makeText(getApplicationContext(), ""+message, Toast.LENGTH_LONG).show();
		String ms = null;
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this,R.style.Base_Theme_AppCompat_Dialog_Alert);
		alertDialogBuilder.setTitle("Notification");
		
				if(message==1 || message==2){
					ms="Add Successfuly.";
				}else{
					ms="This User Id aleredy extist.";
				}
			
				alertDialogBuilder.setMessage(ms)
				.setCancelable(false)
				.setInverseBackgroundForced(true)
				.setNeutralButton("Ok",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								//dialog.cancel();
								if(message==1){
								 startActivity(new Intent(getApplicationContext(),ServicDisplay.class));
								}
								if(message==2){
									 startActivity(new Intent(getApplicationContext(),ProviderDashBoard.class));
								}
								//getApplicationContext().startActivity(new Intent(getApplicationContext(),SearchItSignIn.class));
					}
				});
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
		 
				
		
	}
	
	private void checkBoxActivity() {
		
		isProvider.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked){
					notProvider=1;
					ServiceProviderDailog serviceProviderDetails=new ServiceProviderDailog();
					serviceProviderDetails.show(fm, "Service Provider Information");
					isActivedailogfalse=serviceProviderDetails.isDailogboxfalse;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

//Dialog box for fragment.

class ServiceProviderDailog extends DialogFragment{
	
	EditText provider_pincode,provider_address;
	Button cancel,ok;
	Spinner provider_state,provider_distic,servies_provides;
	View rootView;
	static List<String> states=new ArrayList<String>();
	RequestQueue que;
	static ProviderDetails providerDetails;
	String prd_distic=null;
	String prdState=null;
	int prd_state=0;
	
	int isDailogboxfalse=0;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 rootView = inflater.inflate(R.layout.serviceproviderdetails, container,false);
		
		provider_pincode=(EditText)rootView.findViewById(R.id.pincode);
		provider_address=(EditText)rootView.findViewById(R.id.address);
		
		servies_provides=(Spinner)rootView.findViewById(R.id.services);
		servies_provides.setPrompt("Select Services");
		
		provider_distic=(Spinner)rootView.findViewById(R.id.distic);
		provider_distic.setPrompt("Select Distic");
		
		provider_state=(Spinner)rootView.findViewById(R.id.state);
		
		cancel=(Button)rootView.findViewById(R.id.cancel_btn);
		ok=(Button)rootView.findViewById(R.id.ok_btn);
		
		
		que=Volley.newRequestQueue(getActivity());
		
		gettingProvider_State();
		gettingServices();
		
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				providerDetails=new ProviderDetails();
				providerDetails.setProvider_pincode(Integer.parseInt(provider_pincode.getText().toString()));
				providerDetails.setProvider_address(provider_address.getText().toString());
			    providerDetails.setProvider_area(prdState);
			    Log.i("prd_distic",""+prd_distic);
			    providerDetails.setProvider_district(prd_distic);
			    providerDetails.setService_provider_id(1l);
			    
			    Log.i("notProvider",""+MainActivity.notProvider);
			    if(MainActivity.notProvider!=0){
			    	providerDetails.setIs_service_provider(1);
			    	Log.i("in if condition",""+providerDetails.getIs_service_provider());
			    }else{
			    	providerDetails.setIs_service_provider(0);
			    	Log.i("kdsjfhjdsjhsdj",""+providerDetails.getIs_service_provider());
			    }
			    
				dismiss();
			}
		});
		
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MainActivity.isProvider.setChecked(false);
				MainActivity.notProvider=0;
				dismiss();
			}
		});
		
		return rootView;
	}

	private void gettingServices() {
		JsonObjectRequest services_name=new JsonObjectRequest(Method.GET,SearchITUrls.SEARVICES_LIST, null, createMyReqSuccessListenerServices(),createMyReqErrorListenerServices());
		que.add(services_name);//getting services
		
		servies_provides.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				Log.i("hhhh selected",String.valueOf(position));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
			}
			
		});
	}

	private Listener<JSONObject> createMyReqSuccessListenerServices() {
		// TODO Auto-generated method stub
		return new Response.Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				
				ObjectMapper mapper=new ObjectMapper();
				try {
					final ServicesHelp servicesHelp=mapper.readValue(response.toString(), ServicesHelp.class);
					Log.i("Service List",servicesHelp.getService_provides().toString());
					ServiceAdapter sp=new ServiceAdapter(getContext(),servicesHelp.getService_provides());
					servies_provides.setAdapter(sp);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
	}

	private ErrorListener createMyReqErrorListenerServices() {
		// TODO Auto-generated method stub
		return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              Toast.makeText(getActivity(),error.toString(), Toast.LENGTH_LONG).show();
              Log.e("error rafeek",error.toString());
            }
        };
	}

	private void gettingProvider_State() {
		
		JsonObjectRequest request=new JsonObjectRequest(Method.GET,SearchITUrls.STATES_URL, null, createMyReqSuccessListener(),createMyReqErrorListener());
		que.add(request); //getting states.
		provider_state.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
				Log.i("You clicked",states.get(position));
				prdState=states.get(position);
				getDistrict_Name(states.get(position));
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	private ErrorListener createMyReqErrorListener() {
		
		return new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError arg0) {
				Log.e("error in State fetching",arg0.toString());
			}
			
		};
	}

	private Listener<JSONObject> createMyReqSuccessListener() {
		return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
            	Log.i("responce", response.toString());
            	ObjectMapper mapper=new ObjectMapper();
            	
            	try {
            		final ServicesHelp servicesHelp=mapper.readValue(response.toString(), ServicesHelp.class);
					Log.i("servicesHelp",servicesHelp.getStates().toString());
					if(servicesHelp!=null){
						StateAdapter state=new StateAdapter(getContext(),servicesHelp.getStates());
						provider_state.setAdapter(state);
					}
					
					for(int i=0; i<servicesHelp.getStates().size(); i++){
						states.add(servicesHelp.getStates().get(i).getState_name());
					}
					
					/*GetStateData(servicesHelp.getStates());//getting states
					for(int i=0; i<servicesHelp.getStates().size(); i++){
						Log.i("State_name",servicesHelp.getStates().get(i).getState_name());
					}*/
					
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            }
            
         };
	}
	
  /*public void GetStateData(List<States> state_name){
		
		states.add("Select State");
		for(int i=0; i<state_name.size(); i++){
			states.add(state_name.get(i).getState_name());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),R.layout.spinner_list, states);
		adapter.setDropDownViewResource(R.layout.spinner_list);
		provider_state.setAdapter(adapter);
	}*/
	
  public void getDistrict_Name(final String name){
	  
	 StringRequest stringrequest=new StringRequest(Method.POST,SearchITUrls.DISTRICT_URL,
				new Response.Listener<String>() {

					@Override
					public void onResponse(String responce) {
						Log.i("district",responce);
						ObjectMapper mapper=new ObjectMapper();
						try {
							ServicesHelp servicesHelp=mapper.readValue(responce, ServicesHelp.class);
							
							if(servicesHelp.getDistrics()!=null || servicesHelp.getDistrics().size()!=0){
								ArrayList<String> district=new ArrayList<String>();
								district.add("Select District");
								
								for(int i=0; i<servicesHelp.getDistrics().size(); i++){
									district.add(servicesHelp.getDistrics().get(i).getDistrict_name());
								}
								
								ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_list1,district);
								adapter.setDropDownViewResource(R.layout.spinner_list1);
								provider_distic.setAdapter(adapter);
							}
							//GetDistrictData(servicesHelp.getDistrics());//getting districts
							
							provider_distic.setOnItemSelectedListener(new OnItemSelectedListener() {

								@Override
								public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
									prd_distic=String.valueOf(position);
									//providerDetails.setProvider_district(prd_distic);
								}

								@Override
								public void onNothingSelected(
										AdapterView<?> parent) {
									// TODO Auto-generated method stub
								}
							});
							
							
							
						} catch (JsonParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonMappingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}, new Response.ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError arg0) {
					
				}
			}){
				@Override
				protected Map<String,String> getParams(){
					Map<String,String> map=new HashMap<String,String>();
					map.put("state_name", name);
					return map;
				}
			};
			RequestQueue que=Volley.newRequestQueue(getActivity());
		    que.add(stringrequest);
	}
		
	  /*public void GetDistrictData(ArrayList<Districts> districts){
		  ArrayList<String> district=new ArrayList<String>();
			district.add("Select District");
			for(int i=0; i<districts.size(); i++){
				district.add(districts.get(i).getDistrict_name());
			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_list, district);
			adapter.setDropDownViewResource(R.layout.spinner_list);
			provider_distic.setAdapter(adapter);
			
		}*/

}
