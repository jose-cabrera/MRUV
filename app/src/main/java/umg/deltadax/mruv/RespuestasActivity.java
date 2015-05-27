package umg.deltadax.mruv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas);
    }

}
