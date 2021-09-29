<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>

<html>
<link rel="stylesheet" type="text/css" href="Ventas.css">
 <head>
	<meta charset="ISO-8859-1">
	
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
		       <li><a href="#">Reportes</a></li>
			</ul>
		</nav>
</header>

<form action="" method="post">

	<fieldset>
		<legend><h2>ventas</h2></legend>
			<!--  <section>
			<label>Cédula</label>
			<input type="number" placeholder="ingrese su número Cédula" name="cedula" value="<%=cedula%>" required <%=estado%>>
			<input type="submit" name="consultar" value="Consultar" class="btn">
			<label>Cédula</label>
			<input type="number" placeholder="ingrese su número Cédula" name="cedula" value="<%=cedula%>" required <%=estado%>>
			<label>Cédula</label>
			<input type="number" placeholder="ingrese su número Cédula" name="cedula" value="<%=cedula%>" required <%=estado%>>
			</section> -->
			
			<table id=tablaV>
			<tr>
			 <th>
			  <label>Cédula Usuario</label>
			  <input type="number" placeholder="ingrese Cédula" name="cedulaUsu" value="<%=cedula%>" required <%=estado%>>
			  <input type="submit" name="consultar" value="Consultar" class="btn1">
			 </th>
			 <th>
			  <label>Cliente</label>
			  <input type="number" placeholder="ingrese Cédula" name="cedulaCli" value="<%=cedula%>" required <%=estado%>></th>
			 <th>
			  <label>Consecutivo</label>
			  <input type="number" name="Consecutivo" value="<%=cedula%>" required disabled>
			 </th>
			</tr>
			
			<tr>
			 <td>
			  <label>Código del producto</label> <br>
			  <input> <input type="submit" name="consultar" value="Consultar" class="btn1"><br>
			  <input> <input type="submit" name="consultar" value="Consultar" class="btn1"><br>
			  <input> <input type="submit" name="consultar" value="Consultar" class="btn1"><br>
			 </td>
			 <td>
			  <label class=izq>nombre producto</label><label class=der> Cantidad</label> <br>
			  <input class=izq> <input class="der peq"><br>
			  <input class=izq> <input class="der peq"><br>
			  <input class=izq> <input class="der peq"><br>
			 </td>
			 <td>
			  <label style="margin: 0 30%;">Valor Total</label> <br>
			  <input class="centr"> <br>
			  <input class="centr"> <br>
			  <input class="centr"> <br>
			 </td>
			</tr>
			<tr>
			 <td></td>
			 <td>
			  <input type="submit" name="consultar" value="Confirmar" class="btn1 izq btnV"> <label class=der> Total venta</label> <br>
			  <label class=der> Total IVA</label> <br>
			  <label class=der> Total con IVA</label> <br>
			 </td>
			 <td>
			  <input class="centr"> <br>
			  <input class="centr"> <br>
			  <input class="centr"> <br>
			 </td>
			</tr>
			
			</table>
			
		<!--  <div>
			<input type="submit" value="Registrar" name="CrearU" class="btn">
			<input type="submit" onclick="return confiupdate();" value="Actualizar" name="update" id="update" class="btn">
			<input type="submit" onclick="return confiborrar();" value="Eliminar" name="delete" id="delete" class="btn">  
			 </div> -->
	</fieldset>
</form>

</body>
</html>