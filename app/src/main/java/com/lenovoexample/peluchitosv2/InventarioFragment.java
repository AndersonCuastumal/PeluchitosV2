package com.lenovoexample.peluchitosv2;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventarioFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Contacto> listContactos;
    InventarioAdapter inventarioAdapter;


    private TextView tDatos;




    public InventarioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventario, container, false);

        recyclerView = view.findViewById(R.id.recyclerId);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        listContactos = new ArrayList<>();

        inventarioAdapter = new InventarioAdapter(listContactos);
        recyclerView.setAdapter(inventarioAdapter);

        loadData();

        return view;
    }

    private void loadData() {

        ContactosSQLiteHelper contactosSQLiteHelper;
        SQLiteDatabase dbContactos;


        contactosSQLiteHelper = new ContactosSQLiteHelper(getActivity(),"contactosBD",null,1);

        dbContactos = contactosSQLiteHelper.getWritableDatabase();

        Cursor c = dbContactos.rawQuery(
                "SELECT * FROM contactos",
                null);
        if(c.moveToFirst()){
            do{
                Contacto contacto = new Contacto(
                        c.getInt(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3));
                listContactos.add(contacto);
            }while(c.moveToNext());
            inventarioAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(getContext(),"contacto no encontrado",Toast.LENGTH_SHORT).show();
        }

    }
}