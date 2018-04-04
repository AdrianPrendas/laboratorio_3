package Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a6r1an.lab03.domain.Carrera;
import com.example.kevca.a03.R;

import java.util.ArrayList;



/**
 * Created by kevca on 3/18/2018.
 */

public class AdaptadorCarrera extends
        RecyclerView.Adapter<AdaptadorCarrera.CarreraViewHolder> implements
        View.OnClickListener{

    ArrayList<Carrera> listaCarreras;
    private View.OnClickListener listener;

    public AdaptadorCarrera(ArrayList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    @Override
    public CarreraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_carrera,null,false);
        view.setOnClickListener(this);
        return new CarreraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorCarrera.CarreraViewHolder holder, int position) {
        holder.tv_carrera_nombre.setText(listaCarreras.get(position).getNombre());
        holder.tv_carrera_codigo.setText(String.valueOf(listaCarreras.get(position).getCodigo()));
        holder.tv_carrera_titulo.setText(String.valueOf(listaCarreras.get(position).getTitulo()));
        holder.itemView.setTag(listaCarreras.get(position).getCodigo());
    }

    @Override
    public int getItemCount() {
        return listaCarreras.size();
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

    public class CarreraViewHolder extends RecyclerView.ViewHolder{
        TextView tv_carrera_nombre,tv_carrera_codigo,tv_carrera_titulo;

        public CarreraViewHolder(View itemView) {
            super(itemView);
            tv_carrera_nombre= (TextView) itemView.findViewById(R.id.tv_carrera_nombre);
            tv_carrera_codigo= (TextView) itemView.findViewById(R.id.tv_carrera_codigo);
            tv_carrera_titulo= (TextView) itemView.findViewById(R.id.tv_carrera_titulo);
        }
    }
    //Cambia las carreras segun la busqueda y notifica al adaptador del cambio
    public void filterList(ArrayList<Carrera> listaCarrerasBusqueda){
        listaCarreras=listaCarrerasBusqueda;
        notifyDataSetChanged();
    }
}
