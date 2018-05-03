package com.example.android.java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    Button rotar, trans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        rotar = (Button) findViewById(R.id.btnRotar);
        trans = (Button) findViewById(R.id.btnTrans);

        rotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotacion();
            }
        });

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transladar();
            }
        });
    }

    public void onButtonClick(View v) {
        Animation animation1 =
                AnimationUtils.loadAnimation(this, R.anim.grow);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        animation.setFillAfter(true);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setScaleX(2);
                imageView.setScaleY(2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        imageView.startAnimation(animation);
        imageView.startAnimation(animation1);
    }



    public void rotacion(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotacion);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }


    public void transladar(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.trans);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }
}