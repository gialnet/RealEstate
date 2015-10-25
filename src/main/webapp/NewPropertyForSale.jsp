<%-- 
    Document   : newClienteNew
    Created on : 01-ago-2013, 18:05:48
    Author     : antonio
--%>

<%@page import="org.json.simple.parser.ParseException"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.gialnet.realestate.customers.SQLCustomersType"%>
<%@page import="com.gialnet.realestate.customers.TuplasCustomersType"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
            <link href="css/main.css" rel="stylesheet" type="text/css" />
            <title>Nueva Propiedada a la Venta</title>
            <!--[if IE 8]><link href="css/ie8.css" rel="stylesheet" type="text/css" /><![endif]-->
            <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>

                <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
                <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
                

                <script type="text/javascript" src="js/plugins/charts/excanvas.min.js"></script>
                <script type="text/javascript" src="js/plugins/charts/jquery.flot.js"></script>
                <script type="text/javascript" src="js/plugins/charts/jquery.flot.resize.js"></script>
                <script type="text/javascript" src="js/plugins/charts/jquery.sparkline.min.js"></script>

                <script type="text/javascript" src="js/plugins/ui/jquery.easytabs.min.js"></script>
                <script type="text/javascript" src="js/plugins/ui/jquery.collapsible.min.js"></script>
                <script type="text/javascript" src="js/plugins/ui/jquery.mousewheel.js"></script>
                <script type="text/javascript" src="js/plugins/ui/prettify.js"></script>
                <script type="text/javascript" src="js/plugins/ui/jquery.bootbox.min.js"></script>
                <script type="text/javascript" src="js/plugins/ui/jquery.colorpicker.js"></script>
                <script type="text/javascript" src="js/plugins/ui/jquery.timepicker.min.js"></script>
                <script type="text/javascript" src="js/plugins/ui/jquery.jgrowl.js"></script>
                <script type="text/javascript" src="js/plugins/ui/jquery.fancybox.js"></script>
                <script type="text/javascript" src="js/plugins/ui/jquery.fullcalendar.min.js"></script>
                <script type="text/javascript" src="js/plugins/ui/jquery.elfinder.js"></script>

                <script type="text/javascript" src="js/plugins/uploader/plupload.js"></script>
                <script type="text/javascript" src="js/plugins/uploader/plupload.html4.js"></script>
                <script type="text/javascript" src="js/plugins/uploader/plupload.html5.js"></script>
                <script type="text/javascript" src="js/plugins/uploader/jquery.plupload.queue.js"></script>

                <script type="text/javascript" src="js/plugins/forms/jquery.uniform.min.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.autosize.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.inputlimiter.min.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.tagsinput.min.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.inputmask.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.select2.min.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.listbox.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.validation.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.validationEngine-en.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.form.wizard.js"></script>
                <script type="text/javascript" src="js/plugins/forms/jquery.form.js"></script>
                <script type="text/javascript" src="js/plugins/tables/jquery.dataTables.min.js"></script>
                <script type="text/javascript" src="js/files/bootstrap.min.js"></script>
                <script type="text/javascript" src="js/files/functions.js"></script>
                    
                    
                    <% 
                        //String database=(String) sesion.getAttribute("xDataBaseName");
                        /*
                        String xIDCliente = request.getParameter("xIDCliente");
                        String xPorPar="";
                        String xIguala="";
                        
                        if (xIDCliente != null && !xIDCliente.isEmpty())
                            {
                                SQLCustomers myCliente = new SQLCustomers(database);
                                
                                // Leer el volumen de negocio
                                BigDecimal resultado[] = myCliente.VolumenDeNegocioConUnCliente(Integer.parseInt(xIDCliente));
                                String TotalVentas = NumberFormat.getCurrencyInstance(Locale.GERMANY).format(resultado[0]);
                                
                                String TotalPendiente = NumberFormat.getCurrencyInstance(Locale.GERMANY).format(resultado[1]);
                                
                                // pasar desde la persistencia a memoria
                                TuplasCustomers myTupla = myCliente.getTuplasCustomers(Integer.parseInt(xIDCliente));
                                cliente.setID(myTupla.getID());
                                cliente.setNif(myTupla.getNif());
                                cliente.setNombre(myTupla.getNombre());
                                cliente.setDireccion(myTupla.getDireccion());
                                cliente.setObjeto(myTupla.getObjeto());
                                cliente.setPoblacion(myTupla.getPoblacion());
                                cliente.setMovil(myTupla.getMovil());
                                cliente.setMail(myTupla.getMail());
                                cliente.setId_customers_type(myTupla.getId_customers_type());
                                cliente.setIBAN(myTupla.getIBAN());
                                cliente.setBIC(myTupla.getBIC());
                                cliente.setOtrosDatos(myTupla.getOtrosDatos());
                                cliente.setTotalVentas(TotalVentas);
                                cliente.setTotalPendiente(TotalPendiente);                                
                                cliente.setDomiciliado(myTupla.getDomiciliado());
                                
                            }
                        else
                            {
                                cliente.setID(0);
                                cliente.setNif("");
                                cliente.setNombre("");
                                cliente.setDireccion("");
                                cliente.setObjeto("");
                                cliente.setPoblacion("");
                                cliente.setMovil("");
                                cliente.setMail("");
                                cliente.setId_customers_type(0);
                                cliente.setIBAN("");
                                cliente.setBIC("");
                                cliente.setOtrosDatos("");
                                cliente.setTotalVentas("");
                                cliente.setTotalPendiente("");
                                cliente.setDomiciliado("");
                            }
                        
                        // valores por defecto
                        String VerTipoCliente="control-group";
                        String VerPorPar="hide";
                        String VerIguala="hide";
                        
                        if (sesion.getAttribute("Asesor").equals("yes"))
                        {
                            VerIguala="control-group";
                            VerTipoCliente="hide";
                            VerPorPar="hide";
                            if (cliente.getOtrosDatos() != null && !cliente.getOtrosDatos().equals(""))
                            {
                            JSONObject jsonObjectGoogle = null; 
   
                                try {

                                 jsonObjectGoogle = (JSONObject) new JSONParser().parse(cliente.getOtrosDatos());

                                } catch (ParseException e) {
                                 throw new RuntimeException("Unable to parse json " + cliente.getOtrosDatos());
                                }

                               xIguala = (String) jsonObjectGoogle.get("iguala_mes");
                            }
                        }
                        
                        if (sesion.getAttribute("FormaJuridica").equals("Comunidades de propietarios"))
                        {
                            VerTipoCliente="hide";
                            VerPorPar="control-group";
                            if (cliente.getOtrosDatos() != null && !cliente.getOtrosDatos().equals(""))
                            {
                            JSONObject jsonObjectGoogle = null; 
   
                                try {

                                 jsonObjectGoogle = (JSONObject) new JSONParser().parse(cliente.getOtrosDatos());

                                } catch (ParseException e) {
                                 throw new RuntimeException("Unable to parse json " + cliente.getOtrosDatos());
                                }

                               xPorPar = (String) jsonObjectGoogle.get("porcentaje_participacion");
                            }
                        }
                        */
                    %>

</head>



<body>

    <!-- Fixed top -->
    <div id="top">
            <div class="fixed">
                <a href="inicio.jsp" title="" class="logo"><img src="img/logo.png" alt="" /></a>
                <ul class="top-menu">
                    <li><a class="fullview"></a></li>


                    <li class="dropdown">
                        <a class="user-menu" data-toggle="dropdown"><!--<img src="img/userpic.png" alt="" />-->
                            <img src="img/person.png" width="20" height="20" alt="" /><span></span></a>
                        <ul class="dropdown-menu">

                            <li><a href="DatosFacturacion.jsp" title=""><i class="icon-cog"></i>Mi Configuraci&oacute;n</a></li>
                            <li><a href="logout.jsp" title=""><i class="icon-remove"></i>Salir</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    <!-- /fixed top -->
    <!-- Content container -->
    <div id="container">

        <!-- Sidebar -->
        <div id="sidebar">

            <div class="sidebar-tabs">
                <ul class="tabs-nav two-items">
                    <li><a href="#general" title=""><i class="icon-reorder"></i></a></li>
                    <li><a href="#stuff" title=""><i class="icon-cogs"></i></a></li>
                </ul>

                <div id="general">		            

                    <!-- Main navigation -->
                    
                    <!-- /main navigation -->

                </div>

                <div id="stuff">
                    <!-- Datepicker -->
                    <div class="widget">
                        <h6 class="widget-name"><i class="icon-calendar"></i>Calendario</h6>
                        <div class="inlinepicker datepicker-liquid"></div>
                    </div>
                    <!-- /datepicker -->
                </div>

            </div>
        </div>
        <!-- /sidebar -->


        <!-- Content -->
        <div id="content">

            <!-- Content wrapper -->
            <div class="wrapper">

                <!-- Breadcrumbs line -->
                <div class="crumbs">
                    <ul id="breadcrumbs" class="breadcrumb"> 
                        <li><a href="BrowseClientes.jsp" title="">Lista de Clientes</a></li>
                        <li class="active"><a href="#">Añadir un nuevo cliente</a></li>
                        <!--<li class="active"><a href="calendar.html" title="">Calendar</a></li>-->
                    </ul>

                    <ul class="alt-buttons">

                    </ul>
                </div>
                
                <!-- Añadir el volumen de negocio de este cliente -->

                


                <!-- Page header -->
                <div class="page-header">
                    <div class="page-title">

                        <h5 id="xTitulo"><%= "NIF" %> <%= "RazonSocial" %>
                        </h5>

                    </div>			    	
                </div>
                <!-- /page header -->

                <div class="row-fluid">

                    <div class="span12">



                        <form class="form-horizontal" action="NewCustomer.do" id="newcustomer" method="post" 
                              accept-charset="UTF-8" enctype="multipart/form-data">
                            <fieldset>
                                <div id="widget">
                                    <div  class="navbar">
                                    <div class="navbar-inner"><h6 id="xTitulo2">Usuario :<%= "xUser" %> Rol : <%= "UserTipo" %></h6></div></div>

                            <div  class="well">	


                                    <input type="hidden" name="xIDCliente" id="xIDCliente" value="<%= "cliente.getID()" %>">
                                    
                                    <div class="<%= "VerTipoCliente" %>">
                                    <label class="control-label" for="Tipo">Tipo:</label>
                                    <select name="xTipo" id="xTipo">
                                        <%
                                         List<TuplasCustomersType> Tuplas = new SQLCustomersType().getTuplasCustomersType();
                                         String opcion;
                                         for (TuplasCustomersType Tipos : Tuplas) {
                                             opcion="<option value=\""+Tipos.getId()+"\">"+Tipos.getDescripcion()+"</option>";
                                             out.write(opcion);
                                         }
                                        %>
                                    </select>
                                    </div>
                                    
                                               
                                    <div class="control-group">

                                        <label class="control-label" for="NIF">NIF/CIF:</label>
                                        <input type="text" name="xNIF" id="xNIF" maxlength="10"
                                               value="<%= "cliente.getNif()" %>">

                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="Razón social">Razon Social:</label>
                                        <input type="text" name="xNombre" maxlength="90" size="60"
                                               placeholder="Nombre del cliente" required="required"
                                               value="<%= "cliente.getNombre()" %>">

                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="Dirección postal">Dirección postal:</label>
                                        <input type="text" name="xDireccion" maxlength="90" size="60" required="required"
                                               placeholder="Ejem: Calle Rivera del Manzanares, 7"
                                               value="<%= "cliente.getDireccion()" %>">
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="Ubicación">Piso apartamento:</label>
                                        <input type="text" name="xObjeto" maxlength="40" size="40"
                                               placeholder="Ejem: Bloque A 2ºB"
                                               value="<%= "cliente.getObjeto()" %>">
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="Municipio país">Cod. Postal Población:</label>
                                        <input type="text" name="xPoblacion" maxlength="90" size="60" required="required"
                                               placeholder="Ejem: 18152 Dílar Granada"
                                               value="<%= "cliente.getPoblacion()" %>">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="Móvil">Teléfono/Móvil:</label>
                                        <input type="text" name="xMovil" maxlength="10"
                                               value="<%= "cliente.getMovil()" %>">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="eMailF">e-Mail:</label>
                                        <input type="email" name="xMail" maxlength="60" size="60" 
                                               placeholder="sumail@suisp.es"
                                               value="<%= "cliente.getMail()" %>">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="xiban">IBAN:</label>
                                        <input type="text" name="xIBAN" maxlength="34" size="60"
                                               placeholder="NÚMERO CUENTA BANCARIO EUROPEO"
                                               value="<%= "cliente.getIBAN()" %>">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="xbic">BIC/SWIFT:</label>
                                        <input type="text" name="xBIC" id="xBIC" maxlength="11" size="11"
                                               placeholder="Código internacional banco"
                                               value="<%= "cliente.getBIC()" %>">
                                    </div>
                                    
                                    <div class="control-group">

                                    <label class="control-label" for="xDocu">Orden de domiciliación SEPA:</label>
                                    <input type="file" name="xDocu" id="xDocu">
                                    </div>

                                    <div class="form-actions align-right">
                                        <h5>Total cobros: <%= "cliente.getTotalVentas()" %>
                                            Total pendiente: <%= "cliente.getTotalPendiente()" %></h5>
                                        <input class="btn btn-primary" type="submit" value="guardar" />
                                    </div>

                            </div>
                                     </div>
                                </fieldset>
                        </form>
                    </div>
                </div>
            </div>
            <!-- /content wrapper -->

        </div>
        <!-- /content -->

    </div>
    <!-- /content container -->
    <script>
                
        if (document.getElementById("xIDCliente").value > 0)
            {
                document.getElementById("xTipo").value="<%= "cliente.getId_customers_type()" %>";
            }

    </script>



</body>
</html>