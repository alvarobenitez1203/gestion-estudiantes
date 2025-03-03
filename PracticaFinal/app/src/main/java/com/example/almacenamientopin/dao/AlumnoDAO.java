package com.example.almacenamientopin.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.almacenamientopin.modelo.Alumno;

import java.util.List;

@Dao
public interface AlumnoDAO {
    @Query("SELECT * FROM Alumno")
    LiveData<List<Alumno>> getAll();

    @Delete
    void delete(Alumno alumno);

    @Query("DELETE FROM Alumno")
    void deleteAll();

    @Insert
    void insert(Alumno... alumnos);
}
