package com.example.ucscmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class Downloader extends AsyncTask<String, String, String>{
	public int MAX_DOWNLOAD_TRIES = 5;
	
	protected String doInBackground(String... urls){
		//start the download
		String downloadedString = null;
		String urlString = urls[0];
		URI url = URI.create(urlString);
		Log.d("Downloader", "URL: " + url.toString());
		int numTries = 0;
		Log.d("Downloader", "Doing in background");
		while (downloadedString == null && !isCancelled() && numTries <= MAX_DOWNLOAD_TRIES){
			numTries++;
			HttpGet request = new HttpGet(url);
			DefaultHttpClient defaultClient = new DefaultHttpClient();
			HttpResponse response = null;
			try{
				response = defaultClient.execute(request);
			} catch(ClientProtocolException e){
				Log.d("Downloader", e.toString());
			} catch (IOException e){
				Log.d("Downloader", e.toString());				
			} catch (Exception e){
				Log.d("Downloader", e.toString());				
			}
			if (response != null){
				//check status codes for failure
				int statusCode = response.getStatusLine().getStatusCode();
				Log.d("Downloader", "Status code " + statusCode);
				if (statusCode == HttpURLConnection.HTTP_OK){
					HttpEntity entity = response.getEntity();
					InputStream istream = null;
					try {
						istream = entity.getContent();
					} catch (IOException e){
						Log.d("Downloader", e.toString());
					}
					if (istream != null){
						downloadedString = ConvertStreamToString(istream);
						return downloadedString;
					}
				}
			}
		}
		return downloadedString;
	}
	
	protected void onPostExecute(String s){
	}
	
	private String ConvertStreamToString(InputStream is){
		if (is == null){
			return null;
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		
		String line = null;
		try{
			while ((line = reader.readLine()) != null){
				sb.append((line + "\n"));
			}
		} catch (IOException e){
			Log.d("Downloader", e.toString());
		} finally {
			try{
				is.close();
			} catch (IOException e){
				Log.d("Downloader", e.toString());
			}
		}
		return sb.toString();
	}
}
