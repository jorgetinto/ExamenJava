package cl.duoc.dej.negocio;

import cl.duoc.dej.datos.beans.Atencion;
import cl.duoc.dej.datos.beans.Cliente;
import cl.duoc.dej.datos.beans.Modulo;
import cl.duoc.dej.datos.beans.Servicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 */
@Local
public interface LogicaServiceLocal {

    public Cliente validarCliente(int rut);
    public int cargaModulo(int nroModulo);
    public int nroModuloCliente();
    public int tiempoEsperaCliente();
    public int nroModuloNoCliente();
    public int tiempoEsperaNoCliente();
    public Servicio tipoServicio(int idServicio);
    public void agregarAtencion(Atencion atencion);
    public void actualizarModulo(Modulo nroModulo);
    public List<Atencion> buscarAtencionesPorRut(int rut);
    public Atencion buscarAtencion(int idAtencion);
    public void eliminarAtencion(int nroAtencion);
    public boolean validarServicio(Atencion atencion);
}
