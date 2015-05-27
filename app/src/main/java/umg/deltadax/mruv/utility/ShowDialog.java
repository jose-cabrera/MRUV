package com.centrikal.visitasmovil.utility;

import java.util.ArrayList;

import com.centrikal.visitasmovil.R;
import com.centrikal.visitasmovil.webservices.objects.WsTagValorObject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ShowDialog {

	static Context context;

	public static void setContext(Context ctx) {
		context = ctx;
	}

	public static void newDialog(String title, String message) {
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle(title);
		dialog.setCancelable(false);

		ScrollView sv = (ScrollView) dialog.findViewById(R.id.sv_dialog);
		sv.setMinimumHeight(0);

		TextView tvMessage = (TextView) dialog.findViewById(R.id.tv_dialogmessage);
		tvMessage.setText(message);

		if (!((Activity) context).isFinishing()) {
			dialog.show();
		}

		Button btnAceptar = (Button) dialog.findViewById(R.id.btn_dialogo_compatible);
		btnAceptar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialog.dismiss();
			}
		});
	}

	public static void newDialog(String title, ArrayList<WsTagValorObject> datos) {
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle(title);
		dialog.setCancelable(false);

		TextView tvMessage = (TextView) dialog.findViewById(R.id.tv_dialogmessage);
		tvMessage.setVisibility(View.GONE);

		LinearLayout ll_dialog = (LinearLayout) dialog.findViewById(R.id.ll_dialog);

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		for (int i = 0; i < datos.size(); i++) {

			View tag_Valor = inflater.inflate(R.layout.inc_ingreso_tipo_1_tag_valor, ll_dialog, false);

			TextView tv_tag = (TextView) tag_Valor.findViewById(R.id.tv_tag);
			TextView tv_valor = (TextView) tag_Valor.findViewById(R.id.tv_valor);

			tv_tag = (TextView) tag_Valor.findViewById(R.id.tv_tag);
			tv_valor = (TextView) tag_Valor.findViewById(R.id.tv_valor);

			if (!datos.get(i).getTag().isEmpty()) {
				tv_tag.setText(datos.get(i).getTag());
			}
			if (!datos.get(i).getValor().isEmpty()) {
				tv_valor.setText(datos.get(i).getValor());
			}

			ll_dialog.addView(tag_Valor);

		}

		if (!((Activity) context).isFinishing()) {
			dialog.show();
		}

		Button btnAceptar = (Button) dialog.findViewById(R.id.btn_dialogo_compatible);
		btnAceptar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialog.dismiss();
			}
		});
	}

	public static void newDialog(String title, View view) {
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle(title);
		dialog.setCancelable(false);

		TextView tvMessage = (TextView) dialog.findViewById(R.id.tv_dialogmessage);
		tvMessage.setVisibility(View.GONE);

		LinearLayout ll_dialog = (LinearLayout) dialog.findViewById(R.id.ll_dialog);
		ll_dialog.addView(view);

		if (!((Activity) context).isFinishing()) {
			dialog.show();
		}

		Button btnAceptar = (Button) dialog.findViewById(R.id.btn_dialogo_compatible);
		btnAceptar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialog.dismiss();
			}
		});
	}

	public static void newDialogGoBack(String title, String message, final boolean finish) {
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.dialog);
		dialog.setTitle(title);
		dialog.setCancelable(false);

		ScrollView sv = (ScrollView) dialog.findViewById(R.id.sv_dialog);
		sv.setMinimumHeight(0);

		TextView tvMessage = (TextView) dialog.findViewById(R.id.tv_dialogmessage);
		tvMessage.setText(message);

		if (!((Activity) context).isFinishing()) {
			dialog.show();
		}

		Button btnAceptar = (Button) dialog.findViewById(R.id.btn_dialogo_compatible);
		btnAceptar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialog.dismiss();
				if (finish)
					((Activity) context).finish();
				else
					((Activity) context).onBackPressed();

			}
		});
	}

}
