// Paquete donde se encuentra la clase
package com.example.almacenamientopin.viewmodel;

// Importaciones necesarias
import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.almacenamientopin.modelo.Alumno;
import com.example.almacenamientopin.repositorios.AlumnoRepository;


import java.util.List;

/**
 * Este código define un ViewModel de Android.
 * Un ViewModel proporciona datos a la interfaz de usuario y sobrevive a los cambios de configuración.
 * En este caso, el ViewModel se utiliza para proporcionar una lista de empleados desde una base de datos
 * Room a una actividad o fragmento.
 */
// Clase ViewModel para la gestión de Empleados
public class AlumnoViewModel extends AndroidViewModel {
    // Repositorio de Empleados y LiveData para mantener actualizada la lista de Empleados
    private AlumnoRepository repository;
    private LiveData<List<Alumno>> allAlumnos;

    // Constructor de la clase
    public AlumnoViewModel(Application application) {
        super(application);
        // Se instancia el repositorio de Empleados y se obtienen todos los Empleados
        repository = new AlumnoRepository(application);
        allAlumnos = repository.getAllAlumnos();
    }

    // Método para obtener todos los Empleados
    public LiveData<List<Alumno>> getAllAlumnos() {
        return allAlumnos;
    }

    public void insertarUsuario(Alumno alumno){
        repository.insertarUsuario(alumno);
    }
}
