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
public class TestAlumno {

    public static ProfesorBL pbl = new ProfesorBL();
    public static Profesor p = new Profesor(
            987654321,
            "Esteban Montero Fonseca",
            87654321,
            "esteban@gmail.com"
    );
    public static AlumnoBL abl = new AlumnoBL();
    public static Alumno a = new Alumno(
            567374857,
            "Luis Perez Zuñiga",
            87950618,
            "luis@gmail.com",
            new Date(),
            0
    );

    public static void create() {
        System.out.println("*** Creando Alumno ***");
        System.out.println(a);
        abl.create(a);
    }

    public static void readAll() {
        System.out.println("*** Leyendo todos los Alumnos ***");
        ArrayList<Alumno> l = (ArrayList<Alumno>) abl.read();
        for (Alumno a : l) {
            System.out.println(a);
        }
    }

    public static void read() {
        System.out.println("*** Buscando Alumno especifico ***");
        System.out.println(a);
        a = abl.read(a.getCedula());
        System.out.println(a);
    }

    public static void update() {
        System.out.println("*** Modificando el Alumno ***");
        a.setNombre("Nataly Lescano Arauz");
        a.setEmail("nata@gmail.com");
        a.setTelefono(89067483);
        abl.update(a);
    }

    public static void delete() {
        System.out.println("*** Eliminado Alumno ***");
        System.out.println(a);
        abl.delete(a.getCedula());
    }

    public static void main(String[] args) {
        create();
        readAll();
        read();
        update();
        delete();
    }

}
