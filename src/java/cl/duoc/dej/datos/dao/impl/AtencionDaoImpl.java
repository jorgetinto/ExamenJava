
package cl.duoc.dej.datos.dao.impl;

import cl.duoc.dej.datos.beans.Atencion;
import cl.duoc.dej.datos.dao.AtencionDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 */
@Stateless
public class AtencionDaoImpl extends JpaDaoImpl<Atencion> implements AtencionDao{
    @Override
    public List<Atencion> buscarAtencionesPorRut(int rut) {
        TypedQuery<Atencion> query = em.createNamedQuery("ate.buscarAtencionesPorRut", Atencion.class);
        query.setParameter("rutCliente", rut);
        List<Atencion> resultado = null;
        try {
            resultado = query.getResultList();
        } catch (NoResultException e) {
            resultado = null;
        }
        return resultado;
    }

    @Override
    public void eliminarAtencion(int id) {
        TypedQuery<Atencion> query = em.createNamedQuery("ate.eliminarAtencionPorId", Atencion.class);
        query.setParameter("nroAtencion", id);
        try {
            query.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
