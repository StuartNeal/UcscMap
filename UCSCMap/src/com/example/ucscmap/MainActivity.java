package com.example.ucscmap;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

@SuppressLint("NewApi") public class MainActivity extends FragmentActivity {
	
	private static final String MY_SECRET = "becausesecret";
	FragmentManager fragmentManager = getFragmentManager();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		
		Fragment fragment = new LoginFragment();

		if (savedInstanceState == null) {
			fragmentManager.beginTransaction()
					.add(R.id.container, fragment)
					.commit();
		}
	}
	
	//Checks the login information, then go to the map activity
	public void onLoginButtonPressed(View v){
		EditText usernameField = (EditText)findViewById(R.id.editTextMain1);
		EditText passwordField = (EditText)findViewById(R.id.editTextMain2);
		Log.d("MainActivity", "Got the editTexts...");
		Editable userText = usernameField.getText();
		Editable passText = passwordField.getText();
		Log.d("MainActivity", "Got the text from the fields");
		if (userText.length() == 0 || passText.length() == 0){
			showLoginErrorFragment();
		} else {
			//Log.d("MainActivity", "Heading into a download, url base " + getString(R.string.text_url_base));
			//AppInfo.getInstance().downloadFrom(getString(R.string.text_url_base) + "login/?secret=" + MY_SECRET + "&username=" + userText + "&password=" + passText, this);
			executeLogin();
		}
	}
	
	//If login is successful, switches to the Map Activity
	public void executeLogin(){
		Intent intent = new Intent(this, MapActivity.class);
		startActivity(intent);
		finish();
	}
	
	//Displays Login Error Dialog
	public void showLoginErrorFragment(){
		DialogFragment df = new LoginErrorDialogFragment();
		df.show(getSupportFragmentManager(), "Login Error");
	}
	
	//Switches to account creation fragment if text is pressed
	public void onCreateAccountPressed(View v){
		
		fragmentManager.beginTransaction().replace(R.id.container , new CreateAccountFragment())
										.addToBackStack(null)
										.commit();
	}
	
	
	//Switches to forgot password fragment if text is pressed
	public void onForgotPasswordPressed(View v){
		
		fragmentManager.beginTransaction().replace(R.id.container , new ForgotPasswordFragment())
										.addToBackStack(null)
										.commit();
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
	
	//When the back button is pressed, it returns to the previous fragment if there is one.
	@Override
	public void onBackPressed() {
	    if (getFragmentManager().getBackStackEntryCount() == 0) {
	        this.finish();
	    } else {
	        getFragmentManager().popBackStack();
	    }
	}

}
