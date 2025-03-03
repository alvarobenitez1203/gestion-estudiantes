package com.example.almacenamientopin.modelo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Alumno {
    @PrimaryKey(autoGenerate = true)
    public long idAlumno;
    private String nombre;
    private String apellido1;
    private String apellido2;

    // Constructor, getters y setters
    public long getidAlumno() {
        return idAlumno;
    }

    public void setidAlumno(long idAlumno) {
        this.idAlumno = idAlumno;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre);
        sb.append(" apellido1: ").append(apellido1);
        sb.append("apellido2: ").append(apellido2).append("\n");
        return sb.toString();
    }
}


