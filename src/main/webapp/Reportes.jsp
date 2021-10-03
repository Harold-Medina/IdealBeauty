<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="Admin.css">
<head>
<meta charset="ISO-8859-1">
<title>Reportes</title>
</head>
<body>

<%!String mensaje="";
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

<form action="" method="post">
	<fieldset>
		<legend><h2>Reportes</h2></legend>
	
		<div>
		  <table style="margin: 0 auto;">
		  <tr>
		     <td>
			  <label></label>
			 </td>
			
			 <td>
			  <div><input type="submit" name="listadoUsuarios" value="Listado de Usuarios" class="btn"></div>
			 </td>
			 <td> 
		      <div><input type="submit" name="listadoCliente" value="Listado de Cliente" id="update"class="btn"></div>
			 </td>
			 <td>
			  <div><input type="submit" name="ventaCliente" value="Ventas por Cliente" id="delete" class="btn"></div>
		    </td>
		  </tr> 
		  		 
		   
		  </table>
		</div>
	</fieldset>
</form>


</body>
</html>