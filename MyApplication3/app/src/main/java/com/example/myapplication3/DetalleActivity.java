package com.example.myapplication3;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication3.adapter.RVAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetalleActivity extends AppCompatActivity {

    private List<Mascotas> mascotas;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        rv = (RecyclerView) findViewById(R.id.rvDetalle);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

     //   initializeData();
        initializeAdapter();

    }
/*
    private void initializeData() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascotas("Fefo", "6", R.drawable.descarga1));
        mascotas.add(new Mascotas("Hugo", "3", R.drawable.descarga2));
        mascotas.add(new Mascotas("Paco", "5", R.drawable.descarga3));
        mascotas.add(new Mascotas("Pepe", "2", R.drawable.descarga4));
    }
*/
    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(mascotas);
        rv.setAdapter(adapter);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void setSupportActionBar(Object supportActionBar) {
        this.setSupportActionBar(supportActionBar);
    }
}
