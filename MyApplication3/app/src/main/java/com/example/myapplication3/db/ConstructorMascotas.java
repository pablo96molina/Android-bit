package com.example.myapplication3.db;

import android.content.Context;

import com.example.myapplication3.Mascotas;
import com.example.myapplication3.R;

import java.util.ArrayList;

public class ConstructorMascotas {
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context=context;
    }
    public ArrayList<Mascotas> obtenerDatos(){
        ArrayList<Mascotas> mascotas = new ArrayList<>();
        mascotas.add(new Mascotas("Fefo", "6", R.drawable.descarga1, 5));
        mascotas.add(new Mascotas("Hugo", "3", R.drawable.descarga2, 6));
        mascotas.add(new Mascotas("Paco", "5", R.drawable.descarga3, 8));
        mascotas.add(new Mascotas("Pepe", "2", R.drawable.descarga4, 3));
        return mascotas;
    }
}
