package com.example.edt10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btClickme;
    private ImageView img1;
    private ImageView img2;


    private static final String HOME_ACTIVITY_TAG = MainActivity.class.getSimpleName();



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator set = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.frontanimator);
                Animator set2 = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.backanimator);
                set.setTarget(v);
                set2.setTarget(v);
                AnimatorSet animationSet = new AnimatorSet();
                animationSet.playTogether(set, set2);
                animationSet.start();
            }
        });

        //Hook
       btClickme = (Button) findViewById(R.id.btClickme);

        Toast toast = Toast.makeText(getApplicationContext(),
                "onCreate method called",
                Toast.LENGTH_LONG);
        toast.show();

        showLog("Activity Created");
    }

    protected void onStart() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "onStart method called",
                Toast.LENGTH_LONG);
        toast.show();
        super.onStart();
        showLog("Activity started");
    }



    @Override
    protected void onRestart(){
        Toast toast = Toast.makeText(getApplicationContext(),
                "onRestart method called",
                Toast.LENGTH_LONG);
        toast.show();
        super.onRestart();//call to restart after onStop
        showLog("Activity restarted");
    }

    @Override
    protected void onResume() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "onResume method called",
                Toast.LENGTH_LONG);
        toast.show();
        super.onResume();
        showLog("Activity resumed");

    }


    @Override
    protected void onPause() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "onPause method called",
                Toast.LENGTH_LONG);
        toast.show();
        super.onPause();
        showLog("Activity paused");
    }

    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "onStop method called",
                Toast.LENGTH_LONG);
        toast.show();
        super.onStop();
        showLog("Activity stopped");
    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "onDestroy method called",
                Toast.LENGTH_LONG);
        toast.show();
        super.onDestroy();
        showLog("Activity is being destroyed");
    }
    private void showLog(String text){

        //Log.e(HOME_ACTIVITY_TAG, text);
        //Log.w(HOME_ACTIVITY_TAG, text);
        //Log.i(HOME_ACTIVITY_TAG, text);
        Log.d(HOME_ACTIVITY_TAG, text);
        //Log.v(HOME_ACTIVITY_TAG, text);

    }
    public void clickme(View view) {
        Intent intent = new Intent(MainActivity.this, SegonActivity.class);
        startActivity(intent);
    }

}