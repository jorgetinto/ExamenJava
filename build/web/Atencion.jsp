<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>A la Feria - te conoce</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
    <div class="brand">A La Feria</div>
    <div class="address-bar">Te Conoce</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.html">Business Casual</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="Index.jsp">Inicio</a>
                    </li>
                    <li class="active">
                       <a href="Atencion.jsp">Atencion</a>
                    </li>
                    <li>
                          <a href="VerMisNumeros.jsp">Ver Mis Numeros</a>
                    </li>
                    <li>
                        <a href="contact.jsp">Contacto</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Toma de 
                        <strong>Numeros</strong>
                    </h2>
                    <hr>
                </div>               
        <div class="col-md-12">
        <h5 class="text-center">Para una Mejor Atención, por favor ingrese sus datos:</h5>
          <div class="col-md-8 col-lg-9 col-lg-offset-2">      
            <form action="ControladorAtencion" method="Post">
                <table class="col-md-10">
                    <label style="color: red">${mensaje}</label>
                    <thead>
                        <tr>
                            <th><input type="text" name="txtNombre" value="" placeholder="Ingrese Nombre: 'Juan Perez'" class="col-md-9" required/></th>
                            <th><p><input type="radio" name="txtRadio" value="1" checked/> Es Cliente </p></th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="text" name="txtRut" value=""  placeholder="Ingrese Rut: '16111222'"class="col-md-9" required/></td>
                            <td><p> <input type="radio" name="txtRadio" value="0"/> No es Cliente:</p></td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                        </tr>
                    <td>
                        <select name="servicios" class="col-md-9" rows="10">
                            <option value="0">Seleccione un Servicio</option>
                            <option value="1">Canje de Puntos</option>
                            <option value="2">Atención tarjeta</option>
                            <option value="3">Viajes</option>
                            <option value="4">Otros</option>
                        </select>
                    </td>
                        <tr>
                            <td>
                                <TEXTAREA name="txtComentario" value="" rows="10" cols="42" placeholder="Agrege un Comentario"></TEXTAREA>
                             </td>
                         </tr>
                        <td><input type="submit" id="btnSolicitar" value="Solicitar Número" /></td>
                        <td></td>
                        </tr>
                    </tbody>
                </table>
            </form>
          </div>
        </div>
                <div class="clearfix"></div>
            </div>
        </div>
    <!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                     <p>Copyright &copy; Examen Java  2015</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
     <!-- validacion radiobuton -->
   <script>  
    $('#myForm input').on('change', function() {
   alert($('input[name="myRadio"]:checked', '#myForm').val()); 
});
</script>
</body>

</html>

