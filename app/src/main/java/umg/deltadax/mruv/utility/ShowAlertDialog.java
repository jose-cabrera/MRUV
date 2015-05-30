package umg.deltadax.mruv.utility;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import umg.deltadax.mruv.R;

/**
 * Created by JoséPablo on 29/05/15.
 */
public class ShowAlertDialog {

        static Context context;

        public static void setContext(Context ctx) {
            context = ctx;
        }

        public static void newDialog(String title, String message) {
            ContextThemeWrapper ctw = new ContextThemeWrapper( context, R.style.alertDialog );
            new AlertDialog.Builder(ctw)
                    .setMessage(message)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
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
            btnAceptar.setOnClickListener(new View.OnClickListener() {

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
            btnAceptar.setOnClickListener(new View.OnClickListener() {

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


