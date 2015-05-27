package com.centrikal.visitasmovil.utility;

import com.centrikal.visitasmovil.database.SharePrefsDbManager;
import com.centrikal.visitasmovil.database.objects.DbSharePrefs;
import com.google.gson.Gson;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.util.Base64;
import android.util.Log;

/**
 * SharePrefs OverPowered
 * 
 * @author josepablocabreragarcia
 * @email jose.cabrera@centrikal.com
 */
public class SaveSharePrefsDb {

	private static final String TAG = "SAVESHAREPREFS_DATABASE";

	// SHAREPREFS
	public static final String PREF_SIN_VALOR_STRING = null;
	public static final Float PREF_SIN_VALOR_FLOAT = 9F;
	public static final int PREF_SIN_VALOR_INT = 99999999;

	public static void clear(Activity activity) {
		SharePrefsDbManager manager = new SharePrefsDbManager(activity);
		manager.delete(null);
	}

	public static void remove(Activity activity, String tag) {
		SharePrefsDbManager manager = new SharePrefsDbManager(activity);
		manager.delete(tag);
	}

	public static void remove(Service service, String tag) {
		SharePrefsDbManager manager = new SharePrefsDbManager(service);
		manager.delete(tag);
	}

	public static void remove(Context context, String tag) {
		boolean bandera = false;
		try {
			context = (Service) context;
			bandera = true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				context = (Activity) context;
				bandera = true;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (bandera) {
			SharePrefsDbManager manager = new SharePrefsDbManager(context);
			manager.delete(tag);
		}
	}

	public static void save(Context context, String tag, String valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);

		boolean bandera = false;
		try {
			context = (Service) context;
			bandera = true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				context = (Activity) context;
				bandera = true;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (bandera) {
			SharePrefsDbManager manager = new SharePrefsDbManager(context);
			manager.updateString(tag, valor);
		}
	}

	public static void save(Service service, String tag, String valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);
		SharePrefsDbManager manager = new SharePrefsDbManager(service);
		manager.updateString(tag, valor);
	}

	public static void save(Activity activity, String tag, String valor) {
		Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);
		SharePrefsDbManager manager = new SharePrefsDbManager(activity);
		manager.updateString(tag, valor);
	}

	public static void save(Context context, String tag, Object valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);
		boolean bandera = false;

		try {
			context = (Service) context;
			bandera = true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				context = (Activity) context;
				bandera = true;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		String valorConverted = "";
		if (valor != null) {
			valorConverted = new Gson().toJson(valor);
		} else {
			valorConverted = null;
		}

		if (bandera) {
			SharePrefsDbManager manager = new SharePrefsDbManager(context);
			manager.updateObject(tag, valorConverted);
		}
	}

	public static void save(Service service, String tag, Object valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);

		String valorConverted = "";
		if (valor != null) {
			valorConverted = new Gson().toJson(valor);
		} else {
			valorConverted = null;
		}

		SharePrefsDbManager manager = new SharePrefsDbManager(service);
		manager.updateObject(tag, valorConverted);
	}

	public static void save(Activity activity, String tag, Object valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);

		String valorConverted = "";
		if (valor != null) {
			valorConverted = new Gson().toJson(valor);
		} else {
			valorConverted = null;
		}

		SharePrefsDbManager manager = new SharePrefsDbManager(activity);
		manager.updateObject(tag, valorConverted);
	}

	public static void save(Context context, String tag, int valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);
		boolean bandera = false;
		try {
			context = (Service) context;
			bandera = true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				context = (Activity) context;
				bandera = true;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (bandera) {
			SharePrefsDbManager manager = new SharePrefsDbManager(context);
			manager.updateInt(tag, valor);
		}
	}

	public static void save(Service service, String tag, int valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);
		SharePrefsDbManager manager = new SharePrefsDbManager(service);
		manager.updateInt(tag, valor);
	}

	public static void save(Activity activity, String tag, int valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);
		SharePrefsDbManager manager = new SharePrefsDbManager(activity);
		manager.updateInt(tag, valor);
	}

	public static void save(Service service, String tag, Float valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);
		SharePrefsDbManager manager = new SharePrefsDbManager(service);
		manager.updateFloat(tag, valor);
	}

	public static void save(Activity activity, String tag, Float valor) {
		// Log.d(TAG, "valor TO SAVE " + valor + "/tag " + tag);
		SharePrefsDbManager manager = new SharePrefsDbManager(activity);
		manager.updateFloat(tag, valor);
	}

	public static String getString(Service service, String tag) {
		SharePrefsDbManager manager = new SharePrefsDbManager(service);

		DbSharePrefs object = manager.retrieve(tag);

		String valor;
		if (object != null) {
			valor = object.getValor_string();
		} else {
			valor = SaveSharePrefsDb.PREF_SIN_VALOR_STRING;
		}

		// Log.i(TAG, "valor TO RETRIEVE " + valor + "/tag " + tag);
		return valor;
	}

	public static String getString(Activity activity, String tag) {
		SharePrefsDbManager manager = new SharePrefsDbManager(activity);

		DbSharePrefs object = manager.retrieve(tag);

		String valor;
		if (object != null) {
			valor = object.getValor_string();
		} else {
			valor = SaveSharePrefsDb.PREF_SIN_VALOR_STRING;
		}

		// Log.i(TAG, "valor TO RETRIEVE " + valor + "/tag " + tag);
		return valor;
	}

	public static int getInt(Service service, String tag) {
		SharePrefsDbManager manager = new SharePrefsDbManager(service);

		DbSharePrefs object = manager.retrieve(tag);

		int valor;
		if (object != null) {
			valor = object.getValor_int();
		} else {
			valor = SaveSharePrefsDb.PREF_SIN_VALOR_INT;
		}

		// Log.i(TAG, "valor TO RETRIEVE " + valor + "/tag " + tag);
		return valor;
	}

	public static int getInt(Activity activity, String tag) {
		SharePrefsDbManager manager = new SharePrefsDbManager(activity);

		DbSharePrefs object = manager.retrieve(tag);

		int valor;
		if (object != null) {
			valor = object.getValor_int();
		} else {
			valor = SaveSharePrefsDb.PREF_SIN_VALOR_INT;
		}

		// Log.i(TAG, "valor TO RETRIEVE " + valor + "/tag " + tag);
		return valor;
	}

	public static float getFloat(Service service, String tag) {
		SharePrefsDbManager manager = new SharePrefsDbManager(service);

		DbSharePrefs object = manager.retrieve(tag);

		float valor;
		if (object != null) {
			valor = object.getValor_float();
		} else {
			valor = SaveSharePrefsDb.PREF_SIN_VALOR_FLOAT;
		}

		// Log.i(TAG, "valor TO RETRIEVE " + valor + "/tag " + tag);
		return valor;
	}

	public static float getFloat(Activity activity, String tag) {
		SharePrefsDbManager manager = new SharePrefsDbManager(activity);

		DbSharePrefs object = manager.retrieve(tag);

		float valor;
		if (object != null) {
			valor = object.getValor_float();
		} else {
			valor = SaveSharePrefsDb.PREF_SIN_VALOR_FLOAT;
		}

		// Log.i(TAG, "valor TO RETRIEVE " + valor + "/tag " + tag);
		return valor;
	}

	public static Object getObject(Service service, String tag, Class<?> c) {
		SharePrefsDbManager manager = new SharePrefsDbManager(service);

		DbSharePrefs object = manager.retrieve(tag);

		Object valor = null;
		if (object != null) {
			if (object.getValor_object() != null) {
				byte[] bBase64aStringJSON = Base64.decode(object.getValor_object(), Base64.DEFAULT);
				String json = new String(bBase64aStringJSON);
				Log.i(TAG, "valor TO RETRIEVE " + json + "/tag " + tag);
				valor = new Gson().fromJson(json, c);
			} else {
				valor = SaveSharePrefsDb.PREF_SIN_VALOR_STRING;
			}
		} else {
			valor = SaveSharePrefsDb.PREF_SIN_VALOR_STRING;
		}

		return valor;
	}

	public static Object getObject(Activity activity, String tag, Class<?> c) {
		SharePrefsDbManager manager = new SharePrefsDbManager(activity);

		DbSharePrefs object = manager.retrieve(tag);

		Object valor = null;

		if (object != null) {

			if (object.getValor_object() != null) {
				byte[] bBase64aStringJSON = Base64.decode(object.getValor_object(), Base64.DEFAULT);
				String json = new String(bBase64aStringJSON);
				Log.i(TAG, "valor TO RETRIEVE " + json + "/tag " + tag);
				valor = new Gson().fromJson(json, c);
			} else {
				valor = SaveSharePrefsDb.PREF_SIN_VALOR_STRING;
			}

		} else {
			valor = SaveSharePrefsDb.PREF_SIN_VALOR_STRING;
		}

		return valor;
	}

}
