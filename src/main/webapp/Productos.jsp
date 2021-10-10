<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="Admin.css">
<head>
<meta charset="ISO-8859-1">
<title>Registro Proveedores</title>

</head>
<body>

<%
	Conexion con=new Conexion();
    String mensaje="";
%>

<%!String mensaje="";
   long nit=0L;
   String ciudad="";
   String direccion="";
   String nombre="";
   String telefono="";
   String usuario="";
   String estado="";
%>

<%
//recogemos la respuesta del servlet y la asociamos a variables
if (request.getParameter("nit")!=null){
	nit=Long.parseLong(request.getParameter("nit"));
	ciudad=request.getParameter("ciudad");
	direccion=request.getParameter("direccion");	
	nombre=request.getParameter("nombre");
	telefono=request.getParameter("telefono");
	estado="disabled";
}
%>

<%
if(request.getParameter("men")!=null){
	nit=0L;
	ciudad="";
	direccion="";
	nombre="";
	telefono="";
	estado="";
	mensaje = request.getParameter("men");
	//codigo javascript, mensaje con alert de javascript
    out.print("<script>alert('"+mensaje+"');</script>");
}
%>

<%
if (request.getParameter("reset")!=null){
estado="enabled";
}
%>

<%
if(request.getParameter("rest")!=null)
{
	nit=0L;
	ciudad="";
	direccion="";
	nombre="";
	telefono="";
	estado="";
	mensaje = request.getParameter("men");
}
%>

<header id="o">
		<nav class="op">
			<ul>	
			   <li><a href="Index.jsp" id="l">Ideal Beauty</a></li>
			   <li><a href="Usuarios.jsp">Usuarios</a></li>
		       <li><a href="Clientes.jsp">Clientes</a></li>
		       <li><a href="Proveedores.jsp">Proveedores</a></li>
		       <li><a href="Productos.jsp">Productos</a></li>
		       <!--  <li><a href="Ventas.jsp">Ventas</a></li> -->
		       <li><a href="Reportes.jsp">Reportes</a></li>
			</ul>
		</nav>
</header>
 
<form action="Producto" method="post" >
<fieldset>
<legend><h2>Productos</h2></legend>
      <div>
		<table style="margin: 0 auto;" >
		  
			  <tr>
			  
			     <td>
			      <label></label>
			     </td>			     				
				 <td>
				  <div><input type="submit" name="cargararchivo" value="Cargar Productos por Archivo" class="btn"></div>			  
				 </td>
				   
				 <td> 
				  <div><input type="submit" name="cargarmanualmente" value="Cargar Productos Manualmente" class="btn"></div>	
				 </td>	    			 		    
			  </tr>       	  		 
			   
	    </table>
     </div>	


</fieldset>
</form>

  <h2><%=mensaje %></h2> 
  


</body>
</html>