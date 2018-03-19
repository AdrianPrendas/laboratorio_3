package Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kevca.a03.R;

import java.util.ArrayList;

import Entidades.Curso;

/**
 * Created by kevca on 3/18/2018.
 */

public class AdaptadorCurso extends
        RecyclerView.Adapter<AdaptadorCurso.CursoViewHolder> implements
        View.OnClickListener{

    ArrayList<Curso> listaCursos;
    private View.OnClickListener listener;

    public AdaptadorCurso(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    @Override
    public CursoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_curso,null,false);
        view.setOnClickListener(this);
        return new CursoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorCurso.CursoViewHolder holder, int position) {
        holder.tvNombre.setText(listaCursos.get(position).getNombre());
        holder.tvCodigo.setText(String.valueOf(listaCursos.get(position).getCodigo()));
        holder.tvCreditos.setText(String.valueOf(listaCursos.get(position).getCreditos()));
        holder.tvHoras.setText(String.valueOf(listaCursos.get(position).getHoras()));
    }

    @Override
    public int getItemCount() {
        return listaCursos.size();
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

    public class CursoViewHolder extends RecyclerView.ViewHolder{
        TextView tvCodigo,tvNombre,tvCreditos,tvHoras;

        public CursoViewHolder(View itemView) {
            super(itemView);
            tvNombre= (TextView) itemView.findViewById(R.id.tvNombre);
            tvCodigo= (TextView) itemView.findViewById(R.id.tvCodigo2);
            tvCreditos= (TextView) itemView.findViewById(R.id.tvCreditos2);
            tvHoras= (TextView) itemView.findViewById(R.id.tvhoras2);
        }
    }
}
