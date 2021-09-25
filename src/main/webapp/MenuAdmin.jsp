<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminMenu</title>
<style type="text/css">
  <%@include file="MenuAdmin.css" %>
</style>

</head>
<body id="fondo">
<%! String mensaje=""; %>
<div class="content">
<div class="box-area">
		<header>
			<div class="wrapper">
				<div class="logo">
					<a href="Index.jsp">Ideal Beauty</a>
				</div>
				<nav>
					<a href="login.jsp">Usuarios</a>
                    <a href="Clientes.jsp">Clientes</a>
                    <a href="Proveedores.jsp">Proveedores</a>
                    <a href="#">Productos</a>
                    <a href="#">Ventas</a>
                    <a href="#">Reportes</a>
				</nav>
			</div>
		</header>
</div>
<hr>
<div>
<form action="Usuario" method="post" class=formul>
    <table class="tablit">
        <caption><h3>Ingrese los datos para crear un nuevo usuario</h3></caption>
        	<tr>
        	<th id="padin"><label>Cédula</label>
        	<input type="number" placeholder="ingrese su número Cédula" name="cedula" required>
        	</th>
        	<th id="padin"><label>Usuario</label>
    		<input type="text" placeholder="ingrese su Nombre de usuario" name="usuario" required>
    		</th>
        	</tr>
        	<tr><th id="padin"><label>Nombre Completo</label>
    		<input type="text" placeholder="ingrese su Nombre Completo" name="nombre" required></th>
    		<th id="padin"><label>contraseña</label>
    		<input type="password" placeholder="ingrese su clave" name="clave" required></th>
    		</tr>
        	<tr><th id="padin"><label>Correo electronico</label>
        	<input type="email" placeholder="ingrese su email" name="email" required></th></tr>
        	
    </table>
    <div>      
        <div><input type="submit" value="Crear Usuario" name="CrearU"  class="boton">
		
    </div>
</form>
</div>
</div>

<div>
<h2 style="color: white; text-align: center; font-style: oblique;"><%
if(request.getParameter("mens")!=null)
{
mensaje=request.getParameter("mens");
}
%>
<%=mensaje %></h2>
</div>


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
        <caption><h3>Ingrese la cedula para consultar un usuario existente</h3></caption>
        	<tr><th colspan="2" id="padinn"><label>Cédula</label>
        	<input type="number" placeholder="ingrese su número Cédula" name="cedula" value="<%=cedula%>" required>
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
        	<div><input type="reset"></div></th>
        	
    </table>
   
    <div>
    	  <div><input type="submit" value="Actualizar datos de Usuario" name="update"  class="boton">
		  <input type="submit" value="Borrar este Usuario" name="delete" class="boton"></div>
	</div>
</form>
</div>
</body>
</html>