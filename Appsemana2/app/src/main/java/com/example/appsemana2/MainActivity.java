package com.example.appsemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //contactos = new ArrayList<Contacto>();

       // contactos.add(new Contacto("Pablo", "pablo@ejemplo.com", "0800 8888", "Descripcion contacto", "08-10-2020"));

    }
    
    Intent confirmarDatos = new Intent(this, ConfirmarDatos.class);
    public void setConfirmarDatos(Intent confirmarDatos) {
        this.confirmarDatos = confirmarDatos;
    }


}
