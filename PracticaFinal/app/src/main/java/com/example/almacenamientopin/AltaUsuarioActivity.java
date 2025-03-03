package com.example.almacenamientopin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AltaUsuarioActivity extends AppCompatActivity {

    private String sharedPrefFile = "com.example.almacenamientopin";
    Bundle bundle;

    public static String nombreUsuario = "";
    public static String primerPIN = "";
    public static String segundoPIN = "";
    public static boolean introducePIN = false;
    public TextView pantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_usuario);

        ImageButton botonImagen=findViewById(R.id.imageButton);
        EditText nombreU =findViewById(R.id.nombre);

        pantalla = findViewById(R.id.calculator_screen);

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

        Button btnReiniciar = findViewById(R.id.reiniciar);
        Button btnBorrarNumero = findViewById(R.id.borrarNumero);
        Button btnAvanzar = findViewById(R.id.avanzar);

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
                if (!introducePIN) {
                    if (!primerPIN.isEmpty()) {
                        primerPIN = primerPIN.substring(0, primerPIN.length()-1);
                        pantalla.setText(primerPIN);
                    }
                } else {
                    if (!segundoPIN.isEmpty()) {
                        segundoPIN = segundoPIN.substring(0, segundoPIN.length() - 1);
                        pantalla.setText(segundoPIN);
                    }
                }
            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará
                primerPIN = "";
                segundoPIN = "";
                introducePIN = false;
                pantalla.setText("");
            }
        });

        btnAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nombreU.getText().toString().trim().isEmpty()) {
                    String text = "ERROR. Para registrarte necesitas introducir un nombre.";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(AltaUsuarioActivity.this, text, duration);
                    toast.show();
                } else {
                    nombreUsuario = nombreU.getText().toString().trim();
                    
                }
                // Código que se ejecutará
                if (!introducePIN) {
                    if (primerPIN.length() < 4) {
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(AltaUsuarioActivity.this,"Tu PIN debe contener 4 dígitos", duration);
                        toast.show();
                    } else {
                        btnAvanzar.setText("Enviar");
                        pantalla.setText("");
                        introducePIN = true;
                    }
                } else {
                    if (segundoPIN.length() < 4) {
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(AltaUsuarioActivity.this,"Tu PIN debe contener 4 dígitos", duration);
                        toast.show();
                    } else if (!primerPIN.equals(segundoPIN)) {
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(AltaUsuarioActivity.this,"Los dos PIN introducidos no coinciden.", duration);
                        toast.show();
                    }
                }
            }
        });

        botonImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código que se ejecutará

                guardarPreferences();
                Intent i = new Intent(AltaUsuarioActivity.this, MenuActivity.class);
                startActivity(i);

            }
        });

    }

    public void introducirNumero(String numero) {

        if (!introducePIN) {
            if (primerPIN.length() < 4) {
                primerPIN += numero;
                pantalla.setText(primerPIN);
            }
        } else {
            if (segundoPIN.length() < 4) {
                segundoPIN += numero;
                pantalla.setText(segundoPIN);
            }
        }

    }
    
    private void guardarPreferences() {
        SharedPreferences mPreferences=getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor edit = mPreferences.edit();

        edit.putString("nombreusuario", nombreUsuario);
        edit.putString("pin", primerPIN);
        edit.apply();
    }

    

    /*@Override
    protected void onPause() {
        super.onPause();
        guardarPreferences();
        
    }*/
}