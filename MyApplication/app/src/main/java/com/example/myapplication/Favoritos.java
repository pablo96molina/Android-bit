package com.example.myapplication;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Favoritos {
    public void onClick(View View){
        Intent myIntent=new Intent(Favoritos.this,MainActivity.class);
        finish();

    }

    private void finish() {
    }
}