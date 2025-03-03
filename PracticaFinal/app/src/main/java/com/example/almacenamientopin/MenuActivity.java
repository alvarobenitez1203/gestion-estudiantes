package com.example.almacenamientopin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private String sharedPrefFile =
            "com.example.almacenamientopin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        TextView tv= findViewById(R.id.nombreUsu);
        String usuario = mPreferences.getString("nombreusuario", "NULL");
        String texto="Hola, "+usuario;
        tv.setText(texto);

        Button botonAlta=findViewById(R.id.buttonAlta);
        Button botonListar=findViewById(R.id.buttonListar);

        botonAlta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                Intent i=new Intent(MenuActivity.this, FormularioActivity.class);
                startActivity(i);
            }
        });

        botonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                Intent i=new Intent(MenuActivity.this, ListaAlumnosActivity.class);
                startActivity(i);
            }
        });



    }
}