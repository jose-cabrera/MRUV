package umg.deltadax.mruv.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.app.Activity;
import android.content.Context;

import org.apache.http.util.EntityUtils;

import android.util.Base64;
import android.util.Log;

public class HttpHandler {

	private Context ctx;
	private static final String TAG = "httpHandler";

	public HttpHandler(Context context) {
		ctx = context;
	}

	public String post(String stringJSON) {

		if (Connectivity.isConnectedWifi(ctx) || Connectivity.isConnectedMobile(ctx)) {
			try {

				HttpClient httpclient = new DefaultHttpClient();
				/*
				 * Creamos el objeto de HttpClient que nos permitira conectarnos
				 * mediante peticiones http
				 */
				Log.d(TAG, Constants.WEBSERVICES.URLWS);
				HttpPost httppost = new HttpPost(Constants.WEBSERVICES.URLWS);
				/*
				 * El objeto HttpPost permite que enviemos una peticion de tipo
				 * POST a una URL especificada
				 */
				// A??ADIR PARAMETROS

				String stringJSONSinTildes = parseTildes(stringJSON);

				String sBase64toSend = Base64.encodeToString(stringJSONSinTildes.getBytes(), Base64.DEFAULT);
				Log.d("TAMAÑO DEL BASE64", "" + sBase64toSend.length());
				// byte[] byteToSend = sBase64toSend.getBytes();
				Log.d(TAG, "BASE64 to send " + sBase64toSend);
				// Log.d(TAG, "BYTES to send "+byteToSend.toString());

				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair(Constants.WEBSERVICES.WSPARAM, sBase64toSend));
				/*
				 * Una vez a??adidos los parametros actualizamos la entidad de
				 * httppost, esto quiere decir en pocas palabras anexamos los
				 * parametros al objeto para que al enviarse al servidor envien
				 * los datos que hemos a??adido
				 */
				httppost.setEntity(new UrlEncodedFormEntity(params));

				// 8. Execute POST request to the given URL

				HttpParams httpParameters = new BasicHttpParams();
				// Set the timeout in milliseconds until a connection is
				// established.
				int timeoutConnection = 120000;
				HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
				// Set the default socket timeout (SO_TIMEOUT)
				// in milliseconds which is the timeout for waiting for data.
				int timeoutSocket = 120000;
				HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

				httppost.setParams(httpParameters);

				/* Finalmente ejecutamos enviando la info al server */
				Log.d(TAG, httppost.toString());
				HttpResponse resp = httpclient.execute(httppost);
				HttpEntity ent = resp.getEntity();/* y obtenemos una respuesta */

				String sBase64 = EntityUtils.toString(ent);
				Log.d(TAG, "BASE64 recivida " + sBase64);
				byte[] bBase64aStringJSON = Base64.decode(sBase64, Base64.DEFAULT);
				String sBase64aStringJSON = new String(bBase64aStringJSON);

				if (sBase64aStringJSON.matches("")) {
					sBase64aStringJSON = "error empty string";
					Log.e("TAG", sBase64aStringJSON);
				}

				return sBase64aStringJSON;

			} catch (Exception e) {

				// String title = "Servidor Web";
				String message = "Existe algun problema con el servidor, intentelo más tarde. ";

				if (Constants.SHAREDPREFS.LOGIN_SERVICE_ACTIVO) {
					ShowToast.instantMessage(message);
				} else {
					// ShowDialog.newDialog(title, message);
				}
				LoadingDialog.stopSpinnerLoading();
				Log.e("TAG", message + " " + e.toString());
				return Constants.CONSTANTS.WS_ERROR + e;
			}
		} else {
			LoadingDialog.stopSpinnerLoading();
			String message = "No posee conexión a Internet. Se enviara más tarde.";
			Constants.SHAREDPREFS.LOGIN_SERVICE_ACTIVO = false;
			ShowToast.instantMessage(message);

			String e = "No internet Connection";

			Log.e("TAG", message + " " + e.toString());
			return Constants.CONSTANTS.WS_ERROR + e;
		}
	}

	/**
	 * Función que elimina acentos y caracteres especiales de una cadena de
	 * texto.
	 * 
	 * @param input
	 * @return cadena de texto limpia de acentos y caracteres especiales.
	 */
	public static String parseTildes(String input) {
		// Cadena de caracteres original a sustituir.
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		// Cadena de caracteres ASCII que reemplazarán los originales.
		String[] ascii = { "&acute;", "&agrave;", "&auml;", "&ecute;", "&egrave;", "&euml;", "&icute;", "&igrave;",
				"&iuml;", "&ocute;", "&ograve;", "&ouml;", "&ucute;", "&ugrave;", "&uuml;", "&ntilde;", "&Acute;",
				"&Agrave;", "&Auml;", "&Ecute;", "&Egrave;", "&Euml;", "&Icute;", "&Igrave;", "&Iuml;", "&Ocute;",
				"&Ograve;", "&Ouml;", "&Ucute;", "&Ugrave;", "&Uuml;", "&Ntilde;", "&Ccedil;", "&ccedil;" };
		String output = input;
		for (int i = 0; i < original.length(); i++) {
			// Reemplazamos los caracteres especiales.
			output = output.replaceAll(original.substring(i), ascii[i]);
		}// for i
		return output;
	}// remove1

}