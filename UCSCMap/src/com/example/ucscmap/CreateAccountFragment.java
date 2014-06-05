package com.example.ucscmap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

@SuppressLint("NewApi") public class CreateAccountFragment extends Fragment{
	
	private static final String MY_SECRET = "becausesecret";

	private class CreateAccountDownloader extends Downloader{
		@Override
		protected void onPostExecute(String s){
			if (s == null){
				Log.d("CreateAccount", "Null String");
				return;
			}
			if (s.equals("loginCreateTrue")){
				Log.d("CreateAccount", "Login creation success");
			} else if (s.equals("loginCreateFalse")){
				Log.d("CreateAccount", "Login creation failure");
			}
		}
	}
	
	public interface OnCreateAccountListener{
		public void onCreateButtonPressed(View v);
	} 
	
	OnCreateAccountListener mainActivityListener;
	
	public CreateAccountFragment(){}
		
	@Override
	public void onAttach(Activity activity){
		
		super.onAttach(activity);
		try{
			mainActivityListener = (OnCreateAccountListener)activity;
		} catch (ClassCastException e){
			throw new ClassCastException(activity.toString() + "must implement OnCreateAccountListener");
		}
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_create_account, container, false);
	 
	 	return rootView;
    }
	
	public void onCreateButtonPressed(View v){
		//get the new account information
		Log.d("CreateAccount", "Getting the account login information");
		EditText userField = (EditText)getView().findViewById(R.id.editTextAccountCreate1);
		EditText passField = (EditText)getView().findViewById(R.id.editTextAccountCreate2);
		EditText passConfirmField = (EditText)getView().findViewById(R.id.editTextAccountCreate3);
		if (userField != null && passField != null && passConfirmField != null){
			Editable userText = userField.getText();
			Editable passText = passField.getText();
			Editable passConfirmText = passConfirmField.getText();
			if (userText.length() > 0 && passText.length() > 0 && passConfirmText.length() > 0 && passText.toString().equals(passConfirmText.toString())){
				Log.d("CreateAccount", "Sending to server");
				CreateAccountDownloader downloader = new CreateAccountDownloader();
				Log.d("CreateAccount", getString(R.string.text_url_base) + "createLogin/?secret=" + MY_SECRET + "&username=" + userText + "&password=" + passText);
				downloader.execute(getString(R.string.text_url_base) + "createLogin/?secret=" + MY_SECRET + "&username=" + userText + "&password=" + passText);
//				downloader.execute("http://10.0.1.3:8000/ucscMapServer/default/createLogin/?secret=" + MY_SECRET + "&username=" + userText + "&password=" + passText);
			} else {
				Log.d("CreateAccount", "Empty or non-matching stuff:\nusername " + userText + "password " + passText + "confirmed " + passConfirmText);
			}
		} else {
			Log.d("CreateAccount", "Null fields");
		}
	}
}
