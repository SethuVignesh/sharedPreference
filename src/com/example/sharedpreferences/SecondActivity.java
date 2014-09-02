package com.example.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends ActionBarActivity {
	EditText etUserName, etPassword;

	public static final String DEFAULT = "N/A";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		etUserName = (EditText) findViewById(R.id.eTUserName2);
		etPassword = (EditText) findViewById(R.id.eTPwd2);

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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_second,
					container, false);
			return rootView;
		}
	}

	public void onLoad(View v) {
		SharedPreferences sharedPreferences = getSharedPreferences("MyData",
				Context.MODE_PRIVATE);
		String name = sharedPreferences.getString("username", DEFAULT);
		String pwd = sharedPreferences.getString("password", DEFAULT);
		if (name.equals(DEFAULT) || name.equals(DEFAULT)) {
			Toast.makeText(getApplicationContext(), "No Data was Found", 0)
					.show();
		} else {
			Toast.makeText(getApplicationContext(),
					"Datas Loaded successfully", 0).show();
			etUserName.setText(name);
			etPassword.setText(pwd);
		}
	}

	public void onPrevious(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
