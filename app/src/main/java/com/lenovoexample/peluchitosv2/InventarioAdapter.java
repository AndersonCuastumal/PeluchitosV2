package com.lenovoexample.peluchitosv2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class InventarioAdapter extends RecyclerView.Adapter<InventarioAdapter.ViewHolder> {

    ArrayList<Contacto> listDatos;


    public InventarioAdapter(ArrayList<Contacto> listDatos) { this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contacto contacto = listDatos.get(position);
        holder.bindContactos(contacto);
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tNombre, tCantidad, tPrecio;

        public ViewHolder(View itemView) {
            super(itemView);
            tNombre = itemView.findViewById(R.id.tNombre);
            tCantidad = itemView.findViewById(R.id.tCantidad);
            tPrecio = itemView.findViewById(R.id.tPrecio);
        }

        public void bindContactos(Contacto contacto) {
            tNombre.setText(contacto.getNombre());
            tCantidad.setText(contacto.getCantidad());
            tPrecio.setText(contacto.getCantidad());
        }
    }
}