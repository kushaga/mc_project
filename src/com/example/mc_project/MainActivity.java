package com.example.mc_project;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private String[] mPlanetTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence title;

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		this.onDestroy();
		// kill the activity on pause.
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button fare = (Button) findViewById(R.id.fare);
		fare.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getBaseContext(), Nav_Main.class));
			}
		});
		Button carpool = (Button) findViewById(R.id.car_pool);
		carpool.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// launch car pool activity here.
				
			}
		});
		title = getActionBar().getTitle();
		mPlanetTitles = getResources()
				.getStringArray(R.array.operating_systems);
		System.out.println(mPlanetTitles.length);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// Set the adapter for the list view
		mDrawerList
				.setAdapter(new ArrayAdapter<String>(this,
						R.layout.fragment_layout, R.id.textView_fragment,
						mPlanetTitles));
		// Set the list's click listener
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			/** Called when a drawer has settled in a completely closed state. */

			public void onDrawerClosed(View view) {
				getActionBar().setTitle(title);
			}

			/** Called when a drawer has settled in a completely open state. */

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle("Open Drawer");
			}
		};

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle your other action bar items...
		switch (item.getItemId()) {
		case R.id.action_settings:
			Toast.makeText(this, "Settings selected", Toast.LENGTH_LONG).show();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void selectItem(int position) {
		Class_Fragment fragment = new Class_Fragment();
		Bundle args = new Bundle();
		args.putInt(Class_Fragment.ARG_OS, position);
		fragment.setArguments(args);
		android.app.FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();

		// Highlight the selected item, update the title, and close the drawer
		mDrawerList.setItemChecked(position, true);

		getActionBar().setTitle((mPlanetTitles[position]));

		if (position == 0) {
			startActivity(new Intent(getBaseContext(), MainActivity.class));
		}

		mDrawerLayout.closeDrawer(mDrawerList);
	}

}