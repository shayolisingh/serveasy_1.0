package com.example.new_serveasy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;





public class Splash_Screen_Activity extends Activity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash_screen);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash_Screen_Activity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
}
