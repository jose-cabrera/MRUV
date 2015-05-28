package umg.deltadax.mruv.utility;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Abre diferentes tipos de Intent de forma sencilla
 * 
 * @author josepablocabreragarcia
 * 
 */
public class OpenIntents {

	private Context context;

	/**
	 * Obtiene el contexto donde utilizarse
	 * 
	 * @param context
	 */
	public OpenIntents(Context context) {
		this.context = context;
	}

	/**
	 * Abre una url en explorador, y si hay más de uno da la opción a escojer el
	 * de preferencia
	 * 
	 * @param url
	 *            que quiere visitarse
	 */
	public void abrirURL(String url) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		context.startActivity(i);
	}

	/**
	 * Abre una imagen en la galeria de imagenes, y si hay más de uno da la
	 * opción a escojer el de preferencia
	 * 
	 * @param file
	 *            archivo de la imagen
	 */
	public void verImagenEnGaleria(File file) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file), "image/*");
		context.startActivity(intent);
	}

	/**
	 * Abre una imagen en la galeria de imagenes, y si hay más de uno da la
	 * opción a escojer el de preferencia
	 * 
	 * @param filePath
	 *            path del archivo de la imagen
	 */
	public void verImagenEnGaleria(String filePath) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(new File(filePath)), "image/*");
		context.startActivity(intent);
	}

	/**
	 * Abre un archivo PDF en el lector de PDFs, y si hay más de uno da la
	 * opción a escojer el de preferencia
	 * 
	 * @param file
	 *            archivo PDF
	 */
	public void abrirPDF(File file) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file), "application/pdf");
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		context.startActivity(intent);
	}

	public void marcarNumero(String numero) {

		String uri = "tel:" + numero.trim();
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse(uri));
		context.startActivity(intent);

	}

	public void hacerLlamada(String numero) {

		String uri = "tel:" + numero.trim();
		Intent intent = new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse(uri));
		context.startActivity(intent);

	}

	public void openGPSSettings() {
		Intent intent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		context.startActivity(intent);
	}

}
