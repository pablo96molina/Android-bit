package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editext;
    Button favorito;
    private List<Contacto> contactos;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);

    }




    private void initializeData() {
        contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.descarga1,"Pluto", "6", ));
        contactos.add(new Contacto(R.drawable.descarga2,"Guau", "6", ));
        contactos.add(new Contacto(R.drawable.descarga3,"Oliver", "6", ));
        contactos.add(new Contacto(R.drawable.descarga4,"Alex", "6", ));
        initializeData();
    }

    private void initializeAdapter() {
        ContactoAdaptador adapter = new ContactoAdaptador((ArrayList<Contacto>) contactos);
        rv.setAdapter(adapter);
        initializeAdapter();
    }



}