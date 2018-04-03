package com.example.a6r1an.lab03.bl;

import com.example.a6r1an.lab03.domain.Curso;

/**
 * Created by Josue on 26/03/2018.
 */

public class Test {

    public Test(){
        Curso c = new Curso(1,"Mobiles",3,4);
        c.setCodigo(0);
        c.setCreditos(4);
        c.setHoras(4);
        c.setNombre("Moviles");

        System.out.println(String.format("%s %s %s %s \n",c.getCodigo(),c.getCreditos(),c.getHoras(),c.getNombre()));
        System.out.print(c);
    }
}
