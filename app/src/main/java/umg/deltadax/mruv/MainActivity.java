package umg.deltadax.mruv;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button btn_mru, btn_mruv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_main);

        btn_mru = (Button) findViewById(R.id.btn_mru);
        btn_mru.setOnClickListener(this);
        btn_mruv = (Button) findViewById(R.id.btn_mruv);
        btn_mruv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setExitTransition(new Explode());


        switch (v.getId()) {
            case R.id.btn_mru:
                Intent mru = new Intent(this, MruActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(mru, ActivityOptions
                            .makeSceneTransitionAnimation(this).toBundle());
                } else {
                    startActivity(mru);
                }
                break;

            case R.id.btn_mruv:
                Intent mruv = new Intent(this, MruvActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(mruv, ActivityOptions
                            .makeSceneTransitionAnimation(this).toBundle());
                } else {
                    startActivity(mruv);
                }
                break;
        }
    }
}
