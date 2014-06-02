package com.example.ucscmap;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

@SuppressLint("NewApi") public class MainActivity extends FragmentActivity {
	
	private static final String MY_SECRET = "becausesecret";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new LoginFragment()).commit();
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
		EditText usernameField = (EditText)findViewById(R.id.editTextMain1);
		EditText passwordField = (EditText)findViewById(R.id.editTextMain2);
		Log.d("MainActivity", "Got the editTexts...");
		Editable userText = usernameField.getText();
		Editable passText = passwordField.getText();
		Log.d("MainActivity", "Got the text from the fields");
		if (userText.length() == 0 || passText.length() == 0){
			showLoginErrorFragment();
		} else {
			Log.d("MainActivity", "Heading into a download, url base " + getString(R.string.text_url_base));
			AppInfo.getInstance().downloadFrom(getString(R.string.text_url_base) + "login/?secret=" + MY_SECRET + "&username=" + userText + "&password=" + passText, this);
		}
	}
	
	public void executeLogin(){
		Intent intent = new Intent(this, MapActivity.class);
		startActivity(intent);
		finish();
	}
	
	public void showLoginErrorFragment(){
		DialogFragment df = new LoginErrorDialogFragment();
		df.show(getSupportFragmentManager(), "Login Error");
	}
	
	//Switches to account creation fragment if text is pressed
	public void onCreateAccountPressed(View v){
		
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().add(R.id.container , new CreateAccountFragment()).commit();
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
