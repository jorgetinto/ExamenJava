package cl.duoc.dej.datos.beans;

import cl.duoc.dej.datos.beans.Atencion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-07T01:25:37")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> rut;
    public static volatile ListAttribute<Cliente, Atencion> atenciones;
    public static volatile SingularAttribute<Cliente, String> nombre;

}