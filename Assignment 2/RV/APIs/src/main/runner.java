package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

//N


//External Imports
import com.google.gson.*;//JAVA TO JSON (not used due to faulty libaray)
import okhttp3.MediaType;//Not used due to not needing to send POST & DELETES while monitoring
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.*;

//import json libraries
import org.json.*;


public class runner{
	
	//for forloop
	int i = 0;
	
	//hold the number of alerts we have
	int numAlerts = 0;
	//JSONArray to hold alerts
	JSONArray alerts = new JSONArray();
	
	//response and line for URLConnection
	StringBuilder response = new StringBuilder();
    String line;
    
    //counters
    int alertcounter = 0;
    int deletecounter = 0;
	
	//if there are the correct number of alerts
	public void postWorks() {
		System.out.println("Correct number of alerts at time: " + System.currentTimeMillis());
	}
	
	//if there aren't the correct number of alerts
	public void postDoesntWork() {
		System.out.println("BAD STATE! Incorrect number of alerts at time:" + System.currentTimeMillis());
	}

	
	public void sendGet() throws IOException{
		String url = "https://api.marketalertum.com/EventsLog/3e0dc9fb-291e-438e-9fbb-00cc6865af94";
				 try {
					 //open connection
					HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
					//set correct attributes for get of type JSON
					httpClient.setRequestMethod("GET");
					httpClient.setRequestProperty("Content-Type", "application/json");
					try (BufferedReader in = new BufferedReader(
			                new InputStreamReader(httpClient.getInputStream()))) {

			            while ((line = in.readLine()) != null) {
			                response.append(line);
			            }

			            //output get response
			            System.out.println(response.toString());

			        }
					//catch errors if there are
				} catch (MalformedURLException e) {
					String error = e.getMessage();
					System.out.println(error);
					e.printStackTrace();
				} catch (IOException e) {
					String error = e.getMessage();
					System.out.println(error);
					e.printStackTrace();
				}
				 
				 //convert to JSON
				 String jsonformat = response.toString();
				 JSONArray JSONArray = new JSONArray(jsonformat);
				 
				 for(i = 0; i < JSONArray.length(); i++){
					 JSONObject current = JSONArray.getJSONObject(i);
					 numAlerts = current.getInt("eventLogType");
					 
					 alerts = current.getJSONObject("systemState").getJSONArray("alerts");
					 if(numAlerts == 0){
						 //count delete
						 alertcounter++;
					 }
					 if(numAlerts == 1){
						 //count delete
						 deletecounter++;
					 }
				 }
				 
				 //identify correct & incorrect alert numbers and deletes
				 if(alertcounter == 5){
					 System.out.println("Correct Alerts!");
				 }
				 else if (alertcounter != 5){
					 System.out.println("Incorrect Alerts!");
				 }
				 if(deletecounter == 1){
					 System.out.println("Correct Deletes!");
				 }
				 else if (deletecounter != 1){
					 System.out.println("Incorrect Deletes!");
				 }
				 if(alertcounter == 5 && deletecounter == 1){
					 //identify that post and delete have worked
					 postWorks();
				 }
				 else{
					 //identify that they havent worked
					 postDoesntWork();
				 }
				 
	}

	
	public static void main (String []args) throws IOException
	{
		runner run = new runner();
		run.sendGet();
	}
	
}


