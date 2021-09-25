<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ConsultaPorCedula</title>
<style type="text/css">
  <%@include file="MenuAdmin.css" %>
</style>

</head>
<body id="fondo">
<div class="content">
<div class="box-area">
		<header>
			<div class="wrapper">
				<div class="logo">
					<a href="Index.jsp">Ideal Beauty</a>
				</div>
				<nav>
					<a href="login.jsp">Usuarios</a>
                    <a href="#">Clientes</a>
                    <a href="#">Proveedores</a>
                    <a href="#">Productos</a>
                    <a href="#">Ventas</a>
                    <a href="#">Reportes</a>
				</nav>
			</div>
		</header>
	</div>
<hr>
<%! 

String cedula="";
String email="",nombre="",clave="",usuario="",estado="";
%>
<%
if (request.getParameter("cedula")!=null){
cedula= request.getParameter("cedula");
email=request.getParameter("email");
nombre=request.getParameter("nombre");
clave=request.getParameter("clave");
usuario=request.getParameter("usuario");
}
%>
<form action="Usuario" method="post" class=formul>
    <table class="tablit">
        <caption>Ingrese la cedula para consultar un usuario existente</caption>
        	<tr><th colspan="2" id="padinn"><label>Cédula</label>
        	<input type="number" placeholder="ingrese su número Cédula" name="cedula"" required>
        	<input type="submit" value="Consultar" name="consult"  class="boton">
        	</th>
        	</tr>    		
        	<tr><th id="padin"><label>Nombre Completo</label>
    		<input type="text" placeholder="ingrese su Nombre Completo" name="nombre" value="<%=nombre%>"></th>
    		<th id="padin"><label>contraseña</label>
    		<input type="password" placeholder="ingrese su clave" name="clave" value="<%=clave%>"></th>
    		</tr>
        	<tr><th id="padin"><label>Correo electronico</label>
        	<input type="email" placeholder="ingrese su email" name="email" value="<%=email%>"></th>
        	<th id="padin"><label>Usuario</label>
    		<input type="text" placeholder="ingrese su Nombre de usuario" name="usuario" value="<%=usuario%>"></th></tr>
    		<tr><th colspan="2" id="padinn"><label>Cédula del Usuario</label>
        	<input type="number" placeholder="Número de Cédula Registrado" name="cedula_sistema" value="<%=cedula%>" disabled>
        	
    </table>
   
    <div>
    	  <div><input type="submit" value="Actualizar datos de Usuario" name="update"  class="boton">
		  <input type="button" value="Borrar este Usuario" class="boton"></div>
	</div>
</form>
</div>
</body>
</html>