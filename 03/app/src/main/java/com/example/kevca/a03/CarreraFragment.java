package com.example.kevca.a03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a6r1an.lab03.domain.Carrera;
import com.example.bl.CarreraBL;

import java.util.ArrayList;

import Adaptadores.AdaptadorCarrera;
import Create.c_CarreraFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CarreraFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CarreraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarreraFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recycler_carrera;
    ArrayList<Carrera> listaCarreras;
    EditText search_carrera;
    AdaptadorCarrera adapter;
    Button btnCrear;
    public static CarreraBL carrerabl = CarreraBL.Companion.getInstance();//singleton

    private OnFragmentInteractionListener mListener;

    public CarreraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarreraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarreraFragment newInstance(String param1, String param2) {
        CarreraFragment fragment = new CarreraFragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_carrera, container, false);
        btnCrear= (Button)vista.findViewById(R.id.btn_c_carrera);
        listaCarreras=new ArrayList<>();
        recycler_carrera=(RecyclerView) vista.findViewById(R.id.recycler_carrera);
        recycler_carrera.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista();
        adapter = new AdaptadorCarrera(listaCarreras);
        recycler_carrera.setAdapter(adapter);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.content_frame, c_CarreraFragment.newInstance(0)).addToBackStack("back3").commit();
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                if (direction==ItemTouchHelper.LEFT){
                    FragmentManager manager=getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_frame,c_CarreraFragment.newInstance((int) viewHolder.itemView.getTag())).addToBackStack("bckcarrf").commit();

                }else {
                    Carrera carrera= carrerabl.delete((int) viewHolder.itemView.getTag());
                    llenarLista();
                    adapter = new AdaptadorCarrera(listaCarreras);
                    recycler_carrera.setAdapter(adapter);
                    Toast.makeText(getContext(),"Eliminada "+carrera.getNombre(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                Paint color=new Paint();
                if(actionState==ItemTouchHelper.ACTION_STATE_SWIPE){
                    View itemView = viewHolder.itemView;
                    if (dX>0){

                        color.setColor(Color.parseColor("#df013b"));
                        RectF fondo=new RectF((float)itemView.getLeft(),(float)itemView.getTop(),dX,(float)itemView.getBottom());
                        c.drawRect(fondo,color);



                    }else{
                        color.setColor(Color.parseColor("#01DFA5"));
                        RectF fondo=new RectF((float)itemView.getLeft(),(float)itemView.getTop(),itemView.getRight(),(float)itemView.getBottom());
                        c.drawRect(fondo,color);
                    }

                }



                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        }).attachToRecyclerView(recycler_carrera);


        //Busqueda
        search_carrera=(EditText) vista.findViewById(R.id.search_carrera);
        search_carrera.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        return vista;
    }

    private void llenarLista() {
        listaCarreras = new ArrayList(carrerabl.readAll());
    }

    private void filter(String text){
        ArrayList<Carrera> listaCarrerasBusqueda=new ArrayList<>();
        for(Carrera carrera : listaCarreras){
            if (carrera.getNombre().toLowerCase().contains(text.toLowerCase()) || String.valueOf(carrera.getCodigo()).contains(text)){
                listaCarrerasBusqueda.add(carrera);
            }
        }
        adapter.filterList(listaCarrerasBusqueda);
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
