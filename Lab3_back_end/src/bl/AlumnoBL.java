package bl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Alumno;
import eif203.util.IOServices;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author _Adrián_Prendas_
 */
public class AlumnoBL implements BaseBL<Alumno,Integer> {

    public AlumnoBL() {}    

    @Override
    public boolean create(Alumno o) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer,Alumno> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/alumnos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("cedula"), 
                    new Alumno(
                        obj.getInt("cedula"),
                        obj.getString("nombre"),
                        obj.getInt("telefono"),
                        obj.getString("email"),
                        new Date(obj.getString("fechaNacimiento")),
                        obj.getInt("carrera")
                    )
                );
            }
            tablaHash.put(o.getCedula(), o);
            
            List<String> lines = new ArrayList();
            for(Integer key : tablaHash.keySet()){
                lines.add(gson.toJson(tablaHash.get(key)));
            }
            Path file = Paths.get("./../data/alumnos.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
            //IOServices.writeText("./../data/", "alumnos.json",str);//error, el archivo lo tiene el reader
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public List<Alumno> read() {
        ArrayList<Alumno> listaAlumnos = new ArrayList();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/alumnos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                listaAlumnos.add(
                        new Alumno(
                            obj.getInt("cedula"),
                            obj.getString("nombre"),
                            obj.getInt("telefono"),
                            obj.getString("email"),
                            new Date(obj.getString("fechaNacimiento")),
                            obj.getInt("carrera")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAlumnos;
    }

    @Override
    public Alumno read(Integer key) {
        Hashtable<Integer,Alumno> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/alumnos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("cedula"), 
                    new Alumno(
                        obj.getInt("cedula"),
                        obj.getString("nombre"),
                        obj.getInt("telefono"),
                        obj.getString("email"),
                        new Date(obj.getString("fechaNacimiento")),
                        obj.getInt("carrera")
                    )
                );
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tablaHash.get(key);
    }

    @Override
    public boolean update(Alumno o) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer,Alumno> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/alumnos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("cedula"), 
                    new Alumno(
                        obj.getInt("cedula"),
                        obj.getString("nombre"),
                        obj.getInt("telefono"),
                        obj.getString("email"),
                        new Date(obj.getString("fechaNacimiento")),
                        obj.getInt("carrera")
                    )
                );
            }
            tablaHash.put(o.getCedula(), o);
            
            List<String> lines = new ArrayList();
            for(Integer key : tablaHash.keySet()){
                lines.add(gson.toJson(tablaHash.get(key)));
            }
            Path file = Paths.get("./../data/alumnos.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
            //IOServices.writeText("./../data/", "alumnos.json",str);//error, el archivo lo tiene el reader
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Integer key) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer,Alumno> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/alumnos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                   obj.getInt("cedula"), 
                    new Alumno(
                        obj.getInt("cedula"),
                        obj.getString("nombre"),
                        obj.getInt("telefono"),
                        obj.getString("email"),
                        new Date(obj.getString("fechaNacimiento")),
                        obj.getInt("carrera")
                    )
                );
            }
            tablaHash.remove(key);
            List<String> lines = new ArrayList();
            for(Integer k : tablaHash.keySet()){
                lines.add(gson.toJson(tablaHash.get(k)));
            }
            Path file = Paths.get("./../data/alumnos.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
            //IOServices.writeText("./../data/", "alumnos.json",str);//error, el archivo lo tiene el reader
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    
    
}
