package com.centrikal.visitasmovil.utility;

import com.centrikal.visitasmovil.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Crea un confirm dialog con botones de si y no El boton si posee el evento que
 * uno desee
 * 
 * @author josepablocabreragarcia
 * 
 */
public class ShowConfirmDialog {

	static Context context;
	static Dialog dialog;

	/**
	 * Setea el contexto donde se utilizara el confirm
	 * 
	 * @param ctx
	 *            contexto
	 */
	public static void setContext(Context ctx) {
		context = ctx;
		dialog = new Dialog(context);
	}

	/**
	 * Crea el confirm, lo muestra y ejecuta la acción del boton si que halla
	 * sido enviada
	 * 
	 * @param title
	 *            titulo a mostrar
	 * @param message
	 *            mensaje o pregunta
	 * @param BotonNo
	 *            titulo para el boton No
	 * @param BotonSi
	 *            titulo para el boton Si
	 * @param listenerBotonSi
	 *            evento a realizar en caso el boton si es precionado
	 */
	public static Dialog newDialog(String title, String message,
			String BotonNo, String BotonSi, OnClickListener listenerBotonSi) {

		dialog.setContentView(R.layout.dialog_confirm);
		dialog.setTitle(title);
		dialog.setCancelable(false);

		TextView tvMessage = (TextView) dialog
				.findViewById(R.id.tv_dialogmessage);
		tvMessage.setText(message);

		if (!((Activity) context).isFinishing()) {
			dialog.show();
		}

		Button btnNo = (Button) dialog.findViewById(R.id.btn_dialogo_no);
		btnNo.setText(BotonNo);
		btnNo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

		Button btnSi = (Button) dialog.findViewById(R.id.btn_dialogo_yes);
		btnSi.setText(BotonSi);
		btnSi.setOnClickListener(listenerBotonSi);

		return dialog;
	}

	/**
	 * Retorna el dialogo utilizado
	 * 
	 * @return retorna dialogo
	 */
	public static Dialog getDialog() {
		return dialog;
	}

}
