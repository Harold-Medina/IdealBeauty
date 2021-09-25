<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Proveedores</title>
<style type="text/css">
  <%@include file="MenuAdmin.css" %>
</style>
</head>
<body id="fondo">
<%!String mensaje="",email="",nombre="",password="", usuario="", estado="";
long cedula=0L;
%>
<%
//recogemos la respuesta del servlet y la asociamos a variables
if (request.getParameter("cedula")!=null){
	cedula=Long.parseLong(request.getParameter("cedula"));
	email=request.getParameter("email");
	nombre=request.getParameter("nombre");
	password=request.getParameter("password");
	usuario=request.getParameter("usuario");
	estado="disabled";
}
%>

<%
if(request.getParameter("men")!=null){
	cedula=0L;
	email="";
	nombre="";
	password="";
	usuario="";
	estado="";
	mensaje = request.getParameter("men");}
    //codigo javascript, mensaje con alert de javascript
    //out.print("<script>alert('"+mensaje+"');</script>");
%>

<div class="content">
<div class="box-area">
		<header>
			<div class="wrapper">
				<div class="logo">
					<a href="Index.jsp">Ideal Beauty</a>
				</div>
				<nav>
					<a href="MenuAdmin.jsp">Usuarios</a>
                    <a href="Clientes.jsp">Clientes</a>
                    <a href="#">Proveedores</a>
                    <a href="#">Productos</a>
                    <a href="#">Ventas</a>
                    <a href="#">Reportes</a>
				</nav>
			</div>
		</header>
	</div>
<hr>

<form action="" method = "post" class=formul>
    <table class="tablit">
        <caption>Ingrese los datos para crear un nuevo proveedor</caption>
        	<tr><th id="padin"><label>NIT</label>
        	<input type="number" placeholder="ingrese NIT proveedor" name="nit_proveedor" value="<%=cedula%>" <%=estado%> required>
        	<input type="hidden" name="nitprov" value="<%=cedula%>">
        	</th>
        	<th id="padin"><label>Nombre Proveedor</label>
    		<input type="text" placeholder="ingrese su Nombre de usuario" id="usuario" name="nombre_proveedor" value="<%=usuario%>" required></th>
        	</tr>
        	<tr><th id="padin"><label>Direccion</label>
    		<input type="text" placeholder="ingrese su Nombre Completo" name="direccion_proveedor" value="<%=nombre%>" required></th>
    		<th id="padin"><label>Telefono</label>
    		<input type="password" placeholder="ingrese su clave" name="telefono_proveedor" value="<%=password%>" required></th>
    		</tr>
        	<tr><th id="padin"><label>Ciudad</label>
        	<input type="text" placeholder="ingrese su email" name="ciudad_proveedor" value="<%=email%>" required></th></tr>
    </table>
    <div class="boton">
       
        <input type="submit" name="registrar" value="Registrar" >
        <input type="submit" name="actualizar" value="Actualizar" >
        <input type="submit" name="eliminar" value="Eliminar" >
    </div>
 </form>
   
 <form action="" method = "post">	
		<legend class="titulosconsultar" >Consultar</legend>
		<div><label class="titulosconsultar" >Cedula :</label><input type="number" name="cedula2" required></div>
		<div><input type="submit" name="consultar" value="Consultar"></div> 
	
 </form> 
    
    

</div>
</body>
</html>