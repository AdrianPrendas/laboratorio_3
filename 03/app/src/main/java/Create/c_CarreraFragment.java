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

import com.example.a6r1an.lab03.domain.Carrera;
import com.example.bl.CarreraBL;
import com.example.kevca.a03.CarreraFragment;
import com.example.kevca.a03.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link c_CarreraFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link c_CarreraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c_CarreraFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int codigoCarrera;
    private EditText c_carrera_nombre;
    private EditText c_carrera_codigo;
    private EditText c_carrera_titulo;
    private TextView c_carrera_title;
    private Button c_carrera_btnGuardar;
    private static CarreraBL carrerabl = CarreraBL.Companion.getInstance();
    private Carrera carrera;

    private OnFragmentInteractionListener mListener;

    public c_CarreraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c_CarreraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c_CarreraFragment newInstance(String param1, String param2) {
        c_CarreraFragment fragment = new c_CarreraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static c_CarreraFragment newInstance(int someInt) {
        c_CarreraFragment c_carrerafragment = new c_CarreraFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        c_carrerafragment.setArguments(args);
        return c_carrerafragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            codigoCarrera = getArguments().getInt("someInt", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_c__carrera, container, false);
        c_carrera_title= (TextView) vista.findViewById(R.id.title_c_carrera);
        c_carrera_codigo= (EditText) vista.findViewById(R.id.c_carrera_codigo);
        c_carrera_nombre= (EditText) vista.findViewById(R.id.c_carrera_nombre);
        c_carrera_titulo= (EditText) vista.findViewById(R.id.c_carrera_titulo);
        c_carrera_btnGuardar = (Button) vista.findViewById(R.id.c_carrera_btnGuardar);

        if (codigoCarrera==0){
            c_carrera_title.setText("Crear Nueva Carrera");
        }else{
            carrera =carrerabl.read(codigoCarrera);
            if (carrera!=null){
                updateCarrera(carrera);
            }else {
                Toast.makeText(getContext(),"No se encuentra la carrera a modificar",Toast.LENGTH_LONG).show();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame,new CarreraFragment()).commit();
            }

        }
        c_carrera_btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(camposLlenos()){
                    ArrayList<Integer> listaCarreraCursos=new ArrayList<>();
                    carrera=new Carrera(Integer.parseInt(c_carrera_codigo.getText().toString()),c_carrera_nombre.getText().toString(),c_carrera_titulo.getText().toString(),listaCarreraCursos);
                    String salidaTOAST="";
                    Carrera carreraReturn=null;
                    //Se crea o modifica
                    if(codigoCarrera==0){
                        salidaTOAST="Se agrega la carrera: '";
                        carreraReturn= carrerabl.create(carrera);
                    }
                    else {
                        salidaTOAST="Se modifica la carrera: '";
                        carreraReturn= carrerabl.update(carrera);
                    }
                    //Si se logra modificar o agregar se manda un toast
                    if(carreraReturn!=null){
                        Toast.makeText(getContext(),salidaTOAST +carreraReturn.getNombre()+"' Codigo: "+carreraReturn.getCodigo(),Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getContext(),"No se agrega la Carrera",Toast.LENGTH_SHORT).show();
                    }
                    FragmentManager manager=getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_frame,new CarreraFragment()).addToBackStack("bckCF").commit();
                }
                else Toast.makeText(getContext(),"Inserte informacion en todos los campos",Toast.LENGTH_SHORT).show();

            }
        });

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

    private void updateCarrera(Carrera carrera){
        c_carrera_title.setText("Modificar Carrera");
        c_carrera_codigo.setText(String.valueOf(carrera.getCodigo()));
        c_carrera_codigo.setEnabled(false);
        c_carrera_nombre.setText(String.valueOf(carrera.getNombre()));
        c_carrera_titulo.setText(String.valueOf(carrera.getTitulo()));
        c_carrera_btnGuardar.setText("Modificar");
    }
    private boolean camposLlenos(){
        if(c_carrera_nombre.getText().toString().trim().equals("") || c_carrera_codigo.getText().toString().trim().equals("") || c_carrera_titulo.getText().toString().trim().equals("")){
            return false;
        }
        return true;
    }
}
