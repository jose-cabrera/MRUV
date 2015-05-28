package umg.deltadax.mruv.utility;

import android.content.Context;
import android.telephony.TelephonyManager;

public class DeviceInfo {

	public static String getImei(Context context) {
		try {
			TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

			return tm.getDeviceId().toString();
		} catch (Exception e) {

			return "Running on tablet";
		}
	}

}
