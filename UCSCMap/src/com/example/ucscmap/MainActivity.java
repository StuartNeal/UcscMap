package com.example.ucscmap;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

@SuppressLint("NewApi") public class MainActivity extends FragmentActivity {
	
	FragmentManager fragmentManager = getFragmentManager();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		
		Fragment fragment = new LoginFragment();

		if (savedInstanceState == null) {
			fragmentManager.beginTransaction()
					.add(R.id.container, fragment).commit();
		}
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
	
	public void onLoginButtonPressed(View v){
		//check the login information, then go to the map activity
		EditText usernameField = (EditText)findViewById(R.id.editText1);
		EditText passwordField = (EditText)findViewById(R.id.editText2);
		Editable userText = usernameField.getText();
		Editable passText = passwordField.getText();
		if (userText.length() == 0 || passText.length() == 0){
			DialogFragment df = new LoginErrorDialogFragment();
			df.show(getSupportFragmentManager(), "Login Error");
		} else {
			Intent intent = new Intent(this, MapActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
	//Switches to account creation fragment if text is pressed
	public void onCreateAccountPressed(View v){
		
		fragmentManager.beginTransaction().add(R.id.container , new CreateAccountFragment()).commit();
	}
	
	
	//Switches to forgot password fragment if text is pressed
	public void onForgotPasswordPressed(View v){
		
		fragmentManager.beginTransaction().add(R.id.container , new ForgotPasswordFragment()).commit();
	}
	
	//Login Screen Fragment
	public static class LoginFragment extends Fragment{

		public LoginFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}
	}
}
