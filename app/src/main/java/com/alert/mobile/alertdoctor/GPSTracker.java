//package com.alert.mobile.alertdoctor;
//
//import android.Manifest;
//import android.bluetooth.BluetoothClass;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//
//import java.security.Provider;
//
//import android.app.Service;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.provider.Settings;
//import android.support.annotation.Nullable;
//import android.support.v4.app.ActivityCompat;
//import android.support.v7.app.AlertDialog;
//import android.util.Log;
//import android.widget.Toast;
//
///**
// * Created by User on 5/21/2016.
// */
//
//
//public class GPSTracker extends Service implements LocationListener {
//
//    private final Context mContext;
//    // flag for GPS status
//    boolean isGPSEnabled = false;
//    // flag for network status
//    boolean isNetworkEnabled = false;
//    // flag for GPS status
//    boolean canGetLocation = false;
//    Location location; // location
//    float speed; //speed
//    double latitude; // latitude
//    double longitude; // longitude
//    // The minimum distance to change Updates in meters
//    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1; // 10 meters
//    // The minimum time between updates in milliseconds
//    private static final long MIN_TIME_BW_UPDATES = 60 * 1; // 1 minute
//    // Declaring a Location Manager
//    protected LocationManager locationManager;
//
//
//    public GPSTracker(Context context) {
//        this.mContext = context;
//        getLocation();
//    }
//
//    public Location getLocation() {
//        try {
//            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
//            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
//
//            if (!isGPSEnabled && !isNetworkEnabled) {
//
//            } else {
//                this.canGetLocation = true;
//                if (isNetworkEnabled) {
//
//                    locationManager.requestLocationUpdates(
//                            LocationManager.NETWORK_PROVIDER,
//                            MIN_TIME_BW_UPDATES,
//                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
//                    if (locationManager != null) {
//                        location = locationManager
//                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                        if (location != null) {
//                            latitude = location.getLatitude();
//                            longitude = location.getLongitude();
//                            speed= location.getSpeed();
//                            Log.d("netwk provider", "netwk provide");
//                        }
//                    }
//                }
//                // if GPS Enabled get last/long using GPS Services
//                if (isGPSEnabled) {
//                    if (location == null) {
//                        locationManager.requestLocationUpdates(
//                                LocationManager.GPS_PROVIDER,
//                                MIN_TIME_BW_UPDATES,
//                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
//                        Log.d("GPS Enabled", "GPS Enabled");
//                        if (locationManager != null) {
//                            location = locationManager
//                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
//                            if (location != null) {
//                                latitude = location.getLatitude();
//                                longitude = location.getLongitude();
//                                speed = location.getSpeed();
//                                Log.d("GPS Pro", "GPS Pro");
//                            }
//                        }
//                    }
//                }
//
//            }
//
//
//
//        }catch (Exception e){
//            Log.e("alert","error gpstracker "+e);
//        }
//        return location;
//    }
//
//
//
//
//    @Override
//    public void onLocationChanged(Location location) {
//
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//}
