package Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a6r1an.lab03.domain.Profesor;
import com.example.kevca.a03.R;

import java.util.ArrayList;


/**
 * Created by kevca on 3/18/2018.
 */

public class AdaptadorProfesor extends
        RecyclerView.Adapter<AdaptadorProfesor.ProfesorViewHolder> implements
        View.OnClickListener{

    ArrayList<Profesor> listaProfesores;
    private View.OnClickListener listener;

    public AdaptadorProfesor(ArrayList<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    @Override
    public ProfesorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_profesor,null,false);
        view.setOnClickListener(this);
        return new ProfesorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorProfesor.ProfesorViewHolder holder, int position) {
        holder.tvNombreP.setText(listaProfesores.get(position).getNombre());
        holder.tvCedulaP.setText(String.valueOf(listaProfesores.get(position).getCedula()));
        holder.tvTelefonoP.setText(String.valueOf(listaProfesores.get(position).getTelefono()));
        holder.tvMailP.setText(listaProfesores.get(position).getEmail());
        holder.itemView.setTag(listaProfesores.get(position).getCedula());
    }

    @Override
    public int getItemCount() {
        return listaProfesores.size();
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

    public class ProfesorViewHolder extends RecyclerView.ViewHolder{
        TextView tvNombreP, tvCedulaP,tvTelefonoP,tvMailP;

        public ProfesorViewHolder(View itemView) {
            super(itemView);
            tvNombreP= (TextView) itemView.findViewById(R.id.tvNombreP);
            tvCedulaP= (TextView) itemView.findViewById(R.id.tvCedulaP);
            tvTelefonoP= (TextView) itemView.findViewById(R.id.tvTelefonoP);
            tvMailP= (TextView) itemView.findViewById(R.id.tvMailP);
        }
    }
    //Cambia los Profesores segun la busqueda y notifica al adaptador del cambio
    public void filterList(ArrayList<Profesor> listaProfesoresBusqueda){
        listaProfesores=listaProfesoresBusqueda;
        notifyDataSetChanged();
    }
}
