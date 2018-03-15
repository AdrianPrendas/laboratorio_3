/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Curso;
import eif203.util.IOServices;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author esteban
 */
public class CursoBL implements BaseBL<Curso,Integer> {

    @Override
    public boolean create(Curso o) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer,Curso> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/curos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("codigo"), 
                    new Curso(
                        obj.getInt("codigo"),
                        obj.getString("nombre"),
                        obj.getInt("creditos"),
                        obj.getInt("horas")
                    )
                );
            }
            tablaHash.put(o.getCodigo(), o);
            
            List<String> lines = new ArrayList();
            for(Integer key : tablaHash.keySet()){
                lines.add(gson.toJson(tablaHash.get(key)));
            }
            Path file = Paths.get("./../data/cursos.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
            //IOServices.writeText("./../data/", "cursos.json",str);//error, el archivo lo tiene el reader
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("*** Se almaceno correctamente ***");
        return true;
    }

    @Override
    public Curso read(Integer key) {
        Hashtable<Integer,Curso> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/cursos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("codigo"), 
                    new Curso(
                        obj.getInt("codigo"),
                        obj.getString("nombre"),
                        obj.getInt("creditos"),
                        obj.getInt("horas")
                    )
                );
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        System.out.println("*** Se cargo con exito ***");
        return tablaHash.get(key);
    }

    @Override
    public List<Curso> read() {
        ArrayList<Curso> listacursos = new ArrayList();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/cursos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                listacursos.add(
                        new Curso(
                            obj.getInt("codigo"),
                            obj.getString("nombre"),
                            obj.getInt("creditos"),
                            obj.getInt("horas")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*** Se cargaron todos los registros correctamente");
        return listacursos;
    }

    @Override
    public boolean update(Curso o) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer,Curso> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/cursos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("codigo"), 
                    new Curso(
                        obj.getInt("codigo"),
                        obj.getString("nombre"),
                        obj.getInt("creditos"),
                        obj.getInt("horas")
                    )
                );
            }
            tablaHash.put(o.getCodigo(), o);
            
            List<String> lines = new ArrayList();
            for(Integer key : tablaHash.keySet()){
                lines.add(gson.toJson(tablaHash.get(key)));
            }
            Path file = Paths.get("./../data/cursos.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
            //IOServices.writeText("./../data/", "cursos.json",str);//error, el archivo lo tiene el reader
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("*** Se modifico con exito ***");
        return true;
    }

    @Override
    public boolean delete(Integer key) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer,Curso> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/cursos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("codigo"), 
                    new Curso(
                        obj.getInt("codigo"),
                        obj.getString("nombre"),
                        obj.getInt("creditos"),
                        obj.getInt("horas")
                    )
                );
            }
            tablaHash.remove(key);
            List<String> lines = new ArrayList();
            for(Integer k : tablaHash.keySet()){
                lines.add(gson.toJson(tablaHash.get(k)));
            }
            Path file = Paths.get("./../data/cursos.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
            //IOServices.writeText("./../data/", "cursos.json",str);//error, el archivo lo tiene el reader
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("*** Se elimino con exito ***");
        return true;
    }
    
}
