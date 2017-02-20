package com.alert.mobile.alertdoctor;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 5/22/2016.
 */

public class HttpManager {

    public static String sendOnPost(JSONObject obj) {

        /*
        String responsefromserver = "";
        HttpClient httpClient = new DefaultHttpClient();
        // replace with your url
        HttpPost httpPost = new HttpPost("http://192.168.43.121:8080/name/dataCollector");

        //Encoding POST data

            try {
                //Post Data
                List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
                nameValuePair.add(new BasicNameValuePair("name", obj.getString("name")));
                nameValuePair.add(new BasicNameValuePair("report", obj.getString("report")));
                nameValuePair.add(new BasicNameValuePair("lat", obj.getString("lat")));
                nameValuePair.add(new BasicNameValuePair("lon", obj.getString("lon")));

                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));

            } catch (UnsupportedEncodingException e) {
                // log exception
                e.printStackTrace();
                responsefromserver = "";
            } catch (Exception es) {
                Log.e("alert", "error josn" + es);
            }

            //making POST request.
            try {
                HttpResponse response = httpClient.execute(httpPost);
                responsefromserver = response.toString();


                // write response to logresponse.toString()
                Log.d("Http Post Response:", response.toString());
            } catch (ClientProtocolException e) {
                responsefromserver = "";
                // Log exception
                e.printStackTrace();
            } catch (IOException e) {
                responsefromserver = "";
                // Log exception
                e.printStackTrace();
            }
            return responsefromserver;*/
        return null;
    }

    public static String getData(String uri) {

        // method 1
		/*
		 * AndroidHttpClient client =
		 * AndroidHttpClient.newInstance("AndroidAgent"); HttpGet request = new
		 * HttpGet(url); HttpResponse response;
		 *
		 * try { response = client.execute(request); return
		 * EntityUtils.toString(response.getEntity()); } catch (IOException e) {
		 * e.printStackTrace(); return null; }finally{ client.close(); }
		 */
        // method 2 best  request data using HttpConnection
        BufferedReader reader = null;

        try {
            URL url = new URL(uri);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

    }

    // public static String getData(String uri, String userName, String
    // password) {
    //
    // // method 2 best
    // BufferedReader reader = null;
    // HttpURLConnection con = null ;
    // byte[] loginBytes = (userName + ":" + password).getBytes();
    // StringBuilder loginBuilder = new StringBuilder().append("Basic ")
    // .append(Base64.encodeToString(loginBytes, Base64.DEFAULT));
    //
    // try {
    // URL url = new URL(uri);
    // con = (HttpURLConnection) url.openConnection();
    // //modified..
    // con.addRequestProperty("Authorization", loginBuilder.toString());
    //
    // StringBuilder sb = new StringBuilder();
    // reader = new BufferedReader(new InputStreamReader(
    // con.getInputStream()));
    //
    // String line;
    // while ((line = reader.readLine()) != null) {
    // sb.append(line + "\n");
    // }
    //
    // return sb.toString();
    // } catch (Exception e) {
    // e.printStackTrace();
    //
    // try {
    // int status = con.getResponseCode();
    // } catch (IOException e1) {
    // // TODO Auto-generated catch block
    // e1.printStackTrace();
    // }
    //
    // return null;
    // } finally {
    // if (reader != null) {
    // try {
    // reader.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // return null;
    // }
    // }
    // }
    //
    // }

}