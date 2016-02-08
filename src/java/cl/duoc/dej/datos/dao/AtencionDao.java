/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej.datos.dao;

import cl.duoc.dej.datos.beans.Atencion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 */
@Local
public interface AtencionDao extends GenericDao<Atencion>{
    public List<Atencion> buscarAtencionesPorRut(int rut);
    public void eliminarAtencion(int id);
}
