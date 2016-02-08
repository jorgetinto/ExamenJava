package cl.duoc.dej.datos.dao.impl;
import cl.duoc.dej.datos.dao.GenericDao;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;


/**
 *
 * @author Ricardo Galleguillos - Cristian Mardones - Jorge Pino
 * @param <T>
 */
public class JpaDaoImpl<T> implements GenericDao<T> {

    @Transient
    protected Class<T> entityClass;
    @PersistenceContext
    protected EntityManager em;

    public JpaDaoImpl() {
                
        Class obtainedClass = getClass();
        Type genericSuperclass = null;
        for (;;) {
            genericSuperclass = obtainedClass.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                break;
            }
            obtainedClass = obtainedClass.getSuperclass();
        }
        ParameterizedType genericSuperclass_ = (ParameterizedType) genericSuperclass;
        entityClass = ((Class) ((Class) genericSuperclass_.getActualTypeArguments()[0]));
    }

    @Override
    public void crear(T o) {
        em.persist(o);
    }

    @Override
    public T leer(Object id) {
        return (T) em.find(this.entityClass, id);
    }

    @Override
    public T actualizar(T o) {
        return em.merge(o);
    }

    @Override
    public void eliminar(T o) {
        em.remove(o);
    }

    @Override
    public List<T> listar() {
        return em.createQuery(("SELECT n FROM " + this.entityClass.getName() + " AS n")).getResultList();
    }
}
