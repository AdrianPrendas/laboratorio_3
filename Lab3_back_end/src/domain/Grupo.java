package domain;

import java.util.LinkedHashMap;

/**
 *
 * @author _Adrián_Prendas_
 */
public class Grupo {
    int ciclo;
    int curso;
    int numeroGrupo;
    String horario;
    int profesorCedula;
    LinkedHashMap<Integer,Integer> estudiantes_notas;

    public Grupo() {}

    public Grupo(int ciclo, int curso, int numeroGrupo, String horario, int profesorCedula, LinkedHashMap<Integer, Integer> estudiantes_notas) {
        this.ciclo = ciclo;
        this.curso = curso;
        this.numeroGrupo = numeroGrupo;
        this.horario = horario;
        this.profesorCedula = profesorCedula;
        this.estudiantes_notas = estudiantes_notas;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getProfesorCedula() {
        return profesorCedula;
    }

    public void setProfesorCedula(int profesorCedula) {
        this.profesorCedula = profesorCedula;
    }

    public LinkedHashMap<Integer, Integer> getEstudiantes_notas() {
        return estudiantes_notas;
    }

    public void setEstudiantes_notas(LinkedHashMap<Integer, Integer> estudiantes_notas) {
        this.estudiantes_notas = estudiantes_notas;
    }
    
    
    
    
}
