package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    public ContactoAdaptador(ArrayList<Contacto> contactos){
        this.contactos=contactos;
    }
    ArrayList<Contacto> contactos;
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
//pasamos nuestra lista de contacto a cada elemento
        Contacto contacto = contactos.get(position);
        contactoViewHolder.foto.setImageResource(contacto.getFoto());
        contactoViewHolder.nombre.setText(contacto.getNombre());
        contactoViewHolder.telefono.setText(contacto.getTelefono());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        public TextView telefono;
        private ImageView foto;
        private TextView    nombre;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
        }
    }

}
