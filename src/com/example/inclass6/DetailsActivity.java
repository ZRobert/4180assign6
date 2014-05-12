package com.example.inclass6;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.inclass6.*;

public class DetailsActivity extends Activity implements OnClickListener{
		// Button b;
		LinearLayout ll;
		TextView tv1;
		TextView tv2;
		TextView tv3;
		@Override
		public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.details_activity);
	        tv1 = (TextView) findViewById(R.id.textView1);
	        tv2 = (TextView) findViewById(R.id.textView2);
	        tv3 = (TextView) findViewById(R.id.textView3);
	        if(getIntent().getExtras()!=null){
	        	if (getIntent().getExtras().containsKey("Name")) {
	        		tv1.setText(getIntent().getExtras().getString("Name"));
	        	if(getIntent().getExtras().containsKey("Duration"))	
	        		tv2.setText(getIntent().getExtras().getString("Duration"));
	        	if(getIntent().getExtras().containsKey("Description"))	
	        		tv3.setText(getIntent().getExtras().getString("Description"));
	        	
	        	}
	        }
	        ll = (LinearLayout) findViewById(R.id.linearLayout1);
	        ll.setOnClickListener(this);
	    }
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
			
		}
	            
}

