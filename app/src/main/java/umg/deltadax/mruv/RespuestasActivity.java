package umg.deltadax.mruv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class RespuestasActivity extends Activity {

    public static final String KEY_RESPUESTA = "key_respuesta";
    public static final String KEY_DISTANCIA = "key_distancia";
    public static final String KEY_VELCODIAD = "key_velocidad";
    public static final String KEY_TIEMPO = "key_tiempo";
    public static final String KEY_TIEMPO_SUBIDA = "key_tiempo_x";
    public static final String KEY_TIEMPO_BAJADA = "key_tiempo_y";
    public static final String KEY_TIEMPO_TOTAL = "key_tiempo_total";
    public static final String KEY_VELOCIDAD_INICIAL = "key_velocidad_inicial";
    public static final String KEY_VELOCIDAD_INICIALY = "key_velocidad_inicial_y";
    public static final String KEY_VELOCIDAD_INICIALX = "key_velocidad_inicial_x";
    public static final String KEY_VELOCIDAD_FINAL = "key_velocidad_final";
    public static final String KEY_ACELERACION = "key_aceleracion";
    public static final String KEY_ALTURA = "key_altura";
    public static final String KEY_ALTURA_MAXIMA = "altura_maxima";
    public static final String KEY_DISTANCIA_MAXIMA = "distancia_maxima";
    public static final String KEY_ANGULO = "key_angulo";
    public static final String KEY_GRAVEDAD = "key_gravedad";
    public static final String KEY_LOG = "key_log";

    public static final int RESPUESTA_MRUV = 1;
    public static final int RESPUESTA_MRU = 2;
    public static final int RESPUESTA_CAIDA_LIBRE = 3;
    public static final int RESPUESTA_TIRO_PARABOLICO = 4;
    public static final int RESPUESTA_TIRO_VERTICAL = 5;

    TextView tv_titulo, tv_mensaje, tv_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas);

        tv_titulo = (TextView) findViewById(R.id.tv_titulo);
        tv_mensaje = (TextView) findViewById(R.id.tv_mensaje);
        tv_log = (TextView) findViewById(R.id.tv_log);

        int respuesta = getIntent().getExtras().getInt(KEY_RESPUESTA);

        String mensaje = "", log = "Funciones utilizadas para resolver el problema: \n";

        Double distancia = 0.0, tiempo = 0.0, velocidad = 0.0, aceleracion = 0.0, velocidad_inicial = 0.0, velocidad_final = 0.0, altura = 0.0, gravedad = 0.0,
                tiempo_subida, tiempo_bajada, tiempo_total, velocidad_inicial_y, velocidad_inicial_x, altura_maxima, distancia_maxima, angulo;

        switch (respuesta) {
            case RESPUESTA_MRU:
                tv_titulo.setText(getResources().getText(R.string.tag_mru_titulo));
                distancia = getIntent().getExtras().getDouble(KEY_DISTANCIA);
                velocidad = getIntent().getExtras().getDouble(KEY_VELCODIAD);
                tiempo = getIntent().getExtras().getDouble(KEY_TIEMPO);
                log += getIntent().getExtras().getString(KEY_LOG);

                mensaje += "Tiempo: " + tiempo;
                mensaje += "\n";
                mensaje += "Distancia: " + distancia;
                mensaje += "\n";
                mensaje += "Velocidad: " + velocidad;


                tv_mensaje.setText(mensaje);
                break;

            case RESPUESTA_MRUV:
                tv_titulo.setText(getResources().getText(R.string.tag_mruv_titulo));

                distancia = getIntent().getExtras().getDouble(KEY_DISTANCIA);
                tiempo = getIntent().getExtras().getDouble(KEY_TIEMPO);
                aceleracion = getIntent().getExtras().getDouble(KEY_ACELERACION);
                velocidad_inicial = getIntent().getExtras().getDouble(KEY_VELOCIDAD_INICIAL);
                velocidad_final = getIntent().getExtras().getDouble(KEY_VELOCIDAD_FINAL);
                log += getIntent().getExtras().getString(KEY_LOG);

                mensaje += "Tiempo: " + tiempo;
                mensaje += "\n";
                mensaje += "Distancia: " + distancia;
                mensaje += "\n";
                mensaje += "Aceleracion: " + aceleracion;
                mensaje += "\n";
                mensaje += "Velocidad inicial: " + velocidad_inicial;
                mensaje += "\n";
                mensaje += "Velocidad final: " + velocidad_final;

                tv_mensaje.setText(mensaje);
                break;

            case RESPUESTA_CAIDA_LIBRE:
                tv_titulo.setText(getResources().getText(R.string.tag_titulo_caida_libre));

                altura = getIntent().getExtras().getDouble(KEY_ALTURA);
                tiempo = getIntent().getExtras().getDouble(KEY_TIEMPO);
                gravedad = getIntent().getExtras().getDouble(KEY_GRAVEDAD);
                velocidad_inicial = getIntent().getExtras().getDouble(KEY_VELOCIDAD_INICIAL);
                velocidad_final = getIntent().getExtras().getDouble(KEY_VELOCIDAD_FINAL);
                log += getIntent().getExtras().getString(KEY_LOG);

                mensaje += "Tiempo: " + tiempo;
                mensaje += "\n";
                mensaje += "Altura: " + altura;
                mensaje += "\n";
                mensaje += "Gravedad: " + gravedad;
                mensaje += "\n";
                mensaje += "Velocidad inicial: " + velocidad_inicial;
                mensaje += "\n";
                mensaje += "Velocidad final: " + velocidad_final;

                tv_mensaje.setText(mensaje);
                break;


            case RESPUESTA_TIRO_PARABOLICO:
                tv_titulo.setText(getResources().getText(R.string.tag_tiro_parabolico_btn));

                angulo = getIntent().getExtras().getDouble(KEY_ANGULO);
                altura_maxima = getIntent().getExtras().getDouble(KEY_ALTURA_MAXIMA);
                distancia_maxima = getIntent().getExtras().getDouble(KEY_DISTANCIA_MAXIMA);
                gravedad = getIntent().getExtras().getDouble(KEY_GRAVEDAD);
                tiempo_bajada = getIntent().getExtras().getDouble(KEY_TIEMPO_BAJADA);
                tiempo_subida = getIntent().getExtras().getDouble(KEY_TIEMPO_SUBIDA);
                tiempo_total = getIntent().getExtras().getDouble(KEY_TIEMPO_TOTAL);
                velocidad_inicial = getIntent().getExtras().getDouble(KEY_VELOCIDAD_INICIAL);
                velocidad_inicial_x = getIntent().getExtras().getDouble(KEY_VELOCIDAD_INICIALX);
                velocidad_inicial_y = getIntent().getExtras().getDouble(KEY_VELOCIDAD_INICIALY);
                log += getIntent().getExtras().getString(KEY_LOG);

                mensaje += "Angulo: " + angulo;
                mensaje += "\n";
                mensaje += "Gravedad: " + gravedad;
                mensaje += "\n";
                mensaje += "Tiempo Subida: " + tiempo_subida;
                mensaje += "\n";
                mensaje += "Tiempo Bajada: " + tiempo_bajada;
                mensaje += "\n";
                mensaje += "Tiempo Total: " + tiempo_total;
                mensaje += "\n";
                mensaje += "Altura Maxima: " + altura_maxima;
                mensaje += "\n";
                mensaje += "Distancia Maxima: " + distancia_maxima;
                mensaje += "\n";
                mensaje += "Velocidad Inicial: " + velocidad_inicial;
                mensaje += "\n";
                mensaje += "Velocidad Inicial en X: " + velocidad_inicial_x;
                mensaje += "\n";
                mensaje += "Velocidad Inicial en Y: " + velocidad_inicial_y;
                mensaje += "\n";

                tv_mensaje.setText(mensaje);
                break;

            case RESPUESTA_TIRO_VERTICAL:

                tv_titulo.setText(getResources().getText(R.string.tag_tiro_vertical));

                altura = getIntent().getExtras().getDouble(KEY_ALTURA);
                tiempo = getIntent().getExtras().getDouble(KEY_TIEMPO);
                gravedad = getIntent().getExtras().getDouble(KEY_GRAVEDAD);
                velocidad_inicial = getIntent().getExtras().getDouble(KEY_VELOCIDAD_INICIAL);
                velocidad_final = getIntent().getExtras().getDouble(KEY_VELOCIDAD_FINAL);
                log += getIntent().getExtras().getString(KEY_LOG);

                mensaje += "Tiempo: " + tiempo;
                mensaje += "\n";
                mensaje += "Altura: " + altura;
                mensaje += "\n";
                mensaje += "Gravedad: " + gravedad;
                mensaje += "\n";
                mensaje += "Velocidad inicial: " + velocidad_inicial;
                mensaje += "\n";
                mensaje += "Velocidad final: " + velocidad_final;

                tv_mensaje.setText(mensaje);

                break;
        }

        tv_log.setText(log);
    }

}
