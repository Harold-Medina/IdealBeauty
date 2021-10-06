
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
String cedulaUsuario="",cedulaCliente="",consecutivo="";
String email="",nombreUsuario="",nombreCliente="",clave="",usuario="",estado="";
String mensaje="";
%>

<%
if (request.getParameter("cedulaUsu")!=null){
cedulaUsuario= request.getParameter("cedulaUsu");
nombreUsuario=request.getParameter("nombreUsu");
}
if (request.getParameter("cedulaCli")!=null){
cedulaCliente= request.getParameter("cedulaCli");
nombreCliente=request.getParameter("nombreCli");
}
if (request.getParameter("nombreCli")!=null){
consecutivo=request.getParameter("consecutivo");
}
%>

<%
if(request.getParameter("mens")!=null)
{
	cedulaUsuario="";cedulaCliente="";
	nombreUsuario="";nombreCliente="";
	consecutivo="";
	mensaje=request.getParameter("mens");
	out.print("<script>alert('"+mensaje+"')</script>");
}
%>

<%
if (request.getParameter("nombreCli")!=null){
estado="disabled";
}
if(request.getParameter("mens")!=null)
{estado="enabled";
}
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
		<Form action="Venta" method="post"> 
			<table id=tablaV>
			<tr>
			 <th>
			  <label>Usuario</label>
			  <input type="number" placeholder="ingrese Cédula" name="cedulaUsu1" value="<%=cedulaUsuario%>"  <%=estado%>>
			  <input placeholder="ingrese Cédula" name="cedulaUsu" value="<%=cedulaUsuario%>"  type="hidden">
			 </th>
			 <th>
			  <input type="text" placeholder="nombre usuario" name="nombreUsu" value="<%=nombreUsuario%>" class="inptransp" <%=estado%>>
			  </th>
			 <th>
			  <label>Consecutivo</label>
			  <input type="text" name="Consecutivo" value="<%=consecutivo%>" class="inptransp" disabled>
			 </th>
			</tr>
			<tr>
			 <th>
			  <label>Cliente</label>
			  <input type="number" placeholder="ingrese Cédula" name="cedulaCli1" value="<%=cedulaCliente%>" <%=estado%>>
			  <input placeholder="ingrese Cédula" name="cedulaCli" value="<%=cedulaCliente%>" type="hidden">
			 </th>
			 <th>
			  <input type="text" placeholder="nombre cliente" name="nombreCli" value="<%=nombreCliente%>" class="inptransp" <%=estado%>>
			 </th>
			 <th>
			 	<input type="submit" name="Validar" value="Validar" class="btn1" > 
			</th> 
			</tr>
			<tr>
			 <td colspan="3" colspan="2">
			<!--  <button id="mas" class="btn1" >Agregar producto</button> -->
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
			 	</td>
			 </tr>
			<tr>
			 <td></td>
			 <td colspan="3">
			 		<table id="resultados">
			 			<tr>
			 				<!-- <td><input type="submit" name="calcular" value="Calcular" class="btn1" id="mult"></td> -->
			 				<td></td>
			 				<td><label> Total venta</label></td>
			 				<td ><input  id="totv" name="valorventa" type="text" class="inptransp"></td>
			 			</tr>
			 			<tr>
			 				<td><input type="submit" name="Confirmar" value="Confirmar" class="btn1"></td>
			 				<td><label> Total IVA</label></td>
			 				<td ><input  id="totiva" name="ivatotal" type="text" class="inptransp"></td>
			 			</tr>
			 			<tr>
			 				<td></td>
			 				<td><label> Total con IVA</label></td>
			 				<td ><input  id="totveiva" name="totalventa" type="text" class="inptransp"></td>
			 			</tr>
			 		</table>
			 </td>
			 </tr>
			</table>
	</Form>
	<div>
		<button id="mas" class="btn1" >Agregar producto</button>
		<input type="submit" name="calcular" value="Calcular" class="btn1" id="mult">
	</div>	
	</fieldset>
	
	
</body>
</html>