package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Pair;

public class MainActivity extends AppCompatActivity {
    public int SPLASH_SCREEN = 4000;
    private ImageView imageView;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //hooks
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.Pedals);

            Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.rotate);
            animator.setTarget(imageView);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animator);
            animatorSet.start();

        
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // intent to start activity
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        Pair.create(imageView, "logo_image"),
                        Pair.create(textView, "logo_text"));
                startActivity(intent, options.toBundle());
            }
        };
        Handler h = new Handler(Looper.getMainLooper());
        h.postDelayed(r, SPLASH_SCREEN);
    }
}