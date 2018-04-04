package Create;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a6r1an.lab03.domain.Curso;
import com.example.a6r1an.lab03.bl.CursoBL;
import com.example.kevca.a03.CursoFragment;
import com.example.kevca.a03.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link c_CursoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link c_CursoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class c_CursoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int codigoCurso;
    private EditText c_curso_nombre;
    private EditText c_curso_codigo;
    private EditText c_curso_creditos;
    private EditText c_curso_horas;
    private TextView c_curso_titulo;
    private Button c_curso_btnGuardar;
    private static CursoBL cursobl = CursoBL.Companion.getInstance();
    private Curso curso;


    private OnFragmentInteractionListener mListener;

    public c_CursoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment c_CursoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static c_CursoFragment newInstance(String param1, String param2) {
        c_CursoFragment fragment = new c_CursoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static c_CursoFragment newInstance(int someInt) {
        c_CursoFragment c_cursofragment = new c_CursoFragment();

        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        c_cursofragment.setArguments(args);

        return c_cursofragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            codigoCurso = getArguments().getInt("someInt", 0);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View vista= inflater.inflate(R.layout.fragment_c__curso, container, false);
        c_curso_titulo= (TextView) vista.findViewById(R.id.title_c_curso);
        c_curso_codigo= (EditText) vista.findViewById(R.id.c_curso_codigo);
        c_curso_nombre= (EditText) vista.findViewById(R.id.c_curso_nombre);
        c_curso_creditos= (EditText) vista.findViewById(R.id.c_curso_creditos);
        c_curso_horas= (EditText) vista.findViewById(R.id.c_curso_horas);
        c_curso_btnGuardar = (Button) vista.findViewById(R.id.c_curso_btnGuardar);
        if (codigoCurso==0){
            c_curso_titulo.setText("Crear Nuevo Curso");
        }else{
            curso =cursobl.read(codigoCurso);
            if (curso!=null){
                updateCurso(curso);
            }else {
                Toast.makeText(getContext(),"No se encuentra el curso a modificar",Toast.LENGTH_LONG).show();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame,new CursoFragment()).commit();
            }

        }
        c_curso_btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(camposLlenos()){
                curso=new Curso(Integer.parseInt(c_curso_codigo.getText().toString()),c_curso_nombre.getText().toString(),Integer.parseInt(c_curso_creditos.getText().toString()),Integer.parseInt(c_curso_horas.getText().toString()));
                String salidaTOAST="";
                Curso cursoReturn=null;
                //Se crea o modifica
                if(codigoCurso==0){
                    salidaTOAST="Se agrega el curso: '";
                    cursoReturn= cursobl.create(curso);
                }
                else {
                    salidaTOAST="Se modifica el curso: '";
                    cursoReturn= cursobl.update(curso);
                }
                //Si se logra modificar o agregar se manda un toast
                if(cursoReturn!=null){
                    Toast.makeText(getContext(),salidaTOAST +cursoReturn.getNombre()+"' Codigo: "+cursoReturn.getCodigo(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"No se agrega el Curso",Toast.LENGTH_SHORT).show();
                }
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame,new CursoFragment()).addToBackStack("bcckcf").commit();
                }
                else Toast.makeText(getContext(),"Inserte informacion en todos los campos",Toast.LENGTH_SHORT).show();

            }
        });

        return vista;
    }
    private void updateCurso(Curso curso){
        c_curso_titulo.setText("Modificar Curso");
        c_curso_codigo.setText(String.valueOf(curso.getCodigo()));
        c_curso_codigo.setEnabled(false);
        c_curso_nombre.setText(String.valueOf(curso.getNombre()));
        c_curso_creditos.setText(String.valueOf(curso.getCreditos()));
        c_curso_horas.setText(String.valueOf(curso.getHoras()));
        c_curso_btnGuardar.setText("Modificar");
    }
    private boolean camposLlenos(){
        if(c_curso_nombre.getText().toString().trim().equals("") || c_curso_codigo.getText().toString().trim().equals("") || c_curso_horas.getText().toString().trim().equals("") || c_curso_creditos.getText().toString().trim().equals("")){
            return false;
        }
        return true;
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


}
