package cl.duoc.dej.datos.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 */
@Entity
@Table(name="modulo")
public class Modulo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="nro_modulo")
    private int nroModulo;
    @Column(name="carga_actual")
    private int cargaActual;

    public int getNroModulo() {
        return nroModulo;
    }

    public void setNroModulo(int nroModulo) {
        this.nroModulo = nroModulo;
    }

    public int getCargaActual() {
        return cargaActual;
    }

    public void setCargaActual(int cargaActual) {
        this.cargaActual = cargaActual;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.nroModulo;
        hash = 31 * hash + this.cargaActual;
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
        final Modulo other = (Modulo) obj;
        if (this.nroModulo != other.nroModulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modulo{" + "nroModulo=" + nroModulo + ", cargaActual=" + cargaActual + '}';
    }

}
