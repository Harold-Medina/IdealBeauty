
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="Reportes.css">
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/reportes.js"></script>

<script src="js/xlsx.full.min.js"></script>
<script src="js/FileSaver.min.js"></script>
<script src="js/tableexport.min.js"></script> 

<title> Reportes </title>
</head>
<body background="images/fondomodulos4.jpg">

<header id="o">
		<nav class="op">
			<ul>	
			   <li><a href="index.jsp" id="l">Ideal Beauty</a></li>
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
		<legend><h2>Reportes</h2></legend>
	
		
		  <table style="margin: 0 auto;">
		  <tr>
		     
		     <label></label>			
			 <td>
			  <div><input class="listaUsuario" type="submit" name="listadoUsuarios" value="Listado de Usuarios" ></div>
			 </td>
			 <td> 	
			  <div><input class="listaCliente" type="submit" name="listadoClientes" value="Listado de Clientes" ></div> 
			 </td>
			 <td>
			  <div><input class="ventaCliente" type="submit" name="ventaCliente" value="Ventas por Cliente" ></div> 
			 </td>
		     <td>
			  <div><input class="listaProducto" type="submit" name="listaProductos" value="Listado de Productos" ></div> 
			 </td>
             <td>
			  <div><input class="listaProveedor" type="submit" name="listaProveedores" value="Listado de Proveedores" ></div> 
			 </td>
		    		    
		  </tr>  	
		   
		  </table>
		  <label></label>
		
		
	</fieldset>	
	
<h3 id="titulo-reporte" style="color:#303030"></h3>
<div></div>
<button id="btnExportar" style="display: none; margin: 0 auto;"></button>
<div></div>
<label></label>
 <table id="tabla" style="margin: 0 auto; font-size: 1.1em;" >     
	   
	
 </table>
<div> </div>
<script src="js/exportardatosexcel.js" ></script>
</body>
</html>