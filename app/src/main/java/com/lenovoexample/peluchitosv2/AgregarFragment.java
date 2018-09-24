package com.lenovoexample.peluchitosv2;


import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarFragment extends Fragment {
    private EditText eNombre, eCantidad, ePrecio;
    private Button bEnviar;
    private ContentValues dataBD;

    public AgregarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar, container, false);

        eNombre = view.findViewById(R.id.eNombre);
        eCantidad = view.findViewById(R.id.eCantidad);
        ePrecio = view.findViewById(R.id.ePrecio);
        bEnviar = view.findViewById(R.id.bEnviar);

        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eNombre.getText().toString();
                String cant = eCantidad.getText().toString();
                String val = ePrecio.getText().toString();
                if (name.equals("") || cant.equals("") || val.equals("")) {
                    Toast.makeText(getActivity(), "Ingrese Todos los datos", Toast.LENGTH_SHORT).show();
                }else{
                    ContactosSQLiteHelper nombre = new ContactosSQLiteHelper(getActivity(),"contactosBD",null,1);
                    SQLiteDatabase bd = nombre.getWritableDatabase();
                    dataBD = new ContentValues();
                    dataBD.put("nombre",name);
                    dataBD.put("cantidad",cant);
                    dataBD.put("precio",val);
                    bd.insert("contactos",null,dataBD);
                    Toast.makeText(getActivity(), "Peluche Agregado", Toast.LENGTH_SHORT).show();
                    cleanWidgets();
                }
            }
        });

        return view;
    }

    private void cleanWidgets() {
        eNombre.setText("");
        eCantidad.setText("");
        ePrecio.setText("");
    }
}