package com.lenovoexample.peluchitosv2;


import android.app.Activity;
import android.database.Cursor;
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
public class EliminarFragment extends Fragment {

    private EditText eNombre;
    private Button bEnviar;

    public EliminarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eliminar, container, false);
        eNombre = view.findViewById(R.id.eNombre);
        bEnviar = view.findViewById(R.id.bEnviar);


        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                name = eNombre.getText().toString();
                ContactosSQLiteHelper nombre = new ContactosSQLiteHelper(getActivity(),"contactosBD",null,1);
                SQLiteDatabase bd = nombre.getWritableDatabase();
                Cursor c = bd.rawQuery(
                        "SELECT * FROM contactos WHERE nombre = '"+name+"'",
                        null);
                if (name.equals("")) {
                    Toast.makeText(getActivity(), "Ingresar los datos", Toast.LENGTH_SHORT).show();
                }else {
                    if (c.moveToFirst()) {
                        bd.delete("contactos",
                                "nombre = '"+name+"'",
                                null);
                        Toast.makeText(getActivity(), "Elemento Eliminado", Toast.LENGTH_SHORT).show();
                        cleanWidgets();
                    } else {
                        Toast.makeText(getActivity(), "Dato no encontrado", Toast.LENGTH_SHORT).show();
                        cleanWidgets();
                    }
                }
            }
        });
        return view;
    }

    private void cleanWidgets() {
        eNombre.setText("");
    }
}
