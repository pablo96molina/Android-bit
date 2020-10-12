package com.example.myapplication3.presentador;

import android.content.Context;

import com.example.myapplication3.Mascotas;
import com.example.myapplication3.adapter.RecyclerViewFragmentView;
import com.example.myapplication3.db.ConstructorMascotas;

import java.util.ArrayList;


public class RecyclerViewFragmentPresenter implements iRecyclerViewFragmentPresenter {
    private RecyclerViewFragmentView recyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascotas> mascotas;

    public RecyclerViewFragmentPresenter(RecyclerViewFragmentView recyclerViewFragmentView, Context context) {
        this.recyclerViewFragmentView = recyclerViewFragmentView;
        this.context = context;
    }

    @Override
    public void obtenerMascotasBaseDatos() {
    constructorMascotas = new ConstructorMascotas(context);
    mascotas = constructorMascotas.obtenerDatos();
    }

    @Override
    public void mostrarMascotasRV() {
    recyclerViewFragmentView.inicializarAdaptadorRV();
    }
}
