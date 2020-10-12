package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO_SOLICITUD_HABILITAR_BLUETOOTH = 1 ;
    private List<Mascotas> mascotas;
    private RecyclerView rv;
    private Context context;
    private Object activity;

    public void habilitarBluetooth(View v){
        solicitarPermiso();
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null){
            Toast.makeText(context, "Tu dispositivo no tiene Bluethooth", Toast.LENGTH_SHORT).show();
        }
        if (!mBluetoothAdapter.isEnabled()){
            Intent habilitarBluethoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE) ;
            startActivityForResult(habilitarBluethoothIntent, CODIGO_SOLICITUD_HABILITAR_BLUETOOTH);
        }
    }

    public boolean chequearStatusPermiso(){
        int resultado = ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH);
        if (resultado == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        //new activity() = (activity) this;
        
        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        rv = (RecyclerView) findViewById(R.id.rvMascotas);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Tomar fotografía", Snackbar.LENGTH_LONG)
                        .setAction("Acción", null).show();
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascotas("Fefo", "6", R.drawable.descarga1));
        mascotas.add(new Mascotas("Hugo", "3", R.drawable.descarga2));
        mascotas.add(new Mascotas("Paco", "5", R.drawable.descarga3));
        mascotas.add(new Mascotas("Pepe", "2", R.drawable.descarga4));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(mascotas);
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_rating) {
            Intent intent = new Intent(this, DetalleActivity.class);

            startActivity(intent);
            return true;
        }

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
public void solicitarPermiso (){
    Activity activity = this;
    if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.BLUETOOTH));

}

   
}