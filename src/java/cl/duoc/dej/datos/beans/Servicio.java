package cl.duoc.dej.datos.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 */
@Entity
@Table(name="servicio")
public class Servicio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_servicio")
    private int idServicio;
    @Column(name="descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "servicio",cascade = CascadeType.ALL)
    private List<Atencion> atenciones;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Atencion> getAtenciones() {
        return atenciones;
    }

    public void setAtenciones(List<Atencion> atenciones) {
        this.atenciones = atenciones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idServicio;
        hash = 59 * hash + Objects.hashCode(this.descripcion);
        hash = 59 * hash + Objects.hashCode(this.atenciones);
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
        final Servicio other = (Servicio) obj;
        if (this.idServicio != other.idServicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", descripcion=" + descripcion + '}';
    }
}
