// Paquete donde se encuentra la clase
package com.example.almacenamientopin.database;

// Importaciones necesarias
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.almacenamientopin.dao.AlumnoDAO;
import com.example.almacenamientopin.modelo.Alumno;


/**
 * Este código es una clase de base de datos Room en Android.
 * Explica cómo acceder a la base de datos y cómo inicializarla con algunos datos de muestra.
 * También muestra cómo usar hilos para tareas que pueden llevar tiempo,
 * como la inicialización de datos.
 */
// Anotación para indicar que esta clase es una base de datos Room
@Database(entities = {Alumno.class}, version = 1)
public abstract class AppAlumnosDB extends RoomDatabase {
    // Método abstracto que devuelve el DAO de Empleado
    public abstract AlumnoDAO alumnoDAO();

    // Instancia única de la base de datos (patrón Singleton)
    private static volatile AppAlumnosDB INSTANCE;

    // Método para obtener la instancia única de la base de datos
    public static AppAlumnosDB getInstance(Context context) {
        // Se asigna el contexto para la creación de registros
        CreaRegistrosThread.context = context;

        // Se verifica si la instancia es nula
        if (INSTANCE == null) {
            synchronized (AppAlumnosDB.class) {
                if (INSTANCE == null) {
                    // Se construye la instancia de la base de datos Room
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppAlumnosDB.class, "alumnoslocal").addCallback(initializeData).build();
                }
            }
        }
        return INSTANCE;
    }

    // Callback para inicializar datos al abrir la base de datos
    private static RoomDatabase.Callback initializeData =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    // Método para inicializar los datos
                    initializeData();
                }};

    // Método para inicializar datos
    public static void initializeData(){
        // Se crea e inicia un hilo para crear registros
        CreaRegistrosThread crt = new CreaRegistrosThread();
        crt.start();
    }

    // Clase interna para crear registros en un hilo
    public static class CreaRegistrosThread extends Thread{
        // Contexto necesario para la creación de registros
        public static Context context;

        @Override
        public void run() {
            // Se obtiene el DAO de Empleado
            AlumnoDAO alumnoDao = AppAlumnosDB.getInstance(CreaRegistrosThread.context).alumnoDAO();

            // Se eliminan todos los registros existentes
            alumnoDao.deleteAll();

            // Se crean objetos Empleado y se insertan en la base de datos
            Alumno alumno1 = new Alumno();
            alumno1.setNombre("Jesús");
            alumno1.setApellido1("R");
            alumno1.setApellido2("J");

            Alumno alumno2 = new Alumno();
            alumno2.setNombre("Ana");
            alumno2.setApellido1("R");
            alumno2.setApellido2("G");

            Alumno alumno3 = new Alumno();
            alumno3.setNombre("Marta");
            alumno3.setApellido1("G");
            alumno3.setApellido2("P");

            alumnoDao.insert(alumno1, alumno2, alumno3);
        }
    }
}
