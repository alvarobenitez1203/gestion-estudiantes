package com.example.almacenamientopin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.almacenamientopin.modelo.Alumno;
import com.example.almacenamientopin.viewmodel.AlumnoViewModel;

public class FormularioActivity extends AppCompatActivity {

    private AlumnoViewModel alumnoViewModel;
    private EditText alumnoNombre, alumnoApellido1, alumnoApellido2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        ImageButton botonGuardar =findViewById(R.id.btnFormulario);

         alumnoNombre=findViewById(R.id.nombreEstudiante);
         alumnoApellido1=findViewById(R.id.apEstudiante1);
         alumnoApellido2=findViewById(R.id.apEstudiante2);

        alumnoViewModel = new ViewModelProvider(this).get(AlumnoViewModel.class);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertarUsuario();
            }
        });
    }

    // Inserta el alumno en la lista, a veces tarda un poco y no lo termina de insertar en la lista.
    // En la segunda vez, lo inserta correctamente

    private void insertarUsuario() {

        String nombre = alumnoNombre.getText().toString().trim();
        String apellido1 = alumnoApellido1.getText().toString().trim();
        String apellido2 = alumnoApellido2.getText().toString().trim();

        if (nombre.isEmpty() || apellido1.isEmpty() || apellido2.isEmpty()) {
            Toast.makeText(FormularioActivity.this, "Introduzca todos los datos del alumno.", Toast.LENGTH_SHORT).show();

        }else{
            Alumno nuevoAlumno = new Alumno();

            nuevoAlumno.setNombre(nombre);
            nuevoAlumno.setApellido1(apellido1);
            nuevoAlumno.setApellido2(apellido2);

            alumnoViewModel.insertarUsuario(nuevoAlumno);

            Toast.makeText(FormularioActivity.this, "Alumno insertado en la lista.", Toast.LENGTH_SHORT).show();

            alumnoNombre.setText("");
            alumnoApellido1.setText("");
            alumnoApellido2.setText("");

        }

    }



}