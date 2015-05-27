package com.centrikal.visitasmovil.utility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

public class ImageDecodeEncode {

	/**
	 * Convierte una imagen en bitmap a base 64
	 * 
	 * @param bitmap
	 *            imagen que deseas convertir
	 * @return String base 64 de la imagen convertida en PNG
	 */
	public static String convertToBase64(Bitmap bitmap) {
		ByteArrayOutputStream jpeg_data = new ByteArrayOutputStream();
		String js_out = "";

		Bitmap bitmapResized = Bitmap.createScaledBitmap(bitmap, 2048, 1536,
				false);

		if (bitmapResized.compress(Bitmap.CompressFormat.PNG, 100, jpeg_data)) {
			byte[] code = jpeg_data.toByteArray();
			byte[] output = Base64.encode(code, Base64.NO_WRAP);
			js_out = new String(output);
			output = null;
			code = null;
		}

		return js_out;
	}

	/**
	 * Convierte una base 64 en un bitmap para poder setearlo en un image view
	 * 
	 * @param b64
	 *            String, base 64 que quieres convertir en bitmap
	 * @return Bitmap, la imagen convertida en bitmap
	 */
	public static Bitmap convertToBitmap(String b64) {

		byte[] decodedString = Base64.decode(b64, Base64.DEFAULT);
		Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,
				decodedString.length);

		return decodedByte;
	}

	public static File convertBitmapToFile(String filename, Bitmap pBitmap) {
		try {
			// create a file to write bitmap data
			File f = new File(Constants.CONSTANTS.PICTURE_PATH, filename);
			f.createNewFile();

			// Convert bitmap to byte array
			Bitmap bitmap = pBitmap;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			bitmap.compress(CompressFormat.PNG, 0 /* ignored for PNG */, bos);
			byte[] bitmapdata = bos.toByteArray();

			// write the bytes in file
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bitmapdata);
			fos.flush();
			fos.close();
			return f;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String convertToBase64(String filename, String path) {
		String strFoto = "";
		try {
			File file = new File(path + filename);
			InputStream inputStream = new FileInputStream(file);
			byte[] bytes;
			byte[] buffer = new byte[8192];
			int bytesRead;
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					output.write(buffer, 0, bytesRead);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			bytes = output.toByteArray();
			String encodedString = Base64.encodeToString(bytes, Base64.DEFAULT);
			strFoto = encodedString;
			// Log.d(TAG, encodedString);
			Log.d("ImageDecodeEncode",
					"TAMAÑO BASE 64 " + encodedString.length());
		} catch (Exception e) {
			Log.e("ImageDecodeEncode",
					"Error al convertir la foto " + e.toString());
		}
		return strFoto;
	}

	public static void changeImageFileResolution(String path, String fileName,
			int pHeight, int pWidth) {
		try {
			Bitmap b = BitmapFactory.decodeFile(path);

			Bitmap out = Bitmap.createScaledBitmap(b, pHeight, pWidth, false);
			File file = new File(Constants.SHAREDPREFS.PICTURE_PATH, fileName);
			FileOutputStream fOut;
			try {
				fOut = new FileOutputStream(file);
				out.compress(Bitmap.CompressFormat.PNG, 100, fOut);
				fOut.flush();
				fOut.close();
				b.recycle();
				out.recycle();

			} catch (Exception e) { // TODO
				file.delete();
				Log.e("ImageDecodeEncode",
						"NO SE PUDO CAMBIAR RESOLUCION DE LA IMAGEN");
			}
		} catch (Exception e1) {
			Log.e("ImageDecodeEncode",
					"NO SE PUDO CAMBIAR RESOLUCION DE LA IMAGEN 2");
		}

	}
}
