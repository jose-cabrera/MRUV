package com.centrikal.visitasmovil.utility;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.centrikal.visitasmovil.R;
import com.centrikal.visitasmovil.arrayadapters.SimpleArrayAdapter;
import com.centrikal.visitasmovil.utility.Constants.WEBSERVICES;

public class ChooseWsDialog {

	static Context context;

	public static void setContext(Context ctx) {
		context = ctx;
	}

	public static void show() {
		Log.d("ChooseWsDialog", "iniciando");
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.choose_ws_dialog);
		dialog.setTitle("Seleccione un web service");
		dialog.setCancelable(false);

		ListView lv_choose_ws = (ListView) dialog
				.findViewById(R.id.lv_choose_ws);
		lv_choose_ws.setAdapter(SimpleArrayAdapter.getStringSimpleAdapter(
				context, WEBSERVICES.URLs));

		Log.d("ChooseWsDialog", "adapter puesto");
		lv_choose_ws.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				WEBSERVICES.URLWS = WEBSERVICES.URLs[position];
				dialog.dismiss();
			}
		});

		dialog.show();
	}

}
