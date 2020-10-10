package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editext;
    Button favorito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Object contactos = new ArrayList<Contacto>();
        ((ArrayList) contactos).add(new Contacto(R.drawable.ic_launcher_background, "Pablo","0789","pablo@ejemplo"));
        editext = findViewById(R.id.Nombre);
    }

    editext.setString(getIntent().getStringExtra("Nombre"));

  favorito.setOnClickListener(new View.OnClickListener()
    private final Object v;

    {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Favoritos.class);
            intent.putExtra("InfoNombre",editext.getText().toString());
            startActivity(intent);
        }
    });
}