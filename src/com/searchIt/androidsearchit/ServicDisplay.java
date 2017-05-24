package com.searchIt.androidsearchit;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
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
import com.android.volley.toolbox.Volley;
import com.searchIt.Vo.SearchITUrls;
import com.searchIt.Vo.ServicesHelp;
import com.searchIt.adpter.ServiceDisplayAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

public class ServicDisplay extends AppCompatActivity {
	
	Toolbar toolbar;
	GridView gridview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_display);
		
		toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		gridview=(GridView)findViewById(R.id.grideview);
		
		RequestQueue que=Volley.newRequestQueue(getApplicationContext());
		
	    JsonObjectRequest request=new JsonObjectRequest(Method.GET,SearchITUrls.SEARVICES_URL, null, createMyReqSuccessListener(), createMyReqErrorListener());
		que.add(request);
		
	}

	private ErrorListener createMyReqErrorListener() {
		// TODO Auto-generated method stub
		 return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_LONG).show();
              Log.e("error rafeek",error.toString());
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
					ServicesHelp servicesHelp=mapper.readValue(response.toString(), ServicesHelp.class);
					gridview.setAdapter(new ServiceDisplayAdapter(getApplicationContext(),servicesHelp));
					//serviceAdapter.notifyDataSetChanged();
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
	
	
	
}
