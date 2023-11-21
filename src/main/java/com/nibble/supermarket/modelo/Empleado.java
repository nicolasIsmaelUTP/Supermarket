package com.nibble.supermarket.modelo;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empleado implements Serializable {
    @Id
    private String dni;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String password;

    public Empleado() {
    }

    public Empleado(String dni, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String password) {
        this.dni = dni;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Turno abrirTurno() {
        Turno turno = new Turno();
        LocalTime horaActual = LocalTime.now();

        if (horaActual.isBefore(LocalTime.NOON)) {
            turno.setTipoTurno(TipoTurno.MANANA);
        } else if (horaActual.isBefore(LocalTime.of(18, 0))) {
            turno.setTipoTurno(TipoTurno.TARDE);
        } else {
            turno.setTipoTurno(TipoTurno.NOCHE);
        }
        turno.setEmpleado(this);
        return turno;
    }

}
