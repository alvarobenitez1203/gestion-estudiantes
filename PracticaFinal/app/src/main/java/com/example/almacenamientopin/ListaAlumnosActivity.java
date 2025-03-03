package com.example.almacenamientopin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.almacenamientopin.modelo.Alumno;
import com.example.almacenamientopin.viewmodel.AlumnoViewModel;

import java.util.List;

public class ListaAlumnosActivity extends AppCompatActivity {

    private AlumnoViewModel alumnoViewModel;
    private RecyclerView recyclerView;
    private AlumnoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alumnos);

        recyclerView = findViewById(R.id.listRecyclerViewAlumnos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new AlumnoAdapter();
        recyclerView.setAdapter(adapter);

        alumnoViewModel = new ViewModelProvider(this).get(AlumnoViewModel.class);

        listarAlumnos();
    }

    private void listarAlumnos() {
        alumnoViewModel.getAllAlumnos().observe(this, new Observer<List<Alumno>>() {
            @Override
            public void onChanged(List<Alumno> alumnos) {
                adapter.setAlumnos(alumnos);
            }
        });
    }
}