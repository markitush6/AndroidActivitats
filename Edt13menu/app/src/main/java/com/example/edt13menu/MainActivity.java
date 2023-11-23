package com.example.edt13menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater manuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.mymenu_light, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int selectedItem = item.getItemId();
        if (selectedItem == R.id.bike) {
            Toast.makeText(this, "bike", Toast.LENGTH_SHORT).show();
            return true;
        } else if (selectedItem == R.id.settings) {
            Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }

}