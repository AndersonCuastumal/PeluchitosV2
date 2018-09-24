package com.lenovoexample.peluchitosv2;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarFragment extends Fragment {
    private EditText eNombre;
    private TextView tDatos;
    private Button bEnviar;

    public BuscarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscar, container, false);
        eNombre = view.findViewById(R.id.eNombre);
        tDatos = view.findViewById(R.id.tDatos);
        bEnviar = view.findViewById(R.id.bEnviar);

        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                name = eNombre.getText().toString();
                ContactosSQLiteHelper nombre = new ContactosSQLiteHelper(getActivity(),"contactosBD",null,1);
                SQLiteDatabase bd = nombre.getWritableDatabase();

                if(name.equals("")) {
                    Toast.makeText(getActivity(), "Ingresar Datos", Toast.LENGTH_SHORT).show();
                }else {
                    Cursor c = bd.rawQuery(
                            "SELECT * FROM contactos WHERE nombre = '"+name+"'",
                            null);
                    if (c.moveToFirst()) {
                            tDatos.setText("Nombre: " + c.getString(1) + "\nCantidad: "
                                + c.getString(2) + "\nPrecio: " + c.getString(3));
                        cleanWidgets();
                    } else {
                        Toast.makeText(getActivity(), "Dato no encontrado", Toast.LENGTH_SHORT).show();
                        cleanBar();
                        cleanWidgets();
                    }
                }
            }
        });
        return view;
    }

    private void cleanBar() {
        tDatos.setText("");
    }

    private void cleanWidgets() {
        eNombre.setText("");
    }
}
