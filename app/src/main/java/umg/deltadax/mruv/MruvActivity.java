package umg.deltadax.mruv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import umg.deltadax.mruv.utility.Mruv;
import umg.deltadax.mruv.utility.ShowDialog;


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

        ShowDialog.setContext(this);
    }

    private void calcular() {

        String sDistancia, sVelocidadInicial, sVelocidadFinal, sAceleracion, sTiempo, sMensaje = "Error";
        double distancia = 0.0, velocidad_inicial = 0.0, velocidad_final = 0.0, aceleracion = 0.0, tiempo = 0.0;
        boolean bDistancia = false, bVelocidadInicial = false, bVelocidadFinal = false, bAceleracion = false, bTiempo = false, bError = true, bTodoCorrecto = false;

        sDistancia = et_distancia.getText().toString();
        sTiempo = et_tiempo.getText().toString();
        sVelocidadFinal = et_velocidad_final.getText().toString();
        sVelocidadInicial = et_velocidad_inicial.getText().toString();
        sAceleracion = et_aceleracion.getText().toString();

        if (sVelocidadFinal.isEmpty()) {
            //NO posee distancia
            bVelocidadFinal = false;
        } else {
            bVelocidadFinal = true;
        }

        if (sVelocidadInicial.isEmpty()) {
            //NO posee distancia
            bVelocidadInicial = false;
        } else {
            bVelocidadInicial = true;
        }

        if (sAceleracion.isEmpty()) {
            //NO posee distancia
            bAceleracion = false;
        } else {
            bAceleracion = true;
        }

        if (sDistancia.isEmpty()) {
            //NO posee distancia
            bDistancia = false;
        } else {
            bDistancia = true;
        }

        if (sTiempo.isEmpty()) {
            bTiempo = false;
        } else {
            bTiempo = true;
        }

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
                bVelocidadInicial = true;

            } else {

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
                bVelocidadInicial = true;

            } else {

            }

            // Calcular velocidad inicial metodo 3
            if (!bVelocidadInicial && (bDistancia && bAceleracion && bTiempo) && bError) {

            } else {
            }

            // Calcular velocidad final metodo 1
            if (!bVelocidadFinal && (bVelocidadInicial && bAceleracion && bTiempo) && bError) {
            } else {

            }

            // Calcular velocidad final metodo 2
            if (!bVelocidadInicial && (bVelocidadInicial && bAceleracion && bDistancia) && bError) {
            } else {

            }

            // Calcular tiempo metodo 1
            if (!bTiempo && (bVelocidadFinal && bVelocidadInicial && bAceleracion) && bError) {
            } else {

            }

            // Calcular aceleracion metodo 1
            if (!bAceleracion && (bVelocidadFinal && bVelocidadInicial && bTiempo) && bError) {
            } else {

            }

            // Calcular aceleracion metodo 2
            if (!bAceleracion && (bVelocidadFinal && bVelocidadInicial && bDistancia) && bError) {
            } else {

            }

            // Calcular aceleracion metodo 3
            if (!bAceleracion && (bVelocidadInicial && bTiempo && bDistancia) && bError) {
            } else {

            }

            // Calcular Distancia
            if (!bDistancia && (bVelocidadFinal && bVelocidadInicial && bAceleracion) && bError) {
            } else {

            }

            // Calcular Distancia metodo 2
            if (!bDistancia && (bVelocidadInicial && bAceleracion && bTiempo) && bError) {
            } else {

            }

            if (bError) {

            } else {

            }

        } while (bTodoCorrecto);


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
