package umg.deltadax.mruv;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

import umg.deltadax.mruv.utility.Mruv;
import umg.deltadax.mruv.utility.ShowAlertDialog;


public class MruvActivity extends Activity implements View.OnClickListener {

    EditText et_distancia, et_tiempo, et_aceleracion, et_velocidad_inicial, et_velocidad_final;
    Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mruv);

        et_aceleracion = (EditText) findViewById(R.id.et_aceleracion);
        et_distancia = (EditText) findViewById(R.id.et_distancia);
        et_tiempo = (EditText) findViewById(R.id.et_tiempo);
        et_velocidad_inicial = (EditText) findViewById(R.id.et_velocidad_inicial);
        et_velocidad_final = (EditText) findViewById(R.id.et_velocidad_final);

        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(this);

        ShowAlertDialog.setContext(this);
    }

    private void calcular() {

        String sDistancia, sVelocidadInicial, sVelocidadFinal, sAceleracion, sTiempo;
        double distancia = 0.0, velocidad_inicial = 0.0, velocidad_final = 0.0, aceleracion = 0.0, tiempo = 0.0;
        boolean bDistancia, bVelocidadInicial, bVelocidadFinal, bAceleracion, bTiempo, bError = true, bTodoCorrecto = false;

        sDistancia = et_distancia.getText().toString();
        sTiempo = et_tiempo.getText().toString();
        sVelocidadFinal = et_velocidad_final.getText().toString();
        sVelocidadInicial = et_velocidad_inicial.getText().toString();
        sAceleracion = et_aceleracion.getText().toString();

        int count = 0;

        if (sVelocidadFinal.isEmpty()) {
            //NO posee distancia
            bVelocidadFinal = false;
        } else {
            bVelocidadFinal = true;
            count += 1;
        }

        if (sVelocidadInicial.isEmpty()) {
            //NO posee distancia
            bVelocidadInicial = false;
        } else {
            bVelocidadInicial = true;
            count += 1;
        }

        if (sAceleracion.isEmpty()) {
            //NO posee distancia
            bAceleracion = false;
        } else {
            bAceleracion = true;
            count += 1;
        }

        if (sDistancia.isEmpty()) {
            //NO posee distancia
            bDistancia = false;
        } else {
            bDistancia = true;
            count += 1;
        }

        if (sTiempo.isEmpty()) {
            bTiempo = false;
        } else {
            bTiempo = true;
            count += 1;
        }


        if (count >= 3 && count < 5) {

            Mruv object = new Mruv();
            object.Init();

            do {
                // Calcular velocidad inical
                if (!bVelocidadInicial && (bVelocidadFinal && bAceleracion && bTiempo) && bError) {

                    velocidad_final = Double.parseDouble(sVelocidadFinal);
                    tiempo = Double.parseDouble(sTiempo);
                    aceleracion = Double.parseDouble(sAceleracion);

                    object.setTime(tiempo);
                    object.setAcceleration(aceleracion);
                    object.setFinVelocity(velocidad_final);

                    object.fnCalcIniVelocity1();

                    velocidad_inicial = object.getIniVelocity();
                    sVelocidadInicial = String.valueOf(velocidad_inicial);
                    bVelocidadInicial = true;

                }

                // Calcular velocidad inicial metodo 2
                if (!bVelocidadInicial && (bVelocidadFinal && bAceleracion && bDistancia) && bError) {

                    velocidad_final = Double.parseDouble(sVelocidadFinal);
                    distancia = Double.parseDouble(sDistancia);
                    aceleracion = Double.parseDouble(sAceleracion);

                    object.setFinVelocity(velocidad_final);
                    object.setDistance(distancia);
                    object.setAcceleration(aceleracion);

                    object.fnCalcIniVelocity2();

                    velocidad_inicial = object.getIniVelocity();
                    sVelocidadInicial = String.valueOf(velocidad_inicial);
                    bVelocidadInicial = true;

                }

                // Calcular velocidad inicial metodo 3
                if (!bVelocidadInicial && (bDistancia && bAceleracion && bTiempo) && bError) {

                    distancia = Double.parseDouble(sDistancia);
                    tiempo = Double.parseDouble(sTiempo);
                    aceleracion = Double.parseDouble(sAceleracion);

                    object.setTime(tiempo);
                    object.setDistance(distancia);
                    object.setAcceleration(aceleracion);

                    object.fnCalcIniVelocity3();

                    velocidad_inicial = object.getIniVelocity();
                    sVelocidadInicial = String.valueOf(velocidad_inicial);
                    bVelocidadInicial = true;

                }

                // Calcular velocidad inicial metodo 3
                if (!bVelocidadInicial && (bDistancia && bVelocidadFinal && bTiempo) && bError) {

                    distancia = Double.parseDouble(sDistancia);
                    tiempo = Double.parseDouble(sTiempo);
                    velocidad_final = Double.parseDouble(sVelocidadFinal);

                    object.setTime(tiempo);
                    object.setDistance(distancia);
                    object.setFinVelocity(velocidad_final);

                    object.fnCalcIniVelocity4();

                    velocidad_inicial = object.getIniVelocity();
                    sVelocidadInicial = String.valueOf(velocidad_inicial);
                    bVelocidadInicial = true;

                }

                // Calcular velocidad final metodo 1
                if (!bVelocidadFinal && (bVelocidadInicial && bAceleracion && bTiempo) && bError) {

                    aceleracion = Double.parseDouble(sAceleracion);
                    tiempo = Double.parseDouble(sTiempo);
                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);

                    object.setTime(tiempo);
                    object.setAcceleration(aceleracion);
                    object.setIniVelocity(velocidad_inicial);

                    object.fnCalcFinVelocity1();

                    velocidad_final = object.getFinVelocity();
                    sVelocidadFinal = String.valueOf(velocidad_final);
                    bVelocidadFinal = true;

                }

                // Calcular velocidad final metodo 2
                if (!bVelocidadFinal && (bVelocidadInicial && bAceleracion && bDistancia) && bError) {

                    distancia = Double.parseDouble(sDistancia);
                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    aceleracion = Double.parseDouble(sAceleracion);

                    object.setIniVelocity(velocidad_inicial);
                    object.setDistance(distancia);
                    object.setAcceleration(aceleracion);

                    object.fnCalcFinVelocity2();

                    velocidad_final = object.getFinVelocity();
                    sVelocidadFinal = String.valueOf(velocidad_final);
                    bVelocidadFinal = true;

                }

                // Calcular velocidad final metodo 3
                if (!bVelocidadFinal && (bVelocidadInicial && bTiempo && bDistancia) && bError) {

                    distancia = Double.parseDouble(sDistancia);
                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    tiempo = Double.parseDouble(sTiempo);

                    object.setIniVelocity(velocidad_inicial);
                    object.setDistance(distancia);
                    object.setTime(tiempo);

                    object.fnCalcFinVelocity3();

                    velocidad_final = object.getFinVelocity();
                    sVelocidadFinal = String.valueOf(velocidad_final);
                    bVelocidadFinal = true;

                }

                // Calcular tiempo metodo 1
                if (!bTiempo && (bVelocidadFinal && bVelocidadInicial && bAceleracion) && bError) {


                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    velocidad_final = Double.parseDouble(sVelocidadFinal);
                    aceleracion = Double.parseDouble(sAceleracion);

                    object.setFinVelocity(velocidad_final);
                    object.setIniVelocity(velocidad_inicial);
                    object.setAcceleration(aceleracion);

                    object.fnCalcTime1();

                    tiempo = object.getTime();
                    sTiempo = String.valueOf(tiempo);
                    bTiempo = true;

                }

                // Calcular tiempo metodo 2
                if (!bTiempo && (bVelocidadFinal && bVelocidadInicial && bDistancia) && bError) {

                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    velocidad_final = Double.parseDouble(sVelocidadFinal);
                    distancia = Double.parseDouble(sDistancia);

                    object.setFinVelocity(velocidad_final);
                    object.setIniVelocity(velocidad_inicial);
                    object.setDistance(distancia);

                    object.fnCalcTime3();

                    tiempo = object.getTime();
                    sTiempo = String.valueOf(tiempo);
                    bTiempo = true;

                }

                // Calcular aceleracion metodo 1
                if (!bAceleracion && (bVelocidadFinal && bVelocidadInicial && bTiempo) && bError) {

                    velocidad_final = Double.parseDouble(sVelocidadFinal);
                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    tiempo = Double.parseDouble(sTiempo);

                    object.setTime(tiempo);
                    object.setIniVelocity(velocidad_inicial);
                    object.setFinVelocity(velocidad_final);

                    object.fnCalcAcceleration1();

                    aceleracion = object.getAcceleration();
                    sAceleracion = String.valueOf(aceleracion);
                    bAceleracion = true;

                }

                // Calcular aceleracion metodo 2
                if (!bAceleracion && (bVelocidadFinal && bVelocidadInicial && bDistancia) && bError) {

                    velocidad_final = Double.parseDouble(sVelocidadFinal);
                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    distancia = Double.parseDouble(sDistancia);

                    object.setDistance(distancia);
                    object.setIniVelocity(velocidad_inicial);
                    object.setFinVelocity(velocidad_final);

                    object.fnCalcAcceleration2();

                    aceleracion = object.getAcceleration();
                    sAceleracion = String.valueOf(aceleracion);
                    bAceleracion = true;

                }

                // Calcular aceleracion metodo 3
                if (!bAceleracion && (bVelocidadInicial && bTiempo && bDistancia) && bError) {

                    distancia = Double.parseDouble(sDistancia);
                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    tiempo = Double.parseDouble(sTiempo);

                    object.setTime(tiempo);
                    object.setIniVelocity(velocidad_inicial);
                    object.setDistance(distancia);

                    object.fnCalcAcceleration3();

                    aceleracion = object.getAcceleration();
                    sAceleracion = String.valueOf(aceleracion);
                    bAceleracion = true;

                }

                // Calcular Distancia
                if (!bDistancia && (bVelocidadFinal && bVelocidadInicial && bAceleracion) && bError) {

                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    velocidad_final = Double.parseDouble(sVelocidadFinal);
                    aceleracion = Double.parseDouble(sAceleracion);

                    object.setFinVelocity(velocidad_final);
                    object.setIniVelocity(velocidad_inicial);
                    object.setAcceleration(aceleracion);

                    object.fnCalcDistance1();


                    distancia = object.getDistance();
                    sDistancia = String.valueOf(distancia);
                    bDistancia = true;

                }

                // Calcular Distancia metodo 2
                if (!bDistancia && (bVelocidadInicial && bAceleracion && bTiempo) && bError) {

                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    tiempo = Double.parseDouble(sTiempo);
                    aceleracion = Double.parseDouble(sAceleracion);

                    object.setTime(tiempo);
                    object.setIniVelocity(velocidad_inicial);
                    object.setAcceleration(aceleracion);

                    object.fnCalcDistance2();

                    distancia = object.getDistance();
                    sDistancia = String.valueOf(distancia);
                    bDistancia = true;

                }

                // Calcular Distancia metodo 3
                if (!bDistancia && (bVelocidadFinal && bVelocidadInicial && bTiempo) && bError) {

                    velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                    velocidad_final = Double.parseDouble(sVelocidadFinal);
                    tiempo = Double.parseDouble(sTiempo);

                    object.setTime(tiempo);
                    object.setIniVelocity(velocidad_inicial);
                    object.setFinVelocity(velocidad_final);

                    object.fnCalcDistance3();

                    distancia = object.getDistance();
                    sDistancia = String.valueOf(distancia);
                    bDistancia = true;

                }


                if (bDistancia && bTiempo && bAceleracion && bVelocidadFinal && bVelocidadInicial) {
                    bTodoCorrecto = true;
                }


            } while (!bTodoCorrecto);

            ArrayList<String> log = object.getLog();
            String logConcat = "";
            for(int i=0; i<log.size(); i++){
                if(i>0)
                    logConcat += "\n";

                logConcat += log.get(i);
            }

            Intent intent = new Intent(this, RespuestasActivity.class);
            intent.putExtra(RespuestasActivity.KEY_RESPUESTA, RespuestasActivity.RESPUESTA_MRUV);
            intent.putExtra(RespuestasActivity.KEY_DISTANCIA, distancia);
            intent.putExtra(RespuestasActivity.KEY_TIEMPO, tiempo);
            intent.putExtra(RespuestasActivity.KEY_ACELERACION, aceleracion);
            intent.putExtra(RespuestasActivity.KEY_VELOCIDAD_FINAL, velocidad_final);
            intent.putExtra(RespuestasActivity.KEY_VELOCIDAD_INICIAL, velocidad_inicial);
            intent.putExtra(RespuestasActivity.KEY_LOG, logConcat);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                getWindow().setExitTransition(new Slide());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent, ActivityOptions
                        .makeSceneTransitionAnimation(this).toBundle());
            } else {
                startActivity(intent);
            }

        } else {
            ShowAlertDialog.newDialog("MRUV", "Necesitas como minimo 3 datos y al menos uno vacio.");
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
