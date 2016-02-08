package cl.duoc.dej.negocio;

import cl.duoc.dej.datos.beans.Atencion;
import cl.duoc.dej.datos.beans.Cliente;
import cl.duoc.dej.datos.beans.Modulo;
import cl.duoc.dej.datos.beans.Servicio;
import cl.duoc.dej.datos.dao.AtencionDao;
import cl.duoc.dej.datos.dao.ClienteDao;
import cl.duoc.dej.datos.dao.ModuloDao;
import cl.duoc.dej.datos.dao.ServicioDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 */
@Stateless
public class LogicaService implements LogicaServiceLocal{
    @EJB(name = "AtencionDao")
    private AtencionDao atencionDao;
    @EJB(name = "ServicioDao")
    private ServicioDao servicioDao;
    @EJB(name = "ModuloDao")
    private ModuloDao moduloDao;
    @EJB(name = "ClienteDao")
    private ClienteDao clienteDao;
    

    @Override
    public Cliente validarCliente(int rut) {
        return clienteDao.leer(rut);
    }
    
    @Override
    public int cargaModulo(int nroModulo){
        Modulo modulo = moduloDao.leer(nroModulo);
        return modulo.getCargaActual();
    }
    
    @Override
    public void actualizarModulo(Modulo modulo){
        modulo.setCargaActual(modulo.getCargaActual()+1);
        moduloDao.actualizar(modulo);
    }

    @Override
    public void agregarAtencion(Atencion atencion){
        atencionDao.crear(atencion);
    }
    
    @Override
    public int nroModuloNoCliente(){
        return 1;
    }
    
    @Override
    public int nroModuloCliente(){
        int menor = 1;
        int nroModulo = 0;
        List<Modulo> modulos = moduloDao.listar();
        
        for (int i = 9; i >= 1; i--) {
            if (modulos.get(i).getCargaActual() <= menor) {
                menor = modulos.get(i).getCargaActual();
                nroModulo = modulos.get(i).getNroModulo();
            }
        }
        return nroModulo;
    }
    
    @Override
    public int tiempoEsperaCliente(){
        return cargaModulo(nroModuloCliente())*5;
    }

    @Override
    public int tiempoEsperaNoCliente() {
        return cargaModulo(nroModuloNoCliente())*5;
    }

    @Override
    public Servicio tipoServicio(int idServicio) {
        return servicioDao.leer(idServicio);
    }

    @Override
    public List<Atencion> buscarAtencionesPorRut(int rut) {
        return atencionDao.buscarAtencionesPorRut(rut);
        
    }
    
    @Override
    public Atencion buscarAtencion(int idAtencion){
        return atencionDao.leer(idAtencion);
    }
    
    @Override
    public void eliminarAtencion(int nroAtencion){
        Atencion atencion = atencionDao.leer(nroAtencion);
        int nroModulo = atencion.getNroModulo();
        Modulo modulo = moduloDao.leer(nroModulo);
        modulo.setCargaActual(modulo.getCargaActual() - 1);
        moduloDao.actualizar(modulo);
        atencionDao.eliminarAtencion(nroAtencion);
    }
    
    @Override
    public boolean validarServicio(Atencion atencion){
        
        List<Atencion> atenciones = atencionDao.listar();
        for (Atencion a : atenciones) {
            if (a.getRut() == atencion.getRut()) {
                if (a.getServicio().getDescripcion().equals(atencion.getServicio().getDescripcion())) {
                    return true;
                }
            }
        }
        return false;
    }
}
