package domain;

import java.util.Date;

/**
 *
 * @author _Adrián_Prendas_
 */
public class Ciclo {
        
    int numero;
    int año;
    Date fechaInicio;
    Date fechaFinal;

    public Ciclo() {}

    public Ciclo(int numero, int año, Date fechaInicio, Date fechaFinal) {
        this.numero = numero;//1,2
        this.año = año;
        this.fechaInicio = fechaInicio;//13 de febrero, julio 28
        this.fechaFinal = fechaFinal;//junio 28, noviembre 15
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    
    
    
    
}
