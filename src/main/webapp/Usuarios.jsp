<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="Admin.css">
 <head>
	<meta charset="ISO-8859-1">
	
	<title>Registro Usuarios</title>
	
</head>
<body>
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


<%! 
String cedula="";
String email="",nombre="",clave="",usuario="",estado="";
String mensaje="";
%>
<%
if (request.getParameter("cedula")!=null){
cedula= request.getParameter("cedula");
email=request.getParameter("email");
nombre=request.getParameter("nombre");
clave=request.getParameter("clave");
usuario=request.getParameter("usuario");
estado="disabled";
}
%>
<%
if(request.getParameter("mens")!=null)
{
	cedula="";
	email="";nombre="";clave="";usuario="";estado="";
	mensaje=request.getParameter("mens");
}
%>



<form action="Usuario" method="post">
	<fieldset>
		<legend><h2>Usuarios</h2></legend>
		<div>
			<label class="l1"> Cédula   </label>
			<input type="number" placeholder="ingrese su número Cédula" name="cedula" value="<%=cedula%>" required <%=estado%>>
		</div>
		<input type="hidden" name="cedula" value="<%=cedula%>"> <!--- que diablos hace esta linea? --->
		<div>
			<label class="l1">Usuario </label>
			<input type="text" placeholder="ingrese su Nombre de usuario" name="usuario" value="<%=usuario%>" required>
		</div>
		<div>
			<label>Nombre Completo </label>
			<input type="text" placeholder="ingrese su Nombre Completo" name="nombre" value="<%=nombre%>" required>
		</div>
		<div>
			<label>Contraseña </label>
			<input type="password" placeholder="ingrese su clave" name="clave" value="<%=clave%>" required>
		</div>
		<div>
			<label class="l1">Correo electronico </label>
			<input type="email" placeholder="ingrese su email" name="email" value="<%=email%>">
		</div>
		<div>
			<input type="submit" value="Registrar" name="CrearU" class="btn">
			<input type="submit" value="Actualizar" name="update" class="btn">
			<input type="submit" value="Eliminar" name="delete" class="btn">
		</div>
	</fieldset>
</form>

<form action="Usuario" method="post">
<fieldset>
<legend><h2>Consultar</h2></legend>
<div><label class="l1">Cedula </label><input type="number" placeholder="ingrese su número Cédula" name="cedula" required></div>
<div><input type="submit" value="Consultar" name="consult" class="btn"></div>
</fieldset>
</form>

<h2><%=mensaje %></h2>

</body>
</html>