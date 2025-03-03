package com.example.almacenamientopin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class PinCheckActivity extends AppCompatActivity {

    private String sharedPrefFile =
            "com.example.almacenamientopin";

    // Variables
    public static String PIN = "";
    private String usuario;

    private SharedPreferences mPreferences;

    public TextView pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_check);

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        TextView tv=findViewById(R.id.nombreUsuario);
        usuario="Hola, "+mPreferences.getString("nombreusuario","NULL");
        tv.setText(usuario);
        //Log.d("ERROR", "Estoy en check");
        // Solución
        pantalla = findViewById(R.id.calculator_screen) ;

        // Números
        Button btnNumero1 =  findViewById(R.id.numero1);
        Button btnNumero2 =  findViewById(R.id.numero2);
        Button btnNumero3 =  findViewById(R.id.numero3);
        Button btnNumero4 =  findViewById(R.id.numero4);
        Button btnNumero5 =  findViewById(R.id.numero5);
        Button btnNumero6 =  findViewById(R.id.numero6);
        Button btnNumero7 =  findViewById(R.id.numero7);
        Button btnNumero8 =  findViewById(R.id.numero8);
        Button btnNumero9 =  findViewById(R.id.numero9);
        Button btnNumero0 =  findViewById(R.id.numero0);

        // Funcionalidades
        Button btnReiniciar =  findViewById(R.id.reiniciar);
        Button btnBorrarNumero =  findViewById(R.id.borrarNumero);
        Button btnAvanzar =  findViewById(R.id.avanzar);

        btnNumero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("1");
            }
        });

        btnNumero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("2");
            }
        });

        btnNumero3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("3");
            }
        });

        btnNumero4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("4");
            }
        });

        btnNumero5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("5");
            }
        });

        btnNumero6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("6");
            }
        });

        btnNumero7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("7");
            }
        });

        btnNumero8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("8");
            }
        });

        btnNumero9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("9");
            }
        });

        btnNumero0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                introducirNumero("0");
            }
        });

        btnBorrarNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                if (!PIN.isEmpty()) {
                    PIN = PIN.substring(0, PIN.length()-1);
                    pantalla.setText(PIN);
                }
            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                PIN = "";
                pantalla.setText("");
            }
        });

        btnAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

                if (mPreferences.contains("pin")) {
                    String pinPreference = mPreferences.getString("pin", "NULL");

                    if (pinPreference.equals(PIN)) {
                        Intent intent=new Intent(PinCheckActivity.this, MenuActivity.class);
                        startActivity(intent);
                    } else {
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(PinCheckActivity.this,"PIN incorrecto", duration);
                        toast.show();
                    }
                }
            }
        });
    }

    public void introducirNumero(String numero) {

        if (PIN.length() < 4) {
            PIN += numero;
            pantalla.setText(PIN);
        }

    }
}