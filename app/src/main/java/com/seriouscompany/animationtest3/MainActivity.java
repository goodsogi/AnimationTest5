package com.seriouscompany.animationtest3;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float dest; //각도
    float dest2; //알파값
    float dest3; //거리


    public void rotate(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if (imageView.getRotation() == 360) {
            dest = 0;
        } else {
            dest = 360;
        }


        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", dest);
        animator.setDuration(2000);
        animator.start();


    }

    public void group(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(imageView, "alpha", 0f);
        fadeOut.setDuration(2000);

        ObjectAnimator mover = ObjectAnimator.ofFloat(imageView, "translationX", -500f, 0f);
        mover.setDuration(2000);

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(imageView, "alpha",0f, 1f);
        fadeIn.setDuration(2000);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(mover).with(fadeIn).after(fadeOut);
        animatorSet.start();

    }

    public void fade(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if(imageView.getAlpha() > 0) {
            dest2 = 0;
        } else {
            dest2 = 1;
        }

        ObjectAnimator fade = ObjectAnimator.ofFloat(imageView, "alpha", dest2);
        fade.setDuration(2000);
        fade.start();



    }

    public void animate(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);

        Paint paint = new Paint();
        float measureTextCenter = paint.measureText(textView.getText().toString());



        if(textView.getX() < 0) {
            dest3 = 0;
        } else {

            dest3 = 0 - measureTextCenter;

        }

        Log.d("anitest3", "dest3: " + dest3 + " text length: " + measureTextCenter + " textview length: " + textView.getWidth() +" textview x: " + textView.getX());


        ObjectAnimator animator = ObjectAnimator.ofFloat(textView,"x",dest3);
        animator.setDuration(2000);
        animator.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
