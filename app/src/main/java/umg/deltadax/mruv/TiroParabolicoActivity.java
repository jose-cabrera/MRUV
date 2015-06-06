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

import org.w3c.dom.DOMImplementation;

import umg.deltadax.mruv.utility.ParabolicShot;
import umg.deltadax.mruv.utility.ShowAlertDialog;


public class TiroParabolicoActivity extends Activity implements View.OnClickListener {

    EditText et_gravedad, et_tiempo_subida, et_tiempo_bajada, et_tiempo_total, et_altura_maxima, et_angulo,
            et_ini_vel, et_ini_vel_y, et_ini_vel_x, et_distacia_maxima;

    Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiro_parabolico);

        et_altura_maxima = (EditText) findViewById(R.id.et_altura_maxima);
        et_distacia_maxima = (EditText) findViewById(R.id.et_distancia_maxima);
        et_angulo = (EditText) findViewById(R.id.et_angulo);
        et_gravedad = (EditText) findViewById(R.id.et_gravedad);
        et_tiempo_subida = (EditText) findViewById(R.id.et_tiempo_subida);
        et_tiempo_bajada = (EditText) findViewById(R.id.et_tiempo_bajada);
        et_tiempo_total = (EditText) findViewById(R.id.et_tiempo_total);
        et_ini_vel_x = (EditText) findViewById(R.id.et_ini_vel_x);
        et_ini_vel_y = (EditText) findViewById(R.id.et_ini_vel_y);
        et_ini_vel = (EditText) findViewById(R.id.et_ini_vel);

        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        btn_calcular.setOnClickListener(this);

        ShowAlertDialog.setContext(this);

    }

    private void calcular() {
        Boolean bAlturaMaxima, bDistanciaMaxima, bAngulo, bGravedad = null, bTiempoSubida, bTiempoBajada,
                bTiempoTotal, bVelocidadInicial, bVelocidadInicialX, bVelocidadInicialY,
                bTodoCorrecto = false;

        String sAlturaMaxima, sDistanciaMaxima, sAngulo, sGravedad, sTiempoSubida, sTiempoBajada,
                sTiempoTotal, sVelocidadInicial, sVelocidadInicialX, sVelocidadInicialY;

        double alturaMaxima = 0, distanciaMaxima = 0, angulo = 0, gravedad = 0, tiempoSubida = 0, tiempoBajdada = 0,
                tiempoTotal = 0, velocidadInicial = 0, velocidadInicialX = 0, velocidadInicialY = 0;

        sAlturaMaxima = et_altura_maxima.getText().toString();
        sDistanciaMaxima = et_distacia_maxima.getText().toString();
        sAngulo = et_angulo.getText().toString();
        sTiempoSubida = et_tiempo_subida.getText().toString();
        sTiempoBajada = et_tiempo_bajada.getText().toString();
        sTiempoTotal = et_tiempo_total.getText().toString();
        sVelocidadInicial = et_ini_vel.getText().toString();
        sVelocidadInicialX = et_ini_vel_x.getText().toString();
        sVelocidadInicialY = et_ini_vel_y.getText().toString();
        sGravedad = et_gravedad.getText().toString();

        int count = 0;

        if (sAlturaMaxima.isEmpty()) {
            bAlturaMaxima = false;
        } else {
            count += 1;
            bAlturaMaxima = true;
        }

        if (sDistanciaMaxima.isEmpty()) {
            bDistanciaMaxima = false;
        } else {
            count += 1;
            bDistanciaMaxima = true;
        }

        if (sAngulo.isEmpty()) {
            bAngulo = false;
        } else {
            count += 1;
            bAngulo = true;
        }
        if (sTiempoSubida.isEmpty()) {
            bTiempoSubida = false;
        } else {
            count += 1;
            bTiempoSubida = true;
        }

        if (sTiempoBajada.isEmpty()) {
            bTiempoBajada = false;
        } else {
            count += 1;
            bTiempoBajada = true;
        }

        if (sTiempoTotal.isEmpty()) {
            bTiempoTotal = false;
        } else {
            count += 1;
            bTiempoTotal = true;
        }

        if (sVelocidadInicial.isEmpty()) {
            bVelocidadInicial = false;
        } else {
            count += 1;
            bVelocidadInicial = true;
        }

        if (sVelocidadInicialX.isEmpty()) {
            bVelocidadInicialX = false;
        } else {
            count += 1;
            bVelocidadInicialX = true;
        }

        if (sVelocidadInicialY.isEmpty()) {
            bVelocidadInicialY = false;
        } else {
            count += 1;
            bVelocidadInicialY = true;
        }

        if (sGravedad.isEmpty()) {
            bGravedad = false;
        } else {
            count += 1;
            bGravedad = true;
        }


        if (count >= 5 && count < 12) {

            ParabolicShot object = new ParabolicShot();

            do {

                // Calcular gravedad metodo 1
                if (!bGravedad && (bVelocidadInicialY && bAlturaMaxima)) {

                    velocidadInicialY = Double.parseDouble(sVelocidadInicialY);
                    alturaMaxima = Double.parseDouble(sAlturaMaxima);

                    object.setIniVelocityY(velocidadInicialY);
                    object.setMaxHeight(alturaMaxima);

                    object.fnCalcGravity1();

                    gravedad = object.getGravity();
                    sGravedad = String.valueOf(gravedad);
                    bGravedad = true;

                }

                // Calcular gravedad metodo 2
                if (!bGravedad && (bVelocidadInicialY && bTiempoSubida)) {
                    velocidadInicialY = Double.parseDouble(sVelocidadInicialY);
                    tiempoSubida = Double.parseDouble(sTiempoSubida);

                    object.setIniVelocityY(velocidadInicialY);
                    object.setTimeUp(tiempoSubida);

                    object.fnCalcGravity2();

                    gravedad = object.getGravity();
                    sGravedad = String.valueOf(gravedad);
                    bGravedad = true;
                }

                // Calcular gravedad metodo 3
                if (!bGravedad && (bAlturaMaxima && bTiempoBajada)) {
                    alturaMaxima = Double.parseDouble(sAlturaMaxima);
                    tiempoBajdada = Double.parseDouble(sTiempoBajada);

                    object.setMaxHeight(alturaMaxima);
                    object.setTimeDown(tiempoBajdada);

                    object.fnCalcGravity3();

                    gravedad = object.getGravity();
                    sGravedad = String.valueOf(gravedad);
                    bGravedad = true;
                }

                // Calcular gravedad metodo 4
                if (!bGravedad && (bVelocidadInicial && bTiempoTotal)) {
                    velocidadInicial = Double.parseDouble(sVelocidadInicial);
                    tiempoTotal = Double.parseDouble(sTiempoTotal);

                    object.setIniVelocity(velocidadInicial);
                    object.setTotalTime(tiempoTotal);

                    object.fnCalcGravity4();

                    gravedad = object.getGravity();
                    sGravedad = String.valueOf(gravedad);
                    bGravedad = true;
                }


                // Calcular gravedad metodo 5
                if (!bGravedad && (bVelocidadInicialX && bVelocidadInicial && bAngulo && bDistanciaMaxima)) {
                    velocidadInicialX = Double.parseDouble(sVelocidadInicialX);
                    velocidadInicial = Double.parseDouble(sVelocidadInicial);
                    angulo = Double.parseDouble(sAngulo);
                    distanciaMaxima = Double.parseDouble(sDistanciaMaxima);

                    object.setIniVelocityX(velocidadInicialX);
                    object.setIniVelocity(velocidadInicial);
                    object.setAngle(angulo);
                    object.setMaxDistance(distanciaMaxima);

                    object.fnCalcGravity5();

                    gravedad = object.getGravity();
                    sGravedad = String.valueOf(gravedad);
                    bGravedad = true;
                }

                // Calcular gravedad metodo 6
                if (!bGravedad && (bVelocidadInicial && bAngulo && bDistanciaMaxima)) {
                    velocidadInicial = Double.parseDouble(sVelocidadInicial);
                    angulo = Double.parseDouble(sAngulo);
                    distanciaMaxima = Double.parseDouble(sDistanciaMaxima);

                    object.setIniVelocity(velocidadInicial);
                    object.setAngle(angulo);
                    object.setMaxDistance(distanciaMaxima);

                    object.fnCalcGravity6();

                    gravedad = object.getGravity();
                    sGravedad = String.valueOf(gravedad);
                    bGravedad = true;
                }

                // Calcular tiempo subida metodo 1
                if (!bTiempoSubida && (bTiempoTotal)) {
                    tiempoTotal = Double.parseDouble(sTiempoTotal);

                    object.setTotalTime(tiempoTotal);

                    object.fnCalcTimeUp1();

                    tiempoSubida = object.getTimeUp();
                    sTiempoSubida = String.valueOf(tiempoSubida);
                    bTiempoSubida = true;
                }

                // Calcular tiempo subida metodo 2
                if (!bTiempoSubida && (bTiempoBajada)) {
                    tiempoBajdada = Double.parseDouble(sTiempoBajada);

                    object.setTotalTime(tiempoBajdada);

                    object.fnCalcTimeUp2();

                    tiempoSubida = object.getTimeUp();
                    sTiempoSubida = String.valueOf(tiempoSubida);
                    bTiempoSubida = true;
                }

                // Calcular tiempo subida metodo 3
                if (!bTiempoSubida && (bVelocidadInicialY && bGravedad)) {
                    velocidadInicialY = Double.parseDouble(sVelocidadInicialY);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setFinVelocityY(velocidadInicialY);
                    object.setGravity(gravedad);

                    object.fnCalcTimeUp3();

                    tiempoSubida = object.getTimeUp();
                    sTiempoSubida = String.valueOf(tiempoSubida);
                    bTiempoSubida = true;
                }

                // Calcular tiempo bajada metodo 1
                if (!bTiempoBajada && (bTiempoTotal)) {
                    tiempoTotal = Double.parseDouble(sTiempoTotal);

                    object.setTotalTime(tiempoTotal);

                    object.fnCalcTimeDown1();

                    tiempoBajdada = object.getTimeDown();
                    sTiempoBajada = String.valueOf(tiempoBajdada);
                    bTiempoBajada = true;
                }

                // Calcular tiempo bajada metodo 2
                if (!bTiempoBajada && (bTiempoSubida)) {
                    tiempoSubida = Double.parseDouble(sTiempoSubida);

                    object.setTimeUp(tiempoSubida);

                    object.fnCalcTimeDown2();

                    tiempoBajdada = object.getTimeDown();
                    sTiempoBajada = String.valueOf(tiempoBajdada);
                    bTiempoBajada = true;
                }

                // Calcular tiempo bajada metodo 3
                if (!bTiempoBajada && (bAlturaMaxima && bGravedad)) {
                    alturaMaxima = Double.parseDouble(sAlturaMaxima);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setMaxHeight(alturaMaxima);
                    object.setGravity(gravedad);

                    object.fnCalcTimeDown3();

                    tiempoBajdada = object.getTimeDown();
                    sTiempoBajada = String.valueOf(tiempoBajdada);
                    bTiempoBajada = true;
                }

                // Calcular tiempo total metodo 1
                if (!bTiempoTotal && (bTiempoSubida)) {
                    tiempoSubida = Double.parseDouble(sTiempoSubida);

                    object.setTimeUp(tiempoSubida);

                    object.fnCalcTotalTime1();

                    tiempoTotal = object.getTotalTime();
                    sTiempoTotal = String.valueOf(tiempoTotal);
                    bTiempoTotal = true;
                }

                // Calcular tiempo total metodo 2
                if (!bTiempoTotal && (bTiempoBajada)) {
                    tiempoBajdada = Double.parseDouble(sTiempoBajada);

                    object.setTimeDown(tiempoBajdada);

                    object.fnCalcTotalTime2();

                    tiempoTotal = object.getTotalTime();
                    sTiempoTotal = String.valueOf(tiempoTotal);
                    bTiempoTotal = true;
                }

                // Calcular tiempo total metodo 3
                if (!bTiempoTotal && (bAlturaMaxima && bVelocidadInicialX)) {
                    alturaMaxima = Double.parseDouble(sAlturaMaxima);
                    velocidadInicialX = Double.parseDouble(sVelocidadInicialX);

                    object.setMaxHeight(alturaMaxima);
                    object.setIniVelocityX(velocidadInicialX);

                    object.fnCalcTotalTime3();

                    tiempoTotal = object.getTotalTime();
                    sTiempoTotal = String.valueOf(tiempoTotal);
                    bTiempoTotal = true;
                }

                // Calcular tiempo total metodo 4
                if (!bTiempoTotal && (bVelocidadInicialY && bGravedad)) {
                    velocidadInicialY = Double.parseDouble(sVelocidadInicialY);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setIniVelocityY(velocidadInicialY);
                    object.setGravity(gravedad);

                    object.fnCalcTotalTime4();

                    tiempoTotal = object.getTotalTime();
                    sTiempoTotal = String.valueOf(tiempoTotal);
                    bTiempoTotal = true;
                }

                // Calcular Altura maxima
                if (!bAlturaMaxima && (bVelocidadInicialY && bGravedad)) {
                    velocidadInicialY = Double.parseDouble(sVelocidadInicialY);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setGravity(gravedad);
                    object.setIniVelocityY(velocidadInicialY);

                    object.fnCalcMaxHeight1();

                    alturaMaxima = object.getMaxHeight();
                    sAlturaMaxima = String.valueOf(alturaMaxima);
                    bAlturaMaxima = true;
                }

                // Calcular distancia maxima metodo 1
                if (!bDistanciaMaxima && (bVelocidadInicialX && bTiempoTotal)) {
                    velocidadInicialX = Double.parseDouble(sVelocidadInicialX);
                    tiempoTotal = Double.parseDouble(sTiempoTotal);

                    object.fnCalcMaxDistance1();

                    distanciaMaxima = object.getMaxDistance();
                    sDistanciaMaxima = String.valueOf(distanciaMaxima);
                    bDistanciaMaxima = true;
                }

                // Calcular Angulo metodo 1
                if (!bAngulo && (bVelocidadInicialX && bVelocidadInicial)) {
                    velocidadInicialX = Double.parseDouble(sVelocidadInicialX);
                    velocidadInicial = Double.parseDouble(sVelocidadInicial);

                    object.setIniVelocity(velocidadInicial);
                    object.setIniVelocityX(velocidadInicialX);

                    object.fnCalcAngle1();

                    angulo = object.getAngle();
                    sAngulo = String.valueOf(angulo);
                    bAngulo = true;
                }

                // Calcular Angulo metodo 2
                if (!bAngulo && (bVelocidadInicialY && bVelocidadInicial)) {
                    velocidadInicialY = Double.parseDouble(sVelocidadInicialY);
                    velocidadInicial = Double.parseDouble(sVelocidadInicial);

                    object.setIniVelocity(velocidadInicial);
                    object.setIniVelocityY(velocidadInicialY);

                    object.fnCalcAngle2();

                    angulo = object.getAngle();
                    sAngulo = String.valueOf(angulo);
                    bAngulo = true;
                }

                // Calcular Angulo metodo 3
                if (!bAngulo && (bDistanciaMaxima && bVelocidadInicial && bGravedad && bVelocidadInicialX)) {
                    velocidadInicialX = Double.parseDouble(sVelocidadInicialX);
                    velocidadInicial = Double.parseDouble(sVelocidadInicial);
                    distanciaMaxima = Double.parseDouble(sDistanciaMaxima);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setIniVelocity(velocidadInicial);
                    object.setIniVelocityX(velocidadInicialX);
                    object.setMaxDistance(distanciaMaxima);
                    object.setGravity(gravedad);

                    object.fnCalcAngle3();

                    angulo = object.getAngle();
                    sAngulo = String.valueOf(angulo);
                    bAngulo = true;
                }

                // Calcular Angulo metodo 4
                if (!bAngulo && (bDistanciaMaxima && bGravedad)) {
                    distanciaMaxima = Double.parseDouble(sDistanciaMaxima);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setGravity(gravedad);
                    object.setMaxDistance(distanciaMaxima);

                    object.fnCalcAngle4();

                    angulo = object.getAngle();
                    sAngulo = String.valueOf(angulo);
                    bAngulo = true;
                }

                // Calcular Velocidad Inicial metodo 1
                if (!bVelocidadInicial && (bVelocidadInicialX && bAngulo)) {
                    velocidadInicialX = Double.parseDouble(sVelocidadInicialX);
                    angulo = Double.parseDouble(sAngulo);

                    object.setAngle(angulo);
                    object.setIniVelocityX(velocidadInicialX);

                    object.fnCalcIniVelocity1();

                    velocidadInicial = object.getIniVelocity();
                    sVelocidadInicial = String.valueOf(velocidadInicial);
                    bVelocidadInicial = true;
                }

                // Calcular Velocidad Inicial metodo 2
                if (!bVelocidadInicial && (bVelocidadInicialY && bAngulo)) {
                    velocidadInicialY = Double.parseDouble(sVelocidadInicialY);
                    angulo = Double.parseDouble(sAngulo);

                    object.setAngle(angulo);
                    object.setIniVelocityY(velocidadInicialY);

                    object.fnCalcIniVelocity2();

                    velocidadInicial = object.getIniVelocity();
                    sVelocidadInicial = String.valueOf(velocidadInicial);
                    bVelocidadInicial = true;
                }

                // Calcular Velocidad Inicial metodo 3
                if (!bVelocidadInicial && (bVelocidadInicialX && bAngulo && bGravedad && bDistanciaMaxima)) {
                    velocidadInicialX = Double.parseDouble(sVelocidadInicialX);
                    angulo = Double.parseDouble(sAngulo);
                    gravedad = Double.parseDouble(sGravedad);
                    distanciaMaxima = Double.parseDouble(sDistanciaMaxima);

                    object.setAngle(angulo);
                    object.setIniVelocityX(velocidadInicialX);
                    object.setGravity(gravedad);
                    object.setMaxDistance(distanciaMaxima);

                    object.fnCalcIniVelocity3();

                    velocidadInicial = object.getIniVelocity();
                    sVelocidadInicial = String.valueOf(velocidadInicial);
                    bVelocidadInicial = true;
                }

                // Calcular Velocidad Inicial metodo 4
                if (!bVelocidadInicial && (bAngulo && bGravedad && bDistanciaMaxima)) {
                    angulo = Double.parseDouble(sAngulo);
                    gravedad = Double.parseDouble(sGravedad);
                    distanciaMaxima = Double.parseDouble(sDistanciaMaxima);

                    object.setAngle(angulo);
                    object.setGravity(gravedad);
                    object.setMaxDistance(distanciaMaxima);

                    object.fnCalcIniVelocity4();

                    velocidadInicial = object.getIniVelocity();
                    sVelocidadInicial = String.valueOf(velocidadInicial);
                    bVelocidadInicial = true;
                }

                // Calcular velocidad inicial en X metodo 1
                if (!bVelocidadInicialX && (bVelocidadInicial && bAngulo)) {
                    velocidadInicial = Double.parseDouble(sVelocidadInicial);
                    angulo = Double.parseDouble(sAngulo);

                    object.setIniVelocity(velocidadInicial);
                    object.setAngle(angulo);

                    object.fnCalcIniVelocityX1();

                    velocidadInicialX = object.getIniVelocityX();
                    sVelocidadInicialX = String.valueOf(velocidadInicialX);
                    bVelocidadInicialX = true;
                }

                // Calcular velocidad inicial en X metodo 2
                if (!bVelocidadInicialX && (bDistanciaMaxima && bTiempoTotal)) {
                    tiempoTotal = Double.parseDouble(sTiempoTotal);
                    distanciaMaxima = Double.parseDouble(sDistanciaMaxima);

                    object.setTotalTime(tiempoTotal);
                    object.setMaxDistance(distanciaMaxima);

                    object.fnCalcIniVelocityX2();

                    velocidadInicialX = object.getIniVelocityX();
                    sVelocidadInicialX = String.valueOf(velocidadInicialX);
                    bVelocidadInicialX = true;
                }

                // Calcular velocidad inicial en X metodo 3
                if (!bVelocidadInicialX && (bDistanciaMaxima && bVelocidadInicial && bAngulo && bGravedad)) {
                    distanciaMaxima = Double.parseDouble(sDistanciaMaxima);
                    velocidadInicial = Double.parseDouble(sVelocidadInicial);
                    angulo = Double.parseDouble(sAngulo);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setGravity(gravedad);
                    object.setMaxDistance(distanciaMaxima);
                    object.setAngle(angulo);
                    object.setIniVelocity(velocidadInicial);

                    object.fnCalcIniVelocityX3();

                    velocidadInicialX = object.getIniVelocityX();
                    sVelocidadInicialX = String.valueOf(velocidadInicialX);
                    bVelocidadInicialX = true;
                }

                // Calcular velocidad inicial en Y metodo 1
                if (!bVelocidadInicialY && (bVelocidadInicial && bAngulo)) {
                    angulo = Double.parseDouble(sAngulo);
                    velocidadInicial = Double.parseDouble(sVelocidadInicial);

                    object.setAngle(angulo);
                    object.setIniVelocity(velocidadInicial);

                    object.fnCalcIniVelocityY1();

                    velocidadInicialY = object.getIniVelocityY();
                    sVelocidadInicialY = String.valueOf(velocidadInicialY);
                    bVelocidadInicialY = true;
                }

                // Calcular velocidad inicial en Y metodo 2
                if (!bVelocidadInicialY && (bAlturaMaxima && bGravedad)) {
                    alturaMaxima = Double.parseDouble(sAlturaMaxima);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setMaxHeight(alturaMaxima);
                    object.setGravity(gravedad);

                    object.fnCalcIniVelocityY2();

                    velocidadInicialY = object.getIniVelocityY();
                    sVelocidadInicialY = String.valueOf(velocidadInicialY);
                    bVelocidadInicialY = true;
                }

                // Calcular velocidad inicial en Y metodo 3
                if (!bVelocidadInicialY && (bTiempoSubida && bGravedad)) {
                    tiempoSubida = Double.parseDouble(sTiempoSubida);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setTimeUp(tiempoSubida);
                    object.setGravity(gravedad);

                    object.fnCalcIniVelocityY3();

                    velocidadInicialY = object.getIniVelocityY();
                    sVelocidadInicialY = String.valueOf(velocidadInicialY);
                    bVelocidadInicialY = true;
                }

                // Calcular velocidad inicial en Y metodo 4
                if (!bVelocidadInicialY && (bTiempoTotal && bGravedad)) {
                    tiempoTotal = Double.parseDouble(sTiempoTotal);
                    gravedad = Double.parseDouble(sGravedad);

                    object.setTotalTime(tiempoTotal);
                    object.setGravity(gravedad);

                    object.fnCalcIniVelocityY4();

                    velocidadInicialY = object.getIniVelocityY();
                    sVelocidadInicialY = String.valueOf(velocidadInicialY);
                    bVelocidadInicialY = true;
                }

                if (bVelocidadInicialY && bVelocidadInicialX && bVelocidadInicial && bAngulo && bDistanciaMaxima && bAlturaMaxima && bTiempoTotal && bTiempoBajada && bTiempoSubida && bGravedad)
                    bTodoCorrecto = true;

            } while (!bTodoCorrecto);

            alturaMaxima = Double.parseDouble(sAlturaMaxima);
            distanciaMaxima = Double.parseDouble(sDistanciaMaxima);
            angulo = Double.parseDouble(sAngulo);
            gravedad = Double.parseDouble(sGravedad);
            tiempoBajdada = Double.parseDouble(sTiempoBajada);
            tiempoSubida = Double.parseDouble(sTiempoSubida);
            tiempoTotal = Double.parseDouble(sTiempoTotal);
            velocidadInicial = Double.parseDouble(sVelocidadInicial);
            velocidadInicialX = Double.parseDouble(sVelocidadInicialX);
            velocidadInicialY = Double.parseDouble(sVelocidadInicialY);

            Intent intent = new Intent(this, RespuestasActivity.class);
            intent.putExtra(RespuestasActivity.KEY_RESPUESTA, RespuestasActivity.RESPUESTA_TIRO_PARABOLICO);
            intent.putExtra(RespuestasActivity.KEY_ALTURA_MAXIMA, alturaMaxima);
            intent.putExtra(RespuestasActivity.KEY_DISTANCIA_MAXIMA, distanciaMaxima);
            intent.putExtra(RespuestasActivity.KEY_ANGULO, angulo);
            intent.putExtra(RespuestasActivity.KEY_GRAVEDAD, gravedad);
            intent.putExtra(RespuestasActivity.KEY_TIEMPO_BAJADA, tiempoBajdada);
            intent.putExtra(RespuestasActivity.KEY_TIEMPO_SUBIDA, tiempoSubida);
            intent.putExtra(RespuestasActivity.KEY_TIEMPO_TOTAL, tiempoTotal);
            intent.putExtra(RespuestasActivity.KEY_VELOCIDAD_INICIAL, velocidadInicial);
            intent.putExtra(RespuestasActivity.KEY_VELOCIDAD_INICIALX, velocidadInicialX);
            intent.putExtra(RespuestasActivity.KEY_VELOCIDAD_INICIALY, velocidadInicialY);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                getWindow().setExitTransition(new Slide());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent, ActivityOptions
                        .makeSceneTransitionAnimation(this).toBundle());
            } else {
                startActivity(intent);
            }

        } else {
            ShowAlertDialog.newDialog("", getString(R.string.tag_tiro_parabolico_explicacion));
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