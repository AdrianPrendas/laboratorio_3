package domain;

import java.util.Date;

/**
 *
 * @author _Adrián_Prendas_
 */
public class Alumno extends Usuario{
    int cedula;
    String nombre;
    int telefono;
    String email;
    Date fechaNacimiento;
    int carrera;
    
    public Alumno(){}

    public Alumno(int cedula, String nombre, int telefono, String email, Date fechaNacimiento, int carrera) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }
    
    public String toString(){
        return "{cedula:"+this.cedula+
                ", nombre:"+this.nombre+
                ", telefono:"+this.telefono+
                ", email:"+this.email+
                ", fechaNacimiento:"+this.fechaNacimiento.toString()+
                ", carrera:"+this.carrera+"}";
    }
}
