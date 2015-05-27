package com.centrikal.visitasmovil.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

public class DescargarBinarios {

	private static final String TAG = "DescargarBinarios";
	private static String root = Constants.CONSTANTS.ROOT_PATH;

	public static boolean descarga(String url, String nombre) {
		try {
			Log.d(TAG, "INICIANDO");
			URL u = new URL(url);
			HttpURLConnection c = (HttpURLConnection) u.openConnection();
			c.setRequestMethod("GET");
			c.setDoOutput(true);
			c.connect();

			Log.d(TAG, "CREANDO ARCHIVO");
			FileOutputStream f = new FileOutputStream(new File(root, nombre));

			InputStream in = c.getInputStream();

			byte[] buffer = new byte[1024];
			int len1 = 0;
			while ((len1 = in.read(buffer)) > 0) {
				f.write(buffer, 0, len1);
			}
			Log.d(TAG, "CERRANDO ARCHIVO");
			f.close();
			return true;
		} catch (Exception e) {
			Log.e(TAG, "Error descargando binarios " + e);
			return false;
		}
	}
	
	public static File getFile(String url, String nombre) {
		try {
			Log.d(TAG, "INICIANDO");
			URL u = new URL(url);
			HttpURLConnection c = (HttpURLConnection) u.openConnection();
			c.setRequestMethod("GET");
			c.setDoOutput(true);
			c.connect();

			Log.d(TAG, "CREANDO ARCHIVO");
			File file = new File(root, nombre);
			FileOutputStream f = new FileOutputStream(file);

			InputStream in = c.getInputStream();

			byte[] buffer = new byte[1024];
			int len1 = 0;
			while ((len1 = in.read(buffer)) > 0) {
				f.write(buffer, 0, len1);
			}
			Log.d(TAG, "CERRANDO ARCHIVO");
			f.close();
			return file;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}