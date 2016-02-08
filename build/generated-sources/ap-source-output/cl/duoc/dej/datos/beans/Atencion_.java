package cl.duoc.dej.datos.beans;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-07T01:25:37")
@StaticMetamodel(Atencion.class)
public class Atencion_ { 

    public static volatile SingularAttribute<Atencion, Integer> rut;
    public static volatile SingularAttribute<Atencion, Integer> nroModulo;
    public static volatile SingularAttribute<Atencion, Integer> nroAtencion;
    public static volatile SingularAttribute<Atencion, Integer> tiempoEspera;
    public static volatile SingularAttribute<Atencion, Date> fechaCreacion;
    public static volatile SingularAttribute<Atencion, Integer> idServicio;
    public static volatile SingularAttribute<Atencion, String> comentario;

}