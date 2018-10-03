package com.example.admin.actiontask;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class FirstScreen extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_screen);


        RotateStartView();
       // startMainActivity();


    }

    private void RotateStartView (){

        RotateAnimation rotate;


            DisplayMetrics metrics = this.getResources().getDisplayMetrics();
            int width = metrics.widthPixels / 2;
            int height = metrics.heightPixels/2;

            rotate = new RotateAnimation(0, 360, width, height);
            rotate.setDuration(5000);
            //rotate.setRepeatCount(1);

            final ImageView imageView = findViewById(R.id.imageView);



            imageView.startAnimation(rotate);


            //Toast.makeText(getApplicationContext(),rotate.hasEnded()+"",Toast.LENGTH_LONG).show();


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
}
