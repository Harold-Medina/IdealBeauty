<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>

<html>
<link rel="stylesheet" type="text/css" href="Ventas.css">
 <head>
	<meta charset="ISO-8859-1">
	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="js/Ventas.js"></script>
	<title>Registro Usuarios</title>
	
</head>

<%! 
String cedula="";
String email="",nombre="",clave="",usuario="",estado="";
String mensaje="";
%>

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



	<fieldset>
		<legend><h2>ventas</h2></legend>
			<table id=tablaV>
			<tr>
			 <th>
			  <label>Usuario</label>
			  <input type="number" placeholder="ingrese Cédula" name="cedulaUsu" value="<%=cedula%>" required <%=estado%>>
			 
			 </th>
			 <th>
			  <label>_________________</label>
			 <!-- <input type="number" placeholder="ingrese Cédula" name="cedula" value="<%=cedula%>" required <%=estado%>></th>-->
			 <th>
			  <label>Consecutivo</label>
			  <input type="number" name="Consecutivo" value="<%=cedula%>" required disabled>
			 </th>
			</tr>
			<tr>
			 <th>
			  <label>Cliente</label>
			  <input type="number" placeholder="ingrese Cédula" name="cedulaUsu" value="<%=cedula%>" required <%=estado%>>
			  
			 </th>
			 <th>
			  <label>_________________</label>
			 </th>
			 <th>
			 	<input type="submit" name="consultar" value="Validar" class="btn1" > 
			 
			</th> 
			<tr>
			 <td colspan="3" colspan="2">
			<button id="mas" class="btn1" >Agregar producto</button>
			 	<table id="productos">
			  		<thead>
			  			<tr>
			 				<th>Código del producto</th>
			 				<th>nombre producto</th>
			 				<th>costo unitario</th>
			 				<th>cantidad</th>
			 				<th>valor tot</th>
			 				
			 			</tr>
			 		</thead>
			 		
			 	</table>
			<tr>
			 <td></td>
			 <td colspan="3">
			 		<table id="resultados">
			 			<tr>
			 				<td><input type="submit" name="consultar" value="Calcular" class="btn1" id="mult"></td>
			 				<td><label> Total venta</label></td>
			 				<td id="totv"></td>
			 			</tr>
			 			<tr>
			 				<td><input type="submit" name="consultar" value="Confirmar" class="btn1"></td>
			 				<td><label> Total IVA</label></td>
			 				<td id="totiva"></td>
			 			</tr>
			 			<tr>
			 				<td></td>
			 				<td><label> Total con IVA</label></td>
			 				<td id="totveiva"></td>
			 			</tr>
			 		</table>
			 </td>
			 </tr>
			  
			</table>
			
	</fieldset>


</body>
</html>