package umg.deltadax.mruv.utility;

import java.util.ArrayList;

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

import umg.deltadax.mruv.R;

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
