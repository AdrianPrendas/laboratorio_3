package Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a6r1an.lab03.domain.Ciclo;
import com.example.kevca.a03.R;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * Created by kevca on 3/18/2018.
 */

public class AdaptadorCiclo extends
        RecyclerView.Adapter<AdaptadorCiclo.CicloViewHolder> implements
        View.OnClickListener{

    ArrayList<Ciclo> listaCiclos;
    private View.OnClickListener listener;

    public AdaptadorCiclo(ArrayList<Ciclo> listaCiclos) {
        this.listaCiclos= listaCiclos;
    }

    @Override
    public CicloViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_ciclo,null,false);
        view.setOnClickListener(this);
        return new CicloViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdaptadorCiclo.CicloViewHolder holder, int position) {
        holder.tvNumero.setText(String.valueOf(listaCiclos.get(position).getNumero()));
        holder.tvAnno.setText(String.valueOf(listaCiclos.get(position).getAnno()));
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(listaCiclos.get(position).getFechaInicio());
        holder.tvFechaInicio.setText(s);
        s = formatter.format(listaCiclos.get(position).getFechaFinal());
        holder.tvFechaFin.setText(s);
        holder.itemView.setTag(listaCiclos.get(position).getNumero());
    }

    @Override
    public int getItemCount() {
        return listaCiclos.size();
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

    public class CicloViewHolder extends RecyclerView.ViewHolder{
        TextView tvNumero,tvAnno,tvFechaInicio,tvFechaFin;

        public CicloViewHolder(View itemView) {
            super(itemView);
            tvNumero= (TextView) itemView.findViewById(R.id.tvnumero);
            tvAnno= (TextView) itemView.findViewById(R.id.tvanno);
            tvFechaInicio= (TextView) itemView.findViewById(R.id.tvFechaInicio);
            tvFechaFin= (TextView) itemView.findViewById(R.id.tvFechaFin);
        }
    }
    //Cambia los cursos segun la busqueda y notifica al adaptador del cambio
    public void filterList(ArrayList<Ciclo> listaCiclosBusqueda){
        listaCiclos=listaCiclosBusqueda;
        notifyDataSetChanged();
    }
}
