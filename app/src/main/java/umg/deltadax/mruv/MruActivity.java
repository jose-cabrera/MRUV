package umg.deltadax.mruv;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import umg.deltadax.mruv.utility.Mru;
import umg.deltadax.mruv.utility.ShowAlertDialog;



public class MruActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "MruActivity";

    EditText et_distancia, et_velocidad, et_tiempo;
    Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mru);

        et_distancia = (EditText) findViewById(R.id.et_distancia);
        et_velocidad = (EditText) findViewById(R.id.et_velocidad);
        et_tiempo = (EditText) findViewById(R.id.et_tiempo);

        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(this);

        ShowAlertDialog.setContext(this);
    }



    private void calcular() {

        String sDistancia, sVelocidad, sTiempo, sMensaje = "Error";
        double distancia = 0.0, velocidad = 0.0, tiempo = 0.0;
        boolean bDistancia = false, bVelocidad = false, bTiempo = false, bError = true;

        sDistancia = et_distancia.getText().toString();
        sVelocidad = et_velocidad.getText().toString();
        sTiempo = et_tiempo.getText().toString();

        if (sDistancia.isEmpty()) {
            //NO posee distancia
            bDistancia = false;
        } else {
            bDistancia = true;
        }

        if (sVelocidad.isEmpty()) {
            bVelocidad = false;
        } else {
            bVelocidad = true;
        }

        if (sTiempo.isEmpty()) {
            bTiempo = false;
        } else {
            bTiempo = true;
        }

        Mru object = new Mru();
        object.Init();

        //Calcular distancia
        if (!bDistancia && (bVelocidad && bTiempo) && bError) {

            velocidad = Double.parseDouble(sVelocidad);
            tiempo = Double.parseDouble(sTiempo);
            object.setVelocity(velocidad);
            object.setTime(tiempo);

            object.fnCalcDistance();

            distancia = object.getDistance();

            bError = false;
        } else {
            if (bError) {
                sMensaje = "Debes tener al menos dos parametros llenos y uno vacio para continuar";
                bError = true;
            }
        }

        //Calcular velocidad
        if (!bVelocidad && (bDistancia && bTiempo) && bError) {

            distancia = Double.parseDouble(sDistancia);
            tiempo = Double.parseDouble(sTiempo);
            object.setDistance(distancia);
            object.setTime(tiempo);

            object.fnCalcVelocity();

            velocidad = object.getVelocity();

            bError = false;
        } else {
            if (bError) {
                sMensaje = "Debes tener al menos dos parametros llenos y uno vacio para continuar";
                bError = true;
            }
        }

        //Calcular tiempo
        if (!bTiempo && (bVelocidad && bDistancia) && bError) {

            velocidad = Double.parseDouble(sVelocidad);
            distancia = Double.parseDouble(sDistancia);
            object.setVelocity(velocidad);
            object.setDistance(distancia);

            object.fnCalcTime();

            tiempo = object.getTime();

            bError = false;
        } else {
            if (bError) {
                sMensaje = "Debes tener al menos dos parametros llenos y uno vacio para continuar";
                bError = true;
            }
        }

        if (bError) {
            //Mostrar dialog con mensaje de error
            ShowAlertDialog.newDialog("MRU", sMensaje);
            Log.d(TAG, sMensaje);
        } else {
            Intent intent = new Intent(this, RespuestasActivity.class);
            intent.putExtra(RespuestasActivity.KEY_RESPUESTA, RespuestasActivity.RESPUESTA_MRU);
            intent.putExtra(RespuestasActivity.KEY_DISTANCIA, distancia);
            intent.putExtra(RespuestasActivity.KEY_VELCODIAD, velocidad);
            intent.putExtra(RespuestasActivity.KEY_TIEMPO, tiempo);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                getWindow().setExitTransition(new Slide());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent, ActivityOptions
                        .makeSceneTransitionAnimation(this).toBundle());
            } else {
                startActivity(intent);
            }
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_calcular:
                calcular();
                break;
        }
    }
}
