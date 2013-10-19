package com.example.mc_project;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Nav_Main extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nav__main);

		TabHost tabHost = getTabHost();

		TabSpec Metrospec = tabHost.newTabSpec("Metro");

		Metrospec.setIndicator("Metro",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent MetroIntent = new Intent(this, Metro.class);
		Metrospec.setContent(MetroIntent);

		TabSpec Autospec = tabHost.newTabSpec("Auto");
		Autospec.setIndicator("Auto",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent AutoIntent = new Intent(this, Auto.class);
		Autospec.setContent(AutoIntent);

		TabSpec Taxispec = tabHost.newTabSpec("Taxi");
		Taxispec.setIndicator("Taxi",
				getResources().getDrawable(R.drawable.ic_launcher));
		Intent TaxisIntent = new Intent(this, Taxi.class);
		Taxispec.setContent(TaxisIntent);

		tabHost.addTab(Metrospec);
		tabHost.addTab(Autospec);
		tabHost.addTab(Taxispec);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nav__main, menu);
		return true;
	}

}
