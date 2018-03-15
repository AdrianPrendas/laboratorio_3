package test;

import bl.AlumnoBL;
import domain.Alumno;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author _Adrián_Prendas_
 */
public class Test {
    
    public static void main(String[]args){
        AlumnoBL abl = new AlumnoBL();
        ArrayList<Alumno> l = (ArrayList<Alumno>)abl.read();
        for(Alumno a : l){
            System.out.println(a);
        }
        
    }
    
}
