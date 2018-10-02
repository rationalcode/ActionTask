package com.example.admin.actiontask;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.imageView);

        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, FirstScreen.class);
                startActivity(i);

                Animation rotateAnimation = new RotateAnimation(0,180);
                imageView.startAnimation(rotateAnimation);

                // close this activity
                finish();
            }
        }, 5*1000); // wait for 5 seconds
    }
}
