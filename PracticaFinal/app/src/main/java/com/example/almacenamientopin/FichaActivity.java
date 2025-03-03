package com.example.almacenamientopin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FichaActivity extends AppCompatActivity {

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha);

        TextView txtNombre = (TextView) findViewById(R.id.nombre);
        TextView txtApe1 = (TextView) findViewById(R.id.apellido1);
        TextView txtApe2 = (TextView) findViewById(R.id.apellido2);

        bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        String apellido1 = bundle.getString("ape1");
        String apellido2 = bundle.getString("ape2");


        txtNombre.setText(nombre);
        txtApe1.setText(apellido1);
        txtApe2.setText(apellido2);
    }
}