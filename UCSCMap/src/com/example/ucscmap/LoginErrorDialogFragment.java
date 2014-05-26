package com.example.ucscmap;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * A class to create and display a dialog if the user tries to log in without entering a username and password.
 * @author Saul Winer
 */
@SuppressLint("NewApi")
public class LoginErrorDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.text_login_error);
		builder.setNeutralButton(R.string.text_okay, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//close the dialog box - i.e. do nothing.
			}
		});
		return builder.create();
	}
}
