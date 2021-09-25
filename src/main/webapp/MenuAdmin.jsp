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
				   //comenta algo
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
        <caption>Ingrese los datos para crear un nuevo usuario</caption>
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
		<a href="ConsultaCedula.jsp"><input type="button" value="Consultar Usuarios Existentes" class="boton"></a></div>
    </div>
</form>
</div>
</div>

<div>
<h2 style="color: white; text-align: center; font-style: oblique;"><%
if(request.getParameter("men")!=null)
{
mensaje=request.getParameter("men");
}
%>
<%=mensaje %></h2>
</div>
</body>
</html>