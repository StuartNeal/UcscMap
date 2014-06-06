package com.example.ucscmap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

@SuppressLint("NewApi") public class ForgotPasswordFragment extends Fragment {
	
	private class ForgotPasswordDownloader extends Downloader{
		@Override
		protected void onPostExecute(String s){
		}
	}
	
	public interface OnForgotPasswordListener{
		public void onSubmitButtonPressed(View v);
	}
	
	OnForgotPasswordListener mainActivityListener;
	
	public ForgotPasswordFragment(){}
	
	@Override
	public void onAttach(Activity activity){
		
		super.onAttach(activity);
		try{
			mainActivityListener = (OnForgotPasswordListener)activity;
		} catch (ClassCastException e){
			throw new ClassCastException(activity.toString() + "must implement OnForgotPasswordListener");
		}
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_forgot_pass, container, false);
	 
	 	return rootView;
    }
	
	public void onSubmitButtonPressed(View v){
		EditText userField = (EditText)getView().findViewById(R.id.editText_ForgotUserTag);
		EditText emailField = (EditText)getView().findViewById(R.id.editText_ForgotEmailTag);
		if (userField != null && emailField != null){
			String userText = userField.getText().toString();
			String emailText = emailField.getText().toString();
			ForgotPasswordDownloader downloader = new ForgotPasswordDownloader();
			downloader.execute(getString(R.string.text_url_base)); //this needs to be completed
		}
	}
}
