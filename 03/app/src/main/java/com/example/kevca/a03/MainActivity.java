package com.example.kevca.a03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import Create.c_AlumnoFragment;
import Create.c_CarreraFragment;
import Create.c_CursoFragment;
import Create.c_ProfesorFragment;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AlumnoFragment.OnFragmentInteractionListener, listaCursoFragment.OnFragmentInteractionListener,ProfesorFragment.OnFragmentInteractionListener,CarreraFragment.OnFragmentInteractionListener,CicloFragment.OnFragmentInteractionListener,CursoFragment.OnFragmentInteractionListener,UsuarioFragment.OnFragmentInteractionListener,GrupoFragment.OnFragmentInteractionListener, c_CursoFragment.OnFragmentInteractionListener, c_AlumnoFragment.OnFragmentInteractionListener, c_CarreraFragment.OnFragmentInteractionListener, c_ProfesorFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        /*Persona user;
        String json = (String)getIntent().getExtras().getSerializable("user");
        if(((String)getIntent().getExtras().getSerializable("tipo")).equals("Alumno"))
            user = new Gson().fromJson(json,Alumno.class);
        else//si no es gallo es gallina
            user = new Gson().fromJson(json,Profesor.class);

        Toast.makeText(this,user.toString(),Toast.LENGTH_LONG).show();*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        /*ArrayList<Alumno> lista;
        Alumno alumno = new Alumno(813156487,"Prendas",87950618,"adrian.prendas.araya@est.una.ac.cr", new Date(2018,3,25),1);


        AlumnoBL abl = new AlumnoBL();
        System .out.println("**************************Default List**************************");
        lista = abl.getList();
        for(Alumno a : lista) System.out.println(a);


        System.out.println("**************************Updated**************************");
        abl.update(alumno);
        lista = abl.getList();
        for (Alumno a : lista) System.out.println(a);


        System.out.println("**************************Deleted**************************");
        abl.delete(alumno.getCedula());
        lista = abl.getList();
        for (Alumno a : lista) System.out.println(a);

        System.out.println("**************************Created**************************");
        abl.createAlumno(alumno);
        lista = abl.getList();
        for (Alumno a : lista) System.out.println(a);

        System.out.println("**************************Especific Data**************************");
        System.out.println(abl.getAlumno(alumno.getCedula()));*/

        int id = item.getItemId();
        Fragment miFragment = null;
        boolean fragmentSeleccionado=false;
        if (id == R.id.nav_alumno) {
            miFragment=new AlumnoFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_Carrera) {
            miFragment=new CarreraFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_Ciclo) {
            miFragment=new CicloFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_Curso) {
            Toast.makeText(getApplicationContext(),"on nav_Curso",Toast.LENGTH_SHORT).show();
            miFragment=new CursoFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_Grupo) {
            miFragment=new GrupoFragment();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_Profesor) {
            miFragment=new ProfesorFragment();
            fragmentSeleccionado=true;

        } else if (id == R.id.nav_Usuario) {
            miFragment=new UsuarioFragment();
            fragmentSeleccionado=true;
        }
        else if(id == R.id.nav_salir){
            Toast.makeText(getApplicationContext(),"saliendo ...",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
        if(fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,miFragment).addToBackStack("volver")
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
