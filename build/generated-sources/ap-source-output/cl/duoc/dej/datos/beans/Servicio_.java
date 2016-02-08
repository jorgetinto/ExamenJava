package cl.duoc.dej.datos.beans;

import cl.duoc.dej.datos.beans.Atencion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-07T01:25:37")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, String> descripcion;
    public static volatile ListAttribute<Servicio, Atencion> atenciones;
    public static volatile SingularAttribute<Servicio, Integer> idServicio;

}