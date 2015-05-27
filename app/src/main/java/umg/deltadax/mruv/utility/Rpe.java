package com.centrikal.visitasmovil.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import com.centrikal.visitasmovil.R;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

/**
 * Reporte por excepciones o logs necesarios para verificar el funcionamiento de
 * la aplicación.
 * 
 * @author josepablocabreragarcia
 */
public class Rpe {

	private static final String TAG_I = "RPE";

	private static String rootPath = Environment.getExternalStorageDirectory()
			.getPath();
	private static final String caperpetaCTK = "Log_CTK_";

	/**
	 * Crea un reporte de exepciones en el sistema de archivos para los errores
	 * 
	 * @param sFileName
	 *            nombre del log
	 * @param sBody
	 *            cuerpo del log
	 * @param tipo
	 *            tipo de log
	 * @param context
	 *            contexto en donde se ejecutara
	 */
	public static void e(String TAG, String sBody, Context context) {

		try {

			File errors;

			File root = new File(rootPath, caperpetaCTK
					+ context.getString(R.string.log_app_name));
			if (!root.exists()) {
				root.mkdirs();
			}

			switch (Constants.SHAREDPREFS.LOG_ACTIVO) {
			case Constants.CONSTANTS.LOG_ONLY_ERRORS:
				errors = new File(root.getPath(), "ERRORS"
						+ context.getString(R.string.log_app_name));
				if (!errors.exists()) {
					errors.mkdirs();
				}

				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					createFile(errors, TAG, sBody);
				}
				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_CAT
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					Log.e(TAG, sBody);
				}
				break;

			case Constants.CONSTANTS.LOG_ALL:
				errors = new File(root.getPath(), "ERRORS"
						+ context.getString(R.string.log_app_name));
				if (!errors.exists()) {
					errors.mkdirs();
				}

				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					createFile(errors, TAG, sBody);
				}
				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_CAT
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					Log.e(TAG, sBody);
				}

				break;
			}

		} catch (Exception e) {
			Log.e(TAG_I, "Error al crear el archivo " + e.toString());
			e.printStackTrace();
		}
	}

	/**
	 * Crea un archivo reportando los movimientos de la base de datos
	 * 
	 * @param sFileName
	 * @param sBody
	 * @param context
	 */
	public static void d(String TAG, String sBody, Context context) {

		try {

			File db;

			File root = new File(rootPath, caperpetaCTK
					+ context.getString(R.string.log_app_name));
			if (!root.exists()) {
				root.mkdirs();
			}

			switch (Constants.SHAREDPREFS.LOG_ACTIVO) {

			case Constants.CONSTANTS.LOG_ONLY_DB:
				db = new File(root.getPath(), "DB"
						+ context.getString(R.string.log_app_name));
				if (!db.exists()) {
					db.mkdirs();
				}

				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					createFile(db, TAG, sBody);
				}
				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_CAT
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					Log.i(TAG, sBody);
				}
				break;

			case Constants.CONSTANTS.LOG_ALL:
				db = new File(root.getPath(), "DB"
						+ context.getString(R.string.log_app_name));
				if (!db.exists()) {
					db.mkdirs();
				}

				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					createFile(db, TAG, sBody);
				}
				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_CAT
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					Log.i(TAG, sBody);
				}
				break;

			}

		} catch (Exception e) {
			Log.e(TAG_I, "Error al crear el archivo " + e.toString());
			e.printStackTrace();
		}
	}

	/**
	 * Crea un archivo con el reporte de los web services
	 * 
	 * @param sFileName
	 * @param sBody
	 * @param context
	 */
	public static void w(String TAG, String sBody, Context context) {

		try {

			File ws;

			File root = new File(rootPath, caperpetaCTK
					+ context.getString(R.string.log_app_name));
			if (!root.exists()) {
				root.mkdirs();
			}

			switch (Constants.SHAREDPREFS.LOG_ACTIVO) {

			case Constants.CONSTANTS.LOG_ONLY_WS:
				ws = new File(root.getPath(), "WS"
						+ context.getString(R.string.log_app_name));
				if (!ws.exists()) {
					ws.mkdirs();
				}

				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					createFile(ws, TAG, sBody);
				}
				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_CAT
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					Log.w(TAG, sBody);
				}
				break;

			case Constants.CONSTANTS.LOG_ALL:
				ws = new File(root.getPath(), "WS"
						+ context.getString(R.string.log_app_name));
				if (!ws.exists()) {
					ws.mkdirs();
				}

				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					createFile(ws, TAG, sBody);
				}
				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_CAT
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					Log.w(TAG, sBody);
				}
				break;

			}

		} catch (Exception e) {
			Log.e(TAG_I, "Error al crear el archivo " + e.toString());
			e.printStackTrace();
		}
	}

	/**
	 * Muestra el mensaje en el log
	 * 
	 * @param sFileName
	 * @param sBody
	 * @param context
	 */
	public static void l(String TAG, String sBody)  {

		try {

			switch (Constants.SHAREDPREFS.LOG_ACTIVO) {

			case Constants.CONSTANTS.LOG_ALL:
				if (Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_CAT
						|| Constants.SHAREDPREFS.LOG_TIPO == Constants.CONSTANTS.LOG_FILES_AND_CAT) {
					Log.v(TAG, sBody);
				}
				break;

			}

		} catch (Exception e) {
			Log.e(TAG_I, "Error al crear el archivo " + e.toString());
			e.printStackTrace();
		}
	}

	/**
	 * Crea el archivo
	 * 
	 * @param root
	 *            carpeta donde guardarse
	 * @param sFileName
	 *            nombre del archivo
	 * @param sBody
	 *            cuerpo del archivo
	 */
	private static void createFile(File root, String sFileName, String sBody) {

		File gpxfile;
		FileWriter writer;
		String uuid = UUID.randomUUID().toString();

		try {
			gpxfile = new File(root, GetFechaHora.getFechaDMY("-") + "-"
					+ GetFechaHora.getHora24() + "-" + uuid + "-" + sFileName);
			writer = new FileWriter(gpxfile);
			writer.append(GetFechaHora.getFechaDMY() + GetFechaHora.getHora24()
					+ " ---- \n" + sBody);
			writer.flush();
			writer.close();
			Log.d(TAG_I, "Log Saved " + sFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
