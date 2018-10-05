package com.example.admin.actiontask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.internal.operators.completable.CompletableFromAction;

public class FirstScreen extends AppCompatActivity implements Runnable{

    private static final String TAG = "log" ;
    static float width;
    static float height;
    ImageView imageView;
    static RotateAnimation rotate;
    DisplayMetrics metrics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_screen);

        imageView = findViewById(R.id.imageView);

        width = imageView.getX()/2;
        height = imageView.getY()/2;
        metrics = this.getResources().getDisplayMetrics();


        Log.d(TAG, width+" "+height);

        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                RotateStartView(width,height);


            }

        });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });

        t1.start();
        t2.start();

        //RotateStartView();
        //startMainActivity();


    }

    private void RotateStartView (float width, float height){






//            int width = metrics.widthPixels / 2;
//            int height = metrics.heightPixels/2;

//            rotate = new RotateAnimation(0, 180, width,height);
//            rotate.setDuration(5000);
//            rotate.setInterpolator(new LinearInterpolator());


        final Animation rotate = AnimationUtils.loadAnimation(
                this, R.anim.rotate_action);


            imageView.startAnimation(rotate);

    }

    private void startMainActivity (){

        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override
            public void run() {



                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        },5000 ); // wait for 5 seconds

    }

    @Override
    public void run() {

    }
}
