package Create;

import android.content.Context;
import android.net.Uri;
import android.opengl.Visibility;
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

import com.example.a6r1an.lab03.domain.Alumno;
import com.example.a6r1an.lab03.bl.AlumnoBL;
import com.example.kevca.a03.AlumnoFragment;
import com.example.kevca.a03.R;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link c_AlumnoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link c_AlumnoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c_AlumnoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int codigoAlumno;
    private EditText c_alumno_nombre;
    private EditText c_alumno_cedula;
    private EditText c_alumno_telefono;
    private EditText c_alumno_mail;
    private EditText c_alumno_fecha;
    private EditText c_alumno_carrera;
    private EditText c_alumno_contrasena;
    private TextView c_alumno_titulo;
    private Button c_alumno_btnGuardar;
    private static AlumnoBL alumnobl = AlumnoBL.Companion.getInstance();
    private Alumno alumno;

    private OnFragmentInteractionListener mListener;

    public c_AlumnoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c_AlumnoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c_AlumnoFragment newInstance(String param1, String param2) {
        c_AlumnoFragment fragment = new c_AlumnoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static c_AlumnoFragment newInstance(int someInt) {
        c_AlumnoFragment c_alumnofragment = new c_AlumnoFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        c_alumnofragment.setArguments(args);

        return c_alumnofragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            codigoAlumno = getArguments().getInt("someInt", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_c__alumno, container, false);

        c_alumno_titulo= (TextView) vista.findViewById(R.id.title_c_alumno);
        c_alumno_cedula= (EditText) vista.findViewById(R.id.c_alumno_cedula);
        c_alumno_nombre= (EditText) vista.findViewById(R.id.c_alumno_nombre);
        c_alumno_telefono= (EditText) vista.findViewById(R.id.c_alumno_telefono);
        c_alumno_mail= (EditText) vista.findViewById(R.id.c_alumno_mail);
        c_alumno_fecha= (EditText) vista.findViewById(R.id.c_alumno_fecha);
        c_alumno_carrera= (EditText) vista.findViewById(R.id.c_alumno_carrera);
        c_alumno_contrasena= (EditText) vista.findViewById(R.id.c_alumno_contrasena);
        c_alumno_btnGuardar = (Button) vista.findViewById(R.id.c_alumno_btnGuardar);
        if (codigoAlumno==0){
            c_alumno_titulo.setText("Crear Nuevo Alumno");
        }else{
            alumno =alumnobl.read(codigoAlumno);
            if (alumno!=null){
                updateAlumno(alumno);
            }else {
                Toast.makeText(getContext(),"No se encuentra el Alumno a modificar",Toast.LENGTH_LONG).show();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame,new AlumnoFragment()).commit();
            }

        }
        c_alumno_btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(camposLlenos()){
                    Date date= GregorianCalendar.getInstance().getTime();;
                    alumno=new Alumno(Integer.parseInt(c_alumno_cedula.getText().toString()),c_alumno_nombre.getText().toString(),Integer.parseInt(c_alumno_telefono.getText().toString()),c_alumno_mail.getText().toString(),date,Integer.parseInt(c_alumno_carrera.getText().toString()));
                    alumno.setPassword(c_alumno_contrasena.getText().toString());
                    String salidaTOAST="";
                    Alumno alumnoReturn=null;
                    //Se crea o modifica
                    if(codigoAlumno==0){
                        salidaTOAST="Se agrega el Alumno: '";
                        alumnoReturn= alumnobl.create(alumno);
                    }
                    else {
                        salidaTOAST="Se modifica el curso: '";
                        alumnoReturn= alumnobl.update(alumno);
                    }
                    //Si se logra modificar o agregar se manda un toast
                    if(alumnoReturn!=null){
                        Toast.makeText(getContext(),salidaTOAST +alumnoReturn.getNombre()+"' Cedula: "+alumnoReturn.getCedula(),Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getContext(),"No se agrega el Alumno",Toast.LENGTH_SHORT).show();
                    }
                    FragmentManager manager=getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_frame,new AlumnoFragment()).addToBackStack("bcaf").commit();
                }
                else Toast.makeText(getContext(),"Inserte informacion en todos los campos",Toast.LENGTH_SHORT).show();

            }
        });




        return  vista;
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



    private void updateAlumno(Alumno alumno){
        c_alumno_titulo.setText("Modificar Alumno");
        c_alumno_cedula.setText(String.valueOf(alumno.getCedula()));
        c_alumno_cedula.setEnabled(false);
        c_alumno_nombre.setText(String.valueOf(alumno.getNombre()));
        c_alumno_telefono.setText(String.valueOf(alumno.getTelefono()));
        c_alumno_mail.setText(String.valueOf(alumno.getEmail()));
        c_alumno_fecha.setText(String.valueOf(alumno.getFechaNacimiento()));
        c_alumno_carrera.setText(String.valueOf(alumno.getCarrera()));
        c_alumno_contrasena.setText(String.valueOf(alumno.getPassword()));

        c_alumno_btnGuardar.setText("Modificar");
    }
    private boolean camposLlenos(){
        if(c_alumno_cedula.getText().toString().trim().equals("") || c_alumno_nombre.getText().toString().trim().equals("") || c_alumno_telefono.getText().toString().trim().equals("") || c_alumno_mail.getText().toString().trim().equals("") || c_alumno_fecha.getText().toString().trim().equals("")|| c_alumno_carrera.getText().toString().trim().equals("")|| c_alumno_contrasena.getText().toString().trim().equals("")){
            return false;
        }
        return true;
    }
}
