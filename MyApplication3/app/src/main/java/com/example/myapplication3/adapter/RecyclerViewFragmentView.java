package com.example.myapplication3.adapter;

import com.example.myapplication3.Mascotas;

import java.util.ArrayList;

public interface RecyclerViewFragmentView {
    void inicializarAdaptadorRV();

    Object crearAdaptador(ArrayList<Mascotas> mascotas);
}
