package test;

import bl.AlumnoBL;
import bl.ProfesorBL;
import domain.Alumno;
import domain.Profesor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author _Adrián_Prendas_
 */
public class TestProfesor {

    public static ProfesorBL pbl = new ProfesorBL();
    public static Profesor p = new Profesor(
            987654321,
            "Esteban Montero Fonseca",
            87654321,
            "esteban@gmail.com"
    );

    public static void create() {
        System.out.println("** Creando Profesores ***");
        System.out.println(p);
        pbl.create(p);
    }

    public static void readAll() {
        System.out.println("*** leyendo todos los profesor ***");
        ArrayList<Profesor> l = (ArrayList<Profesor>) pbl.read();
        for (Profesor p : l) {
            System.out.println(p);
        }
    }

    public static void read() {
        System.out.println("*** Buscando Profesor especifico ***");
        System.out.println(p);
        p = pbl.read(p.getCedula());
        System.out.println(p);
    }

    public static void update() {
        System.out.println("*** Modificando el Profesor ***");
        p.setNombre("Alexis Sanchez Rojas");
        p.setEmail("alexis@hotmail.com");
        p.setTelefono(767813573);
        pbl.update(p);
    }

    public static void delete() {
        System.out.println("*** Eliminando Profesor ***");
        System.out.println(p);
        pbl.delete(p.getCedula());
    }

    public static void main(String[] args) {
        create();
        readAll();
        read();
        update();
        delete();
    }

}
