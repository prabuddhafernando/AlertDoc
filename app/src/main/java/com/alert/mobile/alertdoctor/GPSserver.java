/*
package com.alert.mobile.alertdoctor;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Timer;
import java.util.TimerTask;

public class GPSserver extends Service {



    private Location mLastLocation;
    public LocationManager mLocationManager;

    public GPSserver() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        // initiate location service
        int LOCATION_REFRESH_TIME = 1000;
        int LOCATION_REFRESH_DISTANCE = 5;

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME,
                LOCATION_REFRESH_DISTANCE, mLocationListener);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            //code
            Log.e("alert","GPS onLocationChanged");
            mLastLocation = location;
            AppConfigData.user_location = mLastLocation;
            AppConfigData.isGPSAvailable = true;

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.e("alert","GPS onStatusChanged");
        }

        @Override
        public void onProviderEnabled(String provider) {
            AppConfigData.isGPSAvailable = true;
            Log.e("alert", "GPS onProviderEnabled");
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.e("alert", "GPS onProviderDisabled"+provider);
            //turns off gps services
            AppConfigData.isGPSAvailable = false;
        }
    };


    @Override
    public void onDestroy() {
        super.onDestroy();



    }



}
*/
