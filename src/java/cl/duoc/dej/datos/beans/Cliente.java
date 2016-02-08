package cl.duoc.dej.datos.beans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="rut")
    private int rut;
    @Column(name="nombre")
    private String nombre;

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.rut;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.rut != other.rut) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", nombre=" + nombre + '}';
    }
    
    
}
