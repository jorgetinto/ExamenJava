package cl.duoc.dej.datos.dao;
import java.util.List;

/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 * @param <T>
 */
public interface GenericDao <T> {
    void crear(T t);
    T leer(Object key);
    T actualizar(T t);
    void eliminar(T t);
    List<T> listar();
}
