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

import umg.deltadax.mruv.utility.InteractFreeFall;
import umg.deltadax.mruv.utility.ShowAlertDialog;
import umg.deltadax.mruv.utility.ShowDialog;


public class CaidaLibreActivity extends Activity implements View.OnClickListener {

    EditText et_altura, et_velocidad_inicial, et_velocidad_final, et_gravedad, et_tiempo;
    Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caida_libre);

        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(this);

        et_altura = (EditText) findViewById(R.id.et_altura);
        et_gravedad = (EditText) findViewById(R.id.et_gravedad);
        et_tiempo = (EditText) findViewById(R.id.et_tiempo);
        et_velocidad_final = (EditText) findViewById(R.id.et_velocidad_final);
        et_velocidad_inicial = (EditText) findViewById(R.id.et_velocidad_inicial);

        ShowAlertDialog.setContext(this);

    }

    private void calcular(){

        String sAltura, sVelocidadInicial, sVelocidadFinal, sGravedad, sTiempo;
        double altura = 0.0, velocidad_inicial = 0.0, velocidad_final = 0.0, gravedad = 0.0, tiempo = 0.0;
        boolean bAltura, bVelocidadInicial, bVelocidadFinal, bGravedad, bTiempo, bError = true, bTodoCorrecto = false;

        sAltura = et_altura.getText().toString();
        sTiempo = et_tiempo.getText().toString();
        sVelocidadFinal = et_velocidad_final.getText().toString();
        sVelocidadInicial = et_velocidad_inicial.getText().toString();
        sGravedad = et_gravedad.getText().toString();

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

        if (sGravedad.isEmpty()) {
            //NO posee distancia
            bGravedad = false;
        } else {
            bGravedad = true;
            count += 1;
        }

        if (sAltura.isEmpty()) {
            //NO posee distancia
            bAltura = false;
        } else {
            bAltura = true;
            count += 1;
        }

        if (sTiempo.isEmpty()) {
            bTiempo = false;
        } else {
            bTiempo = true;
            count += 1;
        }


        if (count >= 3 && count < 5) {

            InteractFreeFall interact = new InteractFreeFall();
            interact.iniFlags();

            if(bAltura){
                altura = Double.parseDouble(sAltura);
                interact.setHeight(altura);
            }

            if(bVelocidadFinal){
                velocidad_final = Double.parseDouble(sVelocidadFinal);
                interact.setFinVelocity(velocidad_final);
            }

            if(bVelocidadInicial){
                velocidad_inicial = Double.parseDouble(sVelocidadInicial);
                interact.setIniVelocity(velocidad_inicial);
            }

            if(bTiempo){
                tiempo = Double.parseDouble(sTiempo);
                interact.setTime(tiempo);
            }

            if(bGravedad){
                gravedad = Double.parseDouble(sGravedad);
                interact.setGravity(gravedad);
            }

            interact.fnSolveSystem();

            Intent intent = new Intent(this, RespuestasActivity.class);
            intent.putExtra(RespuestasActivity.KEY_RESPUESTA, RespuestasActivity.RESPUESTA_CAIDA_LIBRE);
            intent.putExtra(RespuestasActivity.KEY_ALTURA, interact.getHeight());
            intent.putExtra(RespuestasActivity.KEY_TIEMPO, interact.getTime());
            intent.putExtra(RespuestasActivity.KEY_GRAVEDAD, interact.getGravity());
            intent.putExtra(RespuestasActivity.KEY_VELOCIDAD_FINAL, interact.getFinVelocity());
            intent.putExtra(RespuestasActivity.KEY_VELOCIDAD_INICIAL, interact.getIniVelocity());

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

        switch (v.getId()){
            case R.id.btn_calcular:
                calcular();
                break;
        }

    }
}
