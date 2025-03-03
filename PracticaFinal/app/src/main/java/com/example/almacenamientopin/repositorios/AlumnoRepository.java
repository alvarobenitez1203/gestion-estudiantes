// Paquete donde se encuentra la clase
package com.example.almacenamientopin.repositorios;

// Importaciones necesarias
import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.almacenamientopin.dao.AlumnoDAO;
import com.example.almacenamientopin.database.AppAlumnosDB;
import com.example.almacenamientopin.modelo.Alumno;


import java.util.List;

/**
 * Este código define un repositorio que actúa como una capa de abstracción entre los datos
 * (en este caso, una base de datos Room) y el ViewModel o la capa de presentación.
 * El repositorio es responsable de interactuar con la base de datos y proporcionar los datos
 * necesarios al ViewModel. En este caso, proporciona una lista de empleados desde la base de datos.
 */
// Repositorio para la gestión de datos de Empleado
public class AlumnoRepository {
    // DAO de Empleado y LiveData para mantener actualizada la lista de Empleados
    private AlumnoDAO alumnoDAO;
    private LiveData<List<Alumno>> allAlumnos;

    // Constructor de la clase
    public AlumnoRepository(Application application) {
        // Se obtiene la instancia de la base de datos y se inicializa el DAO de Empleado
        AppAlumnosDB db = AppAlumnosDB.getInstance(application);
        alumnoDAO = db.alumnoDAO();
        // Se obtienen todos los Empleados y se asignan al LiveData
        allAlumnos = alumnoDAO.getAll();
    }

    // Método para obtener todos los Empleados
    public LiveData<List<Alumno>> getAllAlumnos() {
        return allAlumnos;
    }

    public void insertarUsuario(Alumno alumno) {
        // Aquí puedes realizar cualquier lógica adicional antes de insertar el usuario, si es necesario
        new InsertarUsuarioAsyncTask(alumnoDAO).execute(alumno);
    }

    // Clase AsyncTask para insertar un usuario en la base de datos en un hilo separado
    private static class InsertarUsuarioAsyncTask extends AsyncTask<Alumno, Void, Void> {
        private AlumnoDAO alumnoDAO;

        private InsertarUsuarioAsyncTask(AlumnoDAO alumnoDAO) {
            this.alumnoDAO = alumnoDAO;
        }

        @Override
        protected Void doInBackground(Alumno... alumnos) {
            alumnoDAO.insert(alumnos);
            return null;
        }

    }
}
