package umg.deltadax.mruv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class RespuestasActivity extends Activity {

    public static final String KEY_RESPUESTA = "key_respuesta";
    public static final String KEY_DISTANCIA = "key_distancia";
    public static final String KEY_VELCODIAD = "key_velocidad";
    public static final String KEY_TIEMPO = "key_tiempo";
    public static final String KEY_VELOCIDAD_INICIAL = "key_velocidad_inicial";
    public static final String KEY_VELOCIDAD_FINAL = "key_velocidad_final";
    public static final String KEY_ACELERACION = "key_aceleracion";

    public static final int RESPUESTA_MRUV = 1;
    public static final int RESPUESTA_MRU = 2;

    TextView tv_titulo, tv_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas);

        tv_titulo = (TextView) findViewById(R.id.tv_titulo);
        tv_mensaje = (TextView) findViewById(R.id.tv_mensaje);

        int respuesta = getIntent().getExtras().getInt(KEY_RESPUESTA);

        String mensaje = "";

        Double distancia = 0.0, tiempo = 0.0, velocidad = 0.0, aceleracion = 0.0, velocidad_inicial = 0.0, velocidad_final = 0.0;
        switch (respuesta) {
            case RESPUESTA_MRU:
                tv_titulo.setText(getResources().getText(R.string.tag_mru_titulo));
                distancia = getIntent().getExtras().getDouble(KEY_DISTANCIA);
                velocidad = getIntent().getExtras().getDouble(KEY_VELCODIAD);
                tiempo = getIntent().getExtras().getDouble(KEY_TIEMPO);

                mensaje += "Distancia: " + distancia;
                mensaje += "\n";
                mensaje += "Velocidad: " + velocidad;
                mensaje += "\n";
                mensaje += "Tiempo: " + tiempo;

                tv_mensaje.setText(mensaje);
                break;

            case RESPUESTA_MRUV:
                tv_titulo.setText(getResources().getText(R.string.tag_mruv_titulo));
                break;
        }
    }

}
