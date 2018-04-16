package Create;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a6r1an.lab03.bl.CicloBL;
import com.example.a6r1an.lab03.domain.Ciclo;
import com.example.kevca.a03.CicloFragment;
import com.example.kevca.a03.R;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link c_CicloFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link c_CicloFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c_CicloFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int codigoCICLO;
    private EditText c_ciclo_numero;
    private EditText c_ciclo_anno;
    private EditText c_ciclo_fechaInicio;
    private EditText c_ciclo_fechaFin;
    private TextView c_ciclo_title;
    private Button c_ciclo_btnGuardar;
    private static CicloBL ciclobl = CicloBL.Companion.getInstance();
    private Ciclo ciclo;

    private OnFragmentInteractionListener mListener;

    public c_CicloFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c_CicloFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c_CicloFragment newInstance(String param1, String param2) {
        c_CicloFragment fragment = new c_CicloFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            codigoCICLO = getArguments().getInt("someInt", 0);
        }
    }
    public static c_CicloFragment newInstance(int someInt) {
        c_CicloFragment c_ciclofragment = new c_CicloFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        c_ciclofragment.setArguments(args);
        return c_ciclofragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_c__ciclo, container, false);
        c_ciclo_title= (TextView) vista.findViewById(R.id.title_c_ciclo);
        c_ciclo_numero= (EditText) vista.findViewById(R.id.c_ciclo_numero);
        c_ciclo_anno= (EditText) vista.findViewById(R.id.c_ciclo_ano);
        c_ciclo_fechaInicio= (EditText) vista.findViewById(R.id.c_ciclo_fechaInicio);
        c_ciclo_fechaFin= (EditText) vista.findViewById(R.id.c_ciclo_fechaFin);
        c_ciclo_btnGuardar = (Button) vista.findViewById(R.id.c_ciclo_btnGuardar);

        if (codigoCICLO==0){
            c_ciclo_title.setText("Crear Nueva Ciclo");
        }else{
            ciclo =ciclobl.read(codigoCICLO);
            if (ciclo!=null){
                updateCiclo(ciclo);
            }else {
                Toast.makeText(getContext(),"No se encuentra el ciclo a modificar",Toast.LENGTH_LONG).show();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame,new CicloFragment()).commit();
            }
            c_ciclo_btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(camposLlenos()){
                        Date date=new Date();
                        ciclo=new Ciclo(Integer.parseInt(c_ciclo_numero.getText().toString()),Integer.parseInt(c_ciclo_anno.getText().toString()),date,date);
                        String salidaTOAST="";
                        Ciclo cicloReturn=null;
                        //Se crea o modifica
                        if(codigoCICLO==0){
                            salidaTOAST="Se agrega el Ciclo: '";
                            cicloReturn= ciclobl.create(ciclo);
                        }
                        else {
                            salidaTOAST="Se modifica el Ciclo: '";
                            cicloReturn= ciclobl.update(ciclo);
                        }
                        //Si se logra modificar o agregar se manda un toast
                        if(cicloReturn!=null){
                            Toast.makeText(getContext(),salidaTOAST +cicloReturn.getNumero()+"' Anio: "+cicloReturn.getAnno(),Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getContext(),"No se agrega el Ciclo",Toast.LENGTH_SHORT).show();
                        }
                        FragmentManager manager=getFragmentManager();
                        manager.beginTransaction().replace(R.id.content_frame,new CicloFragment()).addToBackStack("bcakCF").commit();
                    }
                    else Toast.makeText(getContext(),"Inserte informacion en todos los campos",Toast.LENGTH_SHORT).show();

                }
            });
        }


        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void updateCiclo(Ciclo ciclo){
        c_ciclo_title.setText("Modificar Ciclo");
        c_ciclo_numero.setText(String.valueOf(ciclo.getNumero()));
        c_ciclo_numero.setEnabled(false);
        c_ciclo_anno.setText(String.valueOf(ciclo.getAnno()));
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String s = formatter.format(ciclo.getFechaInicio());
        c_ciclo_fechaInicio.setText(s);
        s = formatter.format(ciclo.getFechaFinal());
        c_ciclo_fechaFin.setText(s);
        c_ciclo_btnGuardar.setText("Modificar");
    }
    private boolean camposLlenos(){
        if(c_ciclo_numero.getText().toString().trim().equals("") || c_ciclo_anno.getText().toString().trim().equals("") || c_ciclo_fechaInicio.getText().toString().trim().equals("") || c_ciclo_fechaFin.getText().toString().trim().equals("")){
            return false;
        }
        return true;
    }
}
