package com.centrikal.visitasmovil.utility;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DeviceInfo {

	public static String getImei(Context context) {
		try {
			TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

			return tm.getDeviceId().toString();
		} catch (Exception e) {
			Rpe.e("Device INFO", "Running on tablet" + e.toString(), context);

			return "Running on tablet";
		}
	}

}
