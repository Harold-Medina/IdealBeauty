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
%>

<%!String mensaje="",ciudad="",direccion="",nombre="",telefono="",  estado="",usuario="";
long nit=0L;
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
	//usuario=System.getenv("USERNAME");
	//usuario = System.getProperty("user.name");	
	
}
    //codigo javascript, mensaje con alert de javascript
    //out.print("<script>alert('"+usuario+"');</script>");

%>

<header id="o">
		<nav class="op">
			<ul>	
			   <li><a href="Index.jsp" id="l">Ideal Beauty</a></li>
			   <li><a href="Usuarios.jsp">Usuarios</a></li>
		       <li><a href="Clientes.jsp">Clientes</a></li>
		       <li><a href="Proveedores.jsp">Proveedores</a></li>
		       <li><a href="Productos.jsp">Productos</a></li>
		       <li><a href="#">Ventas</a></li>
		       <li><a href="#">Reportes</a></li>
			</ul>
		</nav>
</header>



 
<form action="Producto" method="post" enctype="multipart/form-data">
<fieldset>
<legend><h2>Cargar Productos</h2></legend>
<div><label class="l1">Archivo: </label><input type="text" name="nombreArchivo"></div><div><input type="file" name="archivo" value="Examinar" required></div>
<div><input type="submit" name="cargar" value="Cargar Archivo" class="btn"></div>
</fieldset>
</form>

  <h2><%=mensaje %></h2> 
  


</body>
</html>