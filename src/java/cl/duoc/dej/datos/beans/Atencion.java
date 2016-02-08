package cl.duoc.dej.datos.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 */
@Entity
@Table(name="atencion")
@NamedQueries({
    @NamedQuery(name = "ate.buscarAtencionesPorRut",
        query = "SELECT a FROM Atencion a WHERE a.rut=:rutCliente"),
    @NamedQuery(name = "ate.eliminarAtencionPorId",
        query = "DELETE FROM Atencion a WHERE a.nroAtencion=:nroAtencion")
})
public class Atencion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="nro_atencion")
    private int nroAtencion;
    @Column(name="rut")
    private int rut;
    @Column(name="nro_modulo")
    private int nroModulo;
    @Column(name="tiempo_espera")
    private int tiempoEspera;
    @Column(name="comentario")
    private String comentario;
    @Column(name="fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion; 
    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    private Servicio servicio;

    public int getNroAtencion() {
        return nroAtencion;
    }

    public void setNroAtencion(int nroAtencion) {
        this.nroAtencion = nroAtencion;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getNroModulo() {
        return nroModulo;
    }

    public void setNroModulo(int nroModulo) {
        this.nroModulo = nroModulo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.nroAtencion;
        hash = 53 * hash + this.rut;
        hash = 53 * hash + this.nroModulo;
        hash = 53 * hash + this.tiempoEspera;
        hash = 53 * hash + Objects.hashCode(this.comentario);
        hash = 53 * hash + Objects.hashCode(this.fechaCreacion);
        hash = 53 * hash + Objects.hashCode(this.servicio);
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
        final Atencion other = (Atencion) obj;
        if (this.nroAtencion != other.nroAtencion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atencion{" + "nroAtencion=" + nroAtencion + ", rut=" + rut + ", nroModulo=" + nroModulo + ", tiempoEspera=" + tiempoEspera + ", comentario=" + comentario + ", fechaCreacion=" + fechaCreacion + ", servicio=" + servicio.getDescripcion() + '}';
    }

    
}
