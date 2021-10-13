<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="Admin.css">
 <head>
	<meta charset="ISO-8859-1">
	
	<title>Registro Clientes</title>
	
</head>
<body>

<%
	Conexion con=new Conexion();
    String mensaje="";
%>
<%!String mensaje="";
	long cedula;
	String telefono="";
	String nombre="";
	String email="";
	String direccion="";
	String estado="";
%>

<%
	if(request.getParameter("cedula")!=null){
		cedula=Long.parseLong(request.getParameter("cedula"));
		telefono= request.getParameter("telefono");
		nombre=request.getParameter("nombre");
		email=request.getParameter("email");
		direccion=request.getParameter("direccion");
		estado="disabled";
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
	cedula=0L;
	telefono="";
	nombre="";
	email="";
	direccion="";
	estado="";
	mensaje=request.getParameter("men");
}
%>

<%
	if(request.getParameter("men")!=null){
		cedula=0L;
		telefono="";
		nombre="";
		email="";
		direccion="";
		estado="";
		mensaje=request.getParameter("men");
		//codigo javascript, mensaje con alert de javascript		
	    out.print("<script>alert('"+mensaje+"');</script>");
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
		       <li><a href="Ventas.jsp">Ventas</a></li>
		       <li><a href="Reportes.jsp">Reportes</a></li>
			</ul>
		</nav>
</header>


<!-- en action llamamos al servlet Cliente y usamos el metodo post la logica del negocio -->
<form action="Cliente" method="post">
	<fieldset>
		<legend><h2>Clientes</h2></legend>
		<table>
		<div>
			<label class="l1"> Cedula</label>
			<input type="number" name="cedula_cliente" value="<%=cedula%>" required <%=estado%>>
		</div>
		<input type="hidden" name="ced" value="<%=cedula%>">
		<div>
			<label class="l1">Teléfono</label>
			<input type="text" name="telefono_cliente" value="<%=telefono%>" required>
		</div>
		<div>
			<label>Nombre Completo</label>
			<input type="text" name="nombre_cliente" value="<%=nombre%>" required>
		</div>
		<div>
			<label>Correo Electronico</label>
			<input type="text" name="email_cliente" value="<%=email%>" required>
		</div>
		<div>
			<label class="l1">Dirección</label>
			<input type="text" name="direccion_cliente" value="<%=direccion%>">
		</div>		
		
		
		</table>
		
		<!--  tabla para los botones-->
		<table style="margin: 0 auto;" >
		  <tr>
		     <td>
			  <label></label>
			 </td>
		     
			
			 <td>
			  <input type="submit" name="registrar" value="Registrar" class="btn">
			 </td>
			 <td> 
		      <input type="submit" onclick="return confiupdate();" value="Actualizar" name="update"  id="update"class="btn">
			 </td>
			 <td>
			  <input type="submit" onclick="return confiborrar();" value="Eliminar" name="delete"  id="delete" class="btn">
		     </td>
		     <td>
			  <input type="submit" value="Limpiar" name="limpiar" class="btn">
		     </td>
		    
		  </tr> 
		  		 
		   
		  </table>
		
		<!-- 
		<div>
			<input type="submit" name="registrar" value="Registrar" class="btn">
			<input type="submit" onclick="return confiupdate();" name="actualizar" value="Actualizar" id="update"class="btn">
			<input type="submit" onclick="return confiborrar();" name="eliminar" value="Eliminar" id="delete" class="btn">
			<input type="submit" value="Limpiar" name="limpiar" class="btn">
		</div> -->
	</fieldset>
</form>

<form action="Cliente" method="post">
<fieldset>
<legend><h2>Consultar</h2></legend>

<div><label class="l1">Cedula: </label><input type="number" name="cedula_cliente2" required></div>
<div><input type="submit"  name="consultar" value="Consultar" class="btn"></div>
</fieldset>
</form>

<script type="text/javascript">
	function confiborrar()
	{
		var respuesta = confirm("¿Seguro de eliminar este cliente?");
		
		document.getElementById("delete").value=respuesta;

		if (respuesta == True)
			{
				return true;
		}
		else{
			return false;
		}
	}
	
	function confiupdate()
	{
		var respuesta = confirm("¿Seguro de actualizar este cliente?");
		
		document.getElementById("update").value=respuesta;

		if (respuesta == True)
			{
				return true;
		}
		else{
			return false;
		}
	}
</script>

<h2><%=mensaje %></h2>

</body>
</html>