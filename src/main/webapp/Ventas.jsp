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

<form action="Venta" method="post">

	<fieldset>
		<legend><h2>ventas</h2></legend>
			<!--  <section>
			<label>C�dula</label>
			<input type="number" placeholder="ingrese su n�mero C�dula" name="cedula" value="<%=cedula%>" required <%=estado%>>
			<input type="submit" name="consultar" value="Consultar" class="btn">
			<label>C�dula</label>
			<input type="number" placeholder="ingrese su n�mero C�dula" name="cedula" value="<%=cedula%>" required <%=estado%>>
			<label>C�dula</label>
			<input type="number" placeholder="ingrese su n�mero C�dula" name="cedula" value="<%=cedula%>" required <%=estado%>>
			</section> -->
			
			<table id=tablaV>
			<tr>
			 <th>
			  <label class=izq >C�dula Usuario</label>
			  <input type="number" class="der" placeholder="ingrese C�dula" name="cedulaUsu" value="<%=cedula%>" required <%=estado%>>
			  <br>
			  <label class=izq >C�dula Cliente</label>
			  <input type="number" class="der" placeholder="ingrese C�dula" name="cedulaCli" value="<%=cedula%>" required <%=estado%>>
			  
			 </th>
			 <th>
			  <label>Usuario</label>
			  <input type="number" class="der" placeholder="Presione en validar" name="nombreUsu" value="<%=cedula%>" disabled<%=estado%>>
			  <br>
			  <label>Cliente</label>
			  <input type="number" class="der" placeholder="Presione en validar" name="nombreCli" value="<%=cedula%>" disabled<%=estado%>>
			 </th>
			 <th>
			  <label>Consecutivo</label>
			  <input type="number" placeholder="Presione en validar" name="Consecutivo" value="<%=cedula%>" disabled>
			  <br>
			  <input type="submit" name="validar" value="validar" class="btn1 centr">
			 </th>
			</tr>
			
			<tr>
			 <td>
			  <label>C�digo del producto</label> <br>
			  <input> <input type="submit" name="consultar" value="Consultar" class="btn1"><br>
			  <input> <input type="submit" name="consultar" value="Consultar" class="btn1"><br>
			  <input> <input type="submit" name="consultar" value="Consultar" class="btn1"><br>
			 </td>
			 <td>
			  <label class=izq>nombre producto</label><label class=der> Cantidad</label> <br>
			  <input class=izq disabled> <input class="der peq" ><br>
			  <input class=izq disabled> <input class="der peq" ><br>
			  <input class=izq disabled> <input class="der peq" ><br>
			 </td>
			 <td>
			  <label style="margin: 0 30%;">Valor Total</label> <br>
			  <input class="centr" disabled> <br>
			  <input class="centr" disabled> <br>
			  <input class="centr" disabled> <br>
			 </td>
			</tr>
			<tr>
			 <td></td>
			 <td>
			  <input type="submit" name="calcular" value="Calcular" class="btn1 izq "> <br>  <label class=der> Total venta</label> <br>
			  <input type="submit" name="consultar" value="Confirmar" class="btn1 izq btnV"> <label class=der> Total IVA</label> <br>
			  <label class=der> Total con IVA</label> <br>
			 </td>
			 <td>
			  <input class="centr" disabled> <br>
			  <input class="centr" disabled> <br>
			  <input class="centr" disabled> <br>
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