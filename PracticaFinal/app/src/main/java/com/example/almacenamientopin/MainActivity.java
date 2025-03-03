package com.example.almacenamientopin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private String sharedPrefFile =
            "com.example.almacenamientopin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imagen=findViewById(R.id.imageView);
        imagen.setImageResource(R.drawable.logo_app);

        SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        /*BORRAR USUARIO*/
        //SharedPreferences.Editor edit = mPreferences.edit();
        //edit.clear().apply();
        
        String usuario = mPreferences.getString("nombreusuario", "NULL");
        String pin=mPreferences.getString("pin", "NULL");
        if (usuario.equals("NULL") || pin.equals("NULL")) {
            Intent intent = new Intent(MainActivity.this, AltaUsuarioActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, PinCheckActivity.class);
            startActivity(intent);
        }


    }
}