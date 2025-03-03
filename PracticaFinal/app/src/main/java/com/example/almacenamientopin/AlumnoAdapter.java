package com.example.almacenamientopin;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.almacenamientopin.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {

    private List<Alumno> alumnos = new ArrayList<>();

    @NonNull
    @Override
    public AlumnoAdapter.AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.disenio_usuario, parent, false);
        return new AlumnoViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoAdapter.AlumnoViewHolder holder, int position) {

        Alumno alumno = alumnos.get(position);



        holder.textViewNombre.setText(alumno.getNombre()+" "+ alumno.getApellido1()+" "+ alumno.getApellido2());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Acción a realizar al hacer clic en un usuario
                // Por ejemplo, iniciar una nueva actividad
                Context context = view.getContext();
                Intent intent = new Intent(context, FichaActivity.class);
                intent.putExtra("nombre", alumno.getNombre());
                intent.putExtra("ape1", alumno.getApellido1());
                intent.putExtra("ape2", alumno.getApellido2());// Puedes pasar datos del usuario si es necesario
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
        notifyDataSetChanged();
    }


    class AlumnoViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNombre;
        //private TextView textViewApellidos;

        public AlumnoViewHolder(View itemView) {
            super(itemView);

            textViewNombre = itemView.findViewById(R.id.nameTextView);
            //textViewApellidos = itemView.findViewById(R.id.textViewApellidos);
        }
    }

}
