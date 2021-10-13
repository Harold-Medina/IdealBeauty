
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

/*NUEVO DANIEL*/
String nompro1="", costu1="",iva1="",prod1="", valven1="",totiva1="",prodtot1="";
String nompro2="", costu2="",iva2="",prod2="", valven2="",totiva2="",prodtot2="";
String nompro3="", costu3="",iva3="",prod3="", valven3="",totiva3="",prodtot3="";
/**/

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
if(request.getParameter("welcome")!=null)
{
	mensaje=request.getParameter("welcome");
	out.print("<script>alert('"+mensaje+"')</script>");
}
%>
<%
if(request.getParameter("mens")!=null)
{
	cedulaUsuario="";cedulaCliente="";
	nombreUsuario="";nombreCliente="";
	consecutivo="";
	mensaje=request.getParameter("mens");
	/*NUEVO DANIEL*/
	prod1="";prod2="";prod3="";
	nompro1="";nompro2="";nompro3="";
	costu1="";costu2="";costu3="";
	iva1="";iva2="";iva3="";
	/**/
	
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

<%
if (request.getParameter("limpiar")!=null)
	{cedulaUsuario="";cedulaCliente="";
	nombreUsuario="";nombreCliente="";
	consecutivo="";
	prod1="";prod2="";prod3="";
	nompro1="";nompro2="";nompro3="";
	costu1="";costu2="";costu3="";
	iva1="";iva2="";iva3="";
	estado="enabled";
	}
%>

<%
if(request.getParameter("nompro1")!=null){
	nompro1=request.getParameter("nompro1");
}
if(request.getParameter("costu1")!=null){
	costu1=request.getParameter("costu1");
}
if(request.getParameter("iva1")!=null){
	iva1=request.getParameter("iva1");
}
if(request.getParameter("prod1")!=null){
	prod1=request.getParameter("prod1");
}
if(request.getParameter("prod1")!=null){
	prod1=request.getParameter("prod1");
}

%>
<%
if(request.getParameter("nompro2")!=null){
	nompro2=request.getParameter("nompro2");
}
if(request.getParameter("costu2")!=null){
	costu2=request.getParameter("costu2");
}
if(request.getParameter("iva2")!=null){
	iva2=request.getParameter("iva2");
}
if(request.getParameter("prod2")!=null){
	prod2=request.getParameter("prod2");
}
if(request.getParameter("prod1")!=null){
	prod2=request.getParameter("prod2");
}

%>
<%
if(request.getParameter("nompro3")!=null){
	nompro3=request.getParameter("nompro3");
}
if(request.getParameter("costu3")!=null){
	costu3=request.getParameter("costu3");
}
if(request.getParameter("iva3")!=null){
	iva3=request.getParameter("iva3");
}
if(request.getParameter("prod3")!=null){
	prod3=request.getParameter("prod3");
}
if(request.getParameter("prod3")!=null){
	prod3=request.getParameter("prod3");
}

%>

<!-- daniel -->

<body>
<header id="o">
		<nav class="op">
			<ul>	
			   <li class="izq"><a href="Index.jsp" id="l">Ideal Beauty</a></li>
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
			  <input type="number" placeholder="ingrese Cédula" name="cedulaUsu1" value="<%=cedulaUsuario%>" <%=estado%> required>
			  <input placeholder="ingrese Cédula" name="cedulaUsu" value="<%=cedulaUsuario%>"  type="hidden">
			 </th>
			 <th>
			  <input type="text" placeholder="nombre usuario" name="nombreUsu" value="<%=nombreUsuario%>" class="inptransp nombre" <%=estado%>>
			  </th>
			 <th>
			  <label>Consecutivo</label>
			  <input type="text" name="Consecutivo" value="<%=consecutivo%>" class="inptransp" ><!-- disabled -->
			 </th>
			</tr>
			<tr>
			 <th>
			  <label>Cliente</label>
			  <input type="number" placeholder="ingrese Cédula" name="cedulaCli1" value="<%=cedulaCliente%>" <%=estado%> required>
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
			 				<th>valor total</th>
			 			</tr>
			 		</thead>
			 		<!-- NUEVO DANIEL --> <!-- quite los disabled -->
			 		<tbody>
				 		<tr>
			 				<th>
								<input id="prod1" name="prod1" value="<%=prod1%>" class="codpr" type="number">
								<input id="cons1" type="submit" name="Consultar1" value="Ok" class="btn1"></th>
			 				<th><input id="nompro" name="nompro1" value="<%=nompro1%>" class="inptransp" ></th><!-- disabled -->
			 				<th><input id="a1" name="costu1" value="<%=costu1%>" class="inptransp" ></th><!-- disabled -->
			 				<th><input id="b1" name="cant1" class="peq" type="number"></th>
			 				<th><input id="prodtot1" name="prodtot1" value="<%=prodtot1%>" class="inptransp"  ></th> <!-- disabled -->
							<th><input type="hidden" id="iva1" name="iva1" value="<%=iva1%>" class="inptranspp" ></th><!-- disabled -->
			 				<th><input type="hidden" id="valven1" name="valven1" value="<%=valven1%>" class="inptranspp" ></th><!-- disabled -->
			 				<th><input type="hidden" id="totiva1" name="totiva1" value="<%=totiva1%>" class="inptranspp" ></th><!-- disabled -->
			 			</tr>
			 			<tr>
			 				<th>
								<input id="prod2" name="prod2" value="<%=prod2%>" class="codpr blue" type="number">
								<input id="cons2" type="submit" name="Consultar2" value="Ok" class="btn1"></th>
			 				<th><input id="nompro2" name="nompro2" value="<%=nompro2%>" class="inptransp" ></th><!-- disabled -->
			 				<th><input id="a2" name="costu2" value="<%=costu2%>" class="inptransp" ></th><!-- disabled -->
			 				<th><input id="b2" name="cant2" class="peq" type="number"></th>
			 				<th><input id="prodtot2" name="prodtot2" value="<%=prodtot2%>" class="inptransp"  ></th><!-- disabled -->
							<th><input type="hidden" id="iva2" name="iva2" value="<%=iva2%>" class="inptranspp" ></th><!-- disabled -->
			 				<th><input type="hidden" id="valven2" name="valven2" value="<%=valven2%>" class="inptranspp" ></th><!-- disabled -->
			 				<th><input type="hidden" id="totiva2" name="totiva2" value="<%=totiva2%>" class="inptranspp" ></th><!-- disabled -->
			 			</tr>
			 			<tr>
			 				<th>
								<input id="prod3" name="prod3" value="<%=prod3%>" class="codpr" type="number"></input>
								<input id="cons3" type="submit" name="Consultar3" value="Ok" class="btn1"></th>
			 				<th><input id="nompro3" name="nompro3" value="<%=nompro3%>" class="inptransp" ></th><!-- disabled -->
			 				<th><input id="a3" name="costu3" value="<%=costu3%>" class="inptransp" ></th><!-- disabled -->
			 				<th><input id="b3" name="cant3" class="peq" type="number"></th>
			 				<th><input id="prodtot3" name="prodtot3" value="<%=prodtot3%>" class="inptransp"  ></th><!-- disabled -->
							<th><input type="hidden" id="iva3" name="iva3" value="<%=iva3%>" class="inptranspp" ></th>
			 				<th><input type="hidden" id="valven3" name="valven3" value="<%=valven3%>" class="inptranspp" ></th><!-- disabled -->
			 				<th><input type="hidden" id="totiva3" name="totiva3" value="<%=totiva3%>" class="inptranspp" ></th><!-- disabled -->
			 			</tr>
				 	</tbody>
			 		<!-- daniel -->
			 	</table>
			 	</td>
			 </tr>
			<tr>
			 <td></td>
			 <td colspan="3">
			 		<table id="resultados">
			 			<tr>
			 				<!-- <td><input type="submit" name="calcular" value="Calcular" class="btn1" id="mult"></td> -->
			 				<td><input type="button" name="calcular" value="Calcular" class="btn1" id="mult"></td>
			 				<td><label> Total venta</label></td>
			 				<td ><input  id="totv" name="valorventa" type="text" class="inptransp"></td>
			 			</tr>
			 			<tr>
			 				<td><input type="submit" name="Confirmar" value="Confirmar" class="btn1 btnV"></td>
			 				<td><label> Total IVA</label></td>
			 				<td ><input  id="ivatotalfinal" name="ivatotal" type="text" class="inptransp"></td><!--  -->
			 			</tr>
			 			<tr>
			 				<td></td>
			 				<td><label> Total con IVA</label></td>
			 				<td ><input  id="totveiva" name="totalventa" type="text" class="inptransp"></td><!-- class="inptranspp" disabled></td> -->
			 			</tr>
			 		</table>
			 </td>
			 </tr>
			</table>
		<input type="submit" name="limpiar" value="limpiar" class="btn1">
	</Form>
	<!-- 
	<div>
		<button id="mas" class="btn1" >Agregar producto</button>
		<button type="submit" name="calcular" value="Calcular" class="btn1" id="mult">Calcular</button>
		
	</div>
	 -->
	</fieldset>
	
	
</body>
</html>