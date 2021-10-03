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
		       <li><a href="Ventas.jsp">Ventas</a></li>
		       <li><a href="Reportes.jsp">Reportes</a></li>
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
if (request.getParameter("reset")!=null){
estado="enabled";
}
%>
	
<%
if(request.getParameter("mens")!=null)
{
	cedula="";
	email="";nombre="";clave="";usuario="";estado="";
	mensaje=request.getParameter("mens");
	out.print("<script>alert('"+mensaje+"')</script>");
}
%>

<%
if(request.getParameter("rest")!=null)
{
	cedula="";
	email="";nombre="";clave="";usuario="";estado="";
	mensaje=request.getParameter("mens");
}
%>

<form action="Usuario" method="post">

	<fieldset>
		<legend><h2>Usuarios</h2></legend>
		<table>
		<div>
			<label class="l1"> Cédula   </label>
			<input type="number" placeholder="ingrese su número Cédula" name="cedula" value="<%=cedula%>" required <%=estado%>>
			</div>
		</div>
		<input type="hidden" name="cedulaH" value="<%=cedula%>"> 
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
			<input type="email" placeholder="ingrese su email" name="email" value="<%=email%>" required>
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
		      <input type="submit" onclick="return confiupdate();" name="actualizar" value="Actualizar" id="update"class="btn">
			 </td>
			 <td>
			  <input type="submit" onclick="return confiborrar();" name="eliminar" value="Eliminar" id="delete" class="btn">
		     </td>
		     <td>
			  <input type="submit" value="Limpiar" name="limpiar" class="btn">
		     </td>
		    
		  </tr> 
		  		 
		   
		  </table>
		</div>
		
		<!-- 
		<div>
			<input type="submit" value="Registrar" name="CrearU" class="btn">
			<input type="submit" onclick="return confiupdate();" value="Actualizar" name="update" id="update" class="btn">
			<input type="submit" onclick="return confiborrar();" value="Eliminar" name="delete" id="delete" class="btn"> 
			 TAREA DE ARREGLAR LA FUNCION DE ESTE BOTON <input type="reset"  value="reset" name="reset" class="btn">
			<input type="submit" value="Limpiar" name="limpiar" class="btn">
			
		</div> -->
	</fieldset>
</form>

<form action="Usuario" method="post">
<fieldset>
<legend><h2>Consultar</h2></legend>
<div><label class="l1">Cedula </label><input type="number" placeholder="ingrese su número Cédula" name="cedulaC" required></div>
<div><input type="submit" value="Consultar" name="consult" class="btn">

</fieldset>
</form>
<script type="text/javascript">
	function confiborrar()
	{
		var respuesta = confirm("¿Seguro de eliminar este usuario?");
		
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
		var respuesta = confirm("¿Seguro de actualizar este usuario?");
		
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