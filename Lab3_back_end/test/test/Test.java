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
public class Test {
    public static ProfesorBL pbl = new ProfesorBL();
    public static Profesor p = new Profesor(
            987654321,
            "Esteban Montero Fonseca",
            87654321,
            "esteban@gmail.com"
            
    );
//    public static AlumnoBL abl = new AlumnoBL();
//    public static Alumno a = new Alumno(
//            567374857,
//            "Luis Perez Zuñiga",
//            87950618,
//            "luis@gmail.com",
//            new Date(),
//            0
//    );
    public static void create(){
    System.out.println("** Creando Profesores ***");
    System.out.println(p);
    pbl.create(p);
    }
//    public static void create(){
//        System.out.println("*** Creando Alumno ***");
//        System.out.println(a);
//        abl.create(a);
//    }
    public static void readAll(){
    System.out.println("*** leyendo todos los profesor ***");
    ArrayList<Profesor> l = (ArrayList<Profesor>)pbl.read();
    for(Profesor p : l){
    System.out.println(p);
    }
    }
//    public static void readAll(){
//        System.out.println("*** Leyendo todos los Alumnos ***");
//        ArrayList<Alumno> l = (ArrayList<Alumno>)abl.read();
//        for(Alumno a : l){
//            System.out.println(a);
//        }
//    }
    public static void read(){
    System.out.println("*** Buscando Profesor especifico ***");
    System.out.println(p);
    p=pbl.read(p.getCedula());
    System.out.println(p);
    }
//    public static void read(){
//        System.out.println("*** Buscando Alumno especifico ***");
//        System.out.println(a);
//        a = abl.read(a.getCedula());
//        System.out.println(a);
//    }
    public static void update(){
    System.out.println("*** Modificando el Profesor ***");
    p.setNombre("Alexis Sanchez Rojas");
    p.setEmail("alexis@hotmail.com");
    p.setTelefono(767813573);
    pbl.update(p);
    }
//    public static void update(){
//        System.out.println("*** Modificando el Alumno ***");
//        a.setNombre("Nataly Lescano Arauz");
//        a.setEmail("nata@gmail.com");
//        a.setTelefono(89067483);
//        abl.update(a);
//    }
    public static void delete(){
    System.out.println("*** Eliminando Profesor ***");
    System.out.println(p);
    pbl.delete(p.getCedula());
    }
//    public static void delete(){
//        System.out.println("*** Eliminado Alumno ***");
//        System.out.println(a);
//        abl.delete(a.getCedula());
//    }
    
    public static void main(String[]args){
        create();
        readAll();
        read();
        update();
        delete();
    }
    
}
