package Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a6r1an.lab03.domain.Alumno;
import com.example.kevca.a03.R;

import java.util.ArrayList;


/**
 * Created by kevca on 3/18/2018.
 */

public class AdaptadorAlumno extends
        RecyclerView.Adapter<AdaptadorAlumno.AlumnoViewHolder> implements
        View.OnClickListener{

    ArrayList<Alumno> listaAlumnos;
    private View.OnClickListener listener;

    public AdaptadorAlumno(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public AlumnoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_alumno,null,false);
        view.setOnClickListener(this);
        return new AlumnoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorAlumno.AlumnoViewHolder holder, int position) {
        holder.tvNombreA.setText(listaAlumnos.get(position).getNombre());
        holder.tvCedulaA.setText(String.valueOf(listaAlumnos.get(position).getCedula()));
        holder.tvTelefonoA.setText(String.valueOf(listaAlumnos.get(position).getTelefono()));
        holder.tvMailA.setText(listaAlumnos.get(position).getEmail());
        holder.tvFechaA.setText(String.format("%tY-%tm-%td", listaAlumnos.get(position).getFechaNacimiento(), listaAlumnos.get(position).getFechaNacimiento(), listaAlumnos.get(position).getFechaNacimiento()));
        String carreraString="";
        switch (listaAlumnos.get(position).getCarrera()){
            case 0: carreraString="Informatica";
                break;
            case 1: carreraString="Filosofia";
                break;
            case 2: carreraString="Economia";
                break;
            case 3: carreraString="Biologia";
                break;
            case 4: carreraString="Administracion";
                break;
            default: carreraString="Informatica";
                break;
        }
        holder.tvCarreraA.setText(carreraString);
        holder.itemView.setTag(listaAlumnos.get(position).getCedula());
    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder{
        TextView tvNombreA, tvCedulaA,tvTelefonoA,tvMailA, tvFechaA,tvCarreraA;

        public AlumnoViewHolder(View itemView) {
            super(itemView);
            tvNombreA= (TextView) itemView.findViewById(R.id.tvNombreA);
            tvCedulaA= (TextView) itemView.findViewById(R.id.tvCedulaA);
            tvTelefonoA= (TextView) itemView.findViewById(R.id.tvTelefonoA);
            tvMailA= (TextView) itemView.findViewById(R.id.tvMailA);
            tvFechaA= (TextView) itemView.findViewById(R.id.tvFechaA);
            tvCarreraA= (TextView) itemView.findViewById(R.id.tvCarreraA);
        }
    }
    //Cambia los Alumno segun la busqueda y notifica al adaptador del cambio
    public void filterList(ArrayList<Alumno> listaAlumnosBusqueda){
        listaAlumnos=listaAlumnosBusqueda;
        notifyDataSetChanged();
    }
}
