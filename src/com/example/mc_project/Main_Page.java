package com.example.mc_project;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main_Page extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main__page);
		Button carpool = (Button) findViewById(R.id.car_pool);
		Button fare = (Button) findViewById(R.id.fare);
		fare.setOnClickListener(this);
		carpool.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main__page, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.car_pool:

			break;
		case R.id.fare:
			
			break;

		default:
			break;
		}
	}

}
