package com.example.myapplication3.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication3.Mascotas;
import com.example.myapplication3.R;
import com.example.myapplication3.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

public class  RVAdapter extends RecyclerView.Adapter<RVAdapter.MascotaViewHolder> implements RecyclerViewFragmentView {
//private ArrayList<Mascotas> mascotas;
private  RVAdapter adapter;
private RecyclerViewFragmentPresenter presenter;

    @Override
    public void inicializarAdaptadorRV() {

    }

    @Override
    public Object crearAdaptador(ArrayList<Mascotas> mascotas) {
        return null;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder implements RecyclerViewFragmentView {
        CardView cv;
        TextView Nombre;
        TextView Rating;
        ImageView ImgFoto;
        TextView Likes;

        MascotaViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            Nombre = (TextView)itemView.findViewById(R.id.nombre);
            Rating = (TextView)itemView.findViewById(R.id.tvRatingCV);
            ImgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            Likes = (TextView) itemView.findViewById(R.id.likes);

        }

        @Override
        public void inicializarAdaptadorRV() {

        }

        @Override
        public Object crearAdaptador(ArrayList<Mascotas> mascotas) {
            return null;
        }
    }

    List<Mascotas> mascotas;

    public RVAdapter(List<Mascotas> mascotas){
        this.mascotas = (ArrayList<Mascotas>) mascotas;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_mascota, viewGroup, false);
        presenter = new RecyclerViewFragmentPresenter(this, v.getContext());
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int i) {
        mascotaViewHolder.Nombre.setText(mascotas.get(i).nombre);
        mascotaViewHolder.Rating.setText(mascotas.get(i).rating);
        mascotaViewHolder.Likes.setText(mascotas.get(i).likes);
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}

