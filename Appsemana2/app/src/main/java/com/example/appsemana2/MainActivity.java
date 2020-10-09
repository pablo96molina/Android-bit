package com.example.appsemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editext, editext2, editext3, editext4;
    DatePicker fecha;
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editext = findViewById(R.id.editTextName);
        fecha = findViewById(R.id.datePickerBirthday);
        editext2 = findViewById(R.id.editTextMail);
        editext3 = findViewById(R.id.editTextTelefono);
        editext4 = findViewById(R.id.editTextDescripcion);
        siguiente = findViewById(R.id.buttonSiguiente);

        editext.setText(getIntent().getStringExtra("Nombre"));
        editext2.setText(getIntent().getStringExtra("Mail"));
        editext.setText(getIntent().getStringExtra("Telefono"));
        editext4.setText(getIntent().getStringExtra("Descripcion"));
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra("InfoNombre",editext.getText().toString());
                intent.putExtra("InfoFecha",fecha.toString());
                intent.putExtra("InfoTelefono",editext3.getText().toString());
                intent.putExtra("InfoEmail",editext2.getText().toString());
                intent.putExtra("InfoDescripcion",editext4.getText().toString());
                startActivity(intent);
            }
        });
    }
}
