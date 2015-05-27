package com.centrikal.visitasmovil.utility;

import org.acra.ACRA;

public class AcraUtility {

	public static void trackBreadcrumb(String key, String data) {
		ACRA.getErrorReporter().putCustomData(key, data);
	}

}
