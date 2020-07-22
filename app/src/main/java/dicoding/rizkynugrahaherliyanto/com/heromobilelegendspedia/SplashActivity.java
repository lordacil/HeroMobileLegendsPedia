package dicoding.rizkynugrahaherliyanto.com.heromobilelegendspedia;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.easyandroidanimations.library.BounceAnimation;

public class SplashActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    AnimationDrawable animationDrawable;
    private LinearLayout lv_loading;

    @Override.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        animationDrawable = (AnimationDrawable) linearLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

        lv_loading = (LinearLayout) findViewById(R.id.lv_loading);

        new BounceAnimation(lv_loading)
                .setBounceDistance(50)
                .setDuration(3000)
                .animate();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);

                finish();
            }
        }, 5000);
    }

    @Override
    protected void onPause(){
        super.onPause();

        if (animationDrawable != null && animationDrawable.isRunning()){
            animationDrawable.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (animationDrawable != null && !animationDrawable.isRunning()){
            animationDrawable.start();
        }
    }
}
