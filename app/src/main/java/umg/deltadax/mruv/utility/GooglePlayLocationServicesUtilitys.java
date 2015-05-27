package com.centrikal.visitasmovil.utility;

import android.app.Activity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;

public class GooglePlayLocationServicesUtilitys {

	private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;

	/**
	 * Method to verify google play services on the device
	 * */
	public static boolean checkPlayServices(Activity activity) {
		int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
		if (resultCode != ConnectionResult.SUCCESS) {
			if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
				GooglePlayServicesUtil.getErrorDialog(resultCode, activity, PLAY_SERVICES_RESOLUTION_REQUEST).show();
			} else {
				Log.e("GooglePlayLocationServicesUtilitys", "DISPOSITIVO NO ACEPTADO");
			}
			return false;
		}
		return true;
	}

	/**
	 * Creating google api client object
	 * */
	public static synchronized GoogleApiClient buildGoogleApiClient(Activity activity, ConnectionCallbacks listener,
			OnConnectionFailedListener failListener) {
		return new GoogleApiClient.Builder(activity).addConnectionCallbacks(listener)
				.addOnConnectionFailedListener(failListener).addApi(LocationServices.API).build();
	}

}
