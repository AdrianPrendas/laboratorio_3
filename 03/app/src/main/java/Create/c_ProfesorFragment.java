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

import com.example.a6r1an.lab03.domain.Profesor;
import com.example.bl.ProfesorBL;
import com.example.kevca.a03.ProfesorFragment;
import com.example.kevca.a03.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link c_ProfesorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link c_ProfesorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c_ProfesorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int codigoProfesor;
    private EditText c_profesor_nombre;
    private EditText c_profesor_cedula;
    private EditText c_profesor_telefono;
    private EditText c_profesor_mail;
    private EditText c_profesor_contrasena;
    private TextView c_profesor_titulo;
    private Button c_profesor_btnGuardar;
    private static ProfesorBL profesorbl = ProfesorBL.Companion.getInstance();
    private Profesor profesor;

    private OnFragmentInteractionListener mListener;

    public c_ProfesorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c_ProfesorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c_ProfesorFragment newInstance(String param1, String param2) {
        c_ProfesorFragment fragment = new c_ProfesorFragment();
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
            codigoProfesor = getArguments().getInt("someInt", 0);
        }
    }
    public static c_ProfesorFragment newInstance(int someInt) {
        c_ProfesorFragment c_profesorfragment = new c_ProfesorFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        c_profesorfragment.setArguments(args);

        return c_profesorfragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_c__profesor, container, false);

        c_profesor_titulo= (TextView) vista.findViewById(R.id.title_c_profesor);
        c_profesor_cedula= (EditText) vista.findViewById(R.id.c_profesor_cedula);
        c_profesor_nombre= (EditText) vista.findViewById(R.id.c_profesor_nombre);
        c_profesor_telefono= (EditText) vista.findViewById(R.id.c_profesor_telefono);
        c_profesor_mail= (EditText) vista.findViewById(R.id.c_profesor_mail);
        c_profesor_contrasena= (EditText) vista.findViewById(R.id.c_profesor_contrasena);
        c_profesor_btnGuardar = (Button) vista.findViewById(R.id.c_profesor_btnGuardar);
        if (codigoProfesor==0){
            c_profesor_titulo.setText("Crear Nuevo Profesor");
        }else{
            profesor =profesorbl.read(codigoProfesor);
            if (profesor!=null){
                updateProfesor(profesor);
            }else {
                Toast.makeText(getContext(),"No se encuentra el profesor a modificar",Toast.LENGTH_LONG).show();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame,new ProfesorFragment()).commit();
            }

        }
        c_profesor_btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(camposLlenos()){

                    profesor=new Profesor(Integer.parseInt(c_profesor_cedula.getText().toString()),c_profesor_nombre.getText().toString(),Integer.parseInt(c_profesor_telefono.getText().toString()),c_profesor_mail.getText().toString());
                    profesor.setPassword(c_profesor_contrasena.getText().toString());
                    String salidaTOAST="";
                    Profesor profesorReturn=null;
                    //Se crea o modifica
                    if(codigoProfesor==0){
                        salidaTOAST="Se agrega el profesor: '";
                        profesorReturn= profesorbl.create(profesor);
                    }
                    else {
                        salidaTOAST="Se modifica el curso: '";
                        profesorReturn= profesorbl.update(profesor);
                    }
                    //Si se logra modificar o agregar se manda un toast
                    if(profesorReturn!=null){
                        Toast.makeText(getContext(),salidaTOAST +profesorReturn.getNombre()+"' Cedula: "+profesorReturn.getCedula(),Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getContext(),"No se agrega el profesor",Toast.LENGTH_SHORT).show();
                    }
                    FragmentManager manager=getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_frame,new ProfesorFragment()).addToBackStack("bcKPF").commit();
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

    private void updateProfesor(Profesor profesor){
        c_profesor_titulo.setText("Modificar Profesor");
        c_profesor_cedula.setText(String.valueOf(profesor.getCedula()));
        c_profesor_cedula.setEnabled(false);
        c_profesor_nombre.setText(String.valueOf(profesor.getNombre()));
        c_profesor_telefono.setText(String.valueOf(profesor.getTelefono()));
        c_profesor_mail.setText(String.valueOf(profesor.getEmail()));
        c_profesor_contrasena.setText(String.valueOf(profesor.getPassword()));

        c_profesor_btnGuardar.setText("Modificar");
    }
    private boolean camposLlenos(){
        if(c_profesor_cedula.getText().toString().trim().equals("") || c_profesor_nombre.getText().toString().trim().equals("") || c_profesor_telefono.getText().toString().trim().equals("") || c_profesor_mail.getText().toString().trim().equals("") ||   c_profesor_contrasena.getText().toString().trim().equals("")){
            return false;
        }
        return true;
    }
}
