/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Ciclo;
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
 * @author esteban
 */
public class CicloBL implements BaseBL<Ciclo, Integer> {

    @Override
    public boolean create(Ciclo o) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer, Ciclo> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/ciclos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                        obj.getInt("numero"),
                        new Ciclo(
                                obj.getInt("numero"),
                                obj.getInt("año"),
                                new Date(obj.getString("fechaInicio")),
                                new Date(obj.getString("fechaFinal"))
                        )
                );
            }
            tablaHash.put(o.getNumero(), o);

            List<String> lines = new ArrayList();
            for (Integer key : tablaHash.keySet()) {
                lines.add(gson.toJson(tablaHash.get(key)));
            }
            Path file = Paths.get("./../data/ciclos.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
            //IOServices.writeText("./../data/", "ciclos.json",str);//error, el archivo lo tiene el reader
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("*** Se almaceno correctamente ***");
        return true;
    }

    @Override
    public Ciclo read(Integer key) {
        Hashtable<Integer, Ciclo> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/ciclos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                        obj.getInt("numero"),
                        new Ciclo(
                                obj.getInt("numero"),
                                obj.getInt("año"),
                                new Date(obj.getString("fechaInicio")),
                                new Date(obj.getString("fechaFinal"))
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
    public List<Ciclo> read() {
        ArrayList<Ciclo> listaciclos = new ArrayList();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/ciclos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                listaciclos.add(
                        obj.getInt("numero"),
                        new Ciclo(
                                obj.getInt("numero"),
                                obj.getInt("año"),
                                new Date(obj.getString("fechaInicio")),
                                new Date(obj.getString("fechaFinal"))
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*** Se cargaron todos los registros correctamente");
        return listaciclos;
    }

    @Override
    public boolean update(Ciclo o) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Hashtable<Integer, Ciclo> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/ciclos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                        obj.getInt("numero"),
                        new Ciclo(
                                obj.getInt("numero"),
                                obj.getInt("año"),
                                new Date(obj.getString("fechaInicio")),
                                new Date(obj.getString("fechaFinal"))
                        )
                );
            }
            tablaHash.put(o.getNumero(), o);

            List<String> lines = new ArrayList();
            for (Integer key : tablaHash.keySet()) {
                lines.add(gson.toJson(tablaHash.get(key)));
            }
            Path file = Paths.get("./../data/ciclos.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
            //IOServices.writeText("./../data/", "ciclos.json",str);//error, el archivo lo tiene el reader
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
        Hashtable<Integer, Ciclo> tablaHash = new Hashtable();
        try {
            List<String> list = IOServices.readTextFileAsList("", "./../data/ciclos.json");
            for (int i = 0; i < list.size(); i++) {
                JSONObject obj = new JSONObject(list.get(i));
                tablaHash.put(
                        obj.getInt("numero"),
                        new Ciclo(
                                obj.getInt("numero"),
                                obj.getInt("año"),
                                new Date(obj.getString("fechaInicio")),
                                new Date(obj.getString("fechaFinal"))
                        )

                );
            }
            tablaHash.remove(key);
            List<String> lines = new ArrayList();
            for (Integer k : tablaHash.keySet()) {
                lines.add(gson.toJson(tablaHash.get(k)));
            }
            Path file = Paths.get("./../data/ciclos.json");
            Files.write(file, lines, Charset.forName("UTF-8"));
            //IOServices.writeText("./../data/", "ciclos.json",str);//error, el archivo lo tiene el reader
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("*** Se elimino con exito ***");
        return true;
    }

}
