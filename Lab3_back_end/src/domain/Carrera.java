package domain;

import java.util.List;

/**
 *
 * @author _Adrián_Prendas_
 */
public class Carrera {
    int codigo;
    String nombre;
    String titulo;
    List<Curso> cursos;

    public Carrera() {}

    public Carrera(int codigo, String nombre, String titulo, List<Curso> cursos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.cursos = cursos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
    
    
}
