<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="botones.css">
<link rel="stylesheet" type="text/css" href="Admin.css">
 <head>
	<meta charset="ISO-8859-1">
	
	<title>Registro de Productos</title>
	
</head>
<body background="images/fondomodulos10.jpg">

<%
	Conexion con=new Conexion();
    String mensaje="";
%>
<%!String mensaje="";
	long codigo;
	double ivacompra;
	long nit;
	String nombre="";
	double preciocompra;
	double precioventa;	
	String estado="";
%>

<%
	if(request.getParameter("codigo")!=null){
		codigo=Long.parseLong(request.getParameter("codigo"));
		ivacompra=Double.parseDouble(request.getParameter("iva"));
		nit=Long.parseLong(request.getParameter("nit"));
		nombre=request.getParameter("nombre");
		preciocompra=Double.parseDouble(request.getParameter("preciocompra"));
		precioventa=Double.parseDouble(request.getParameter("precioventa"));		
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
	codigo=0L;
	ivacompra=0;
	nit=0L;
	nombre="";
	preciocompra=0;
	precioventa=0;
	estado="";
		
	mensaje=request.getParameter("men");
}
%>

<%
	if(request.getParameter("men")!=null){
		
		codigo=0L;
		ivacompra=0;
		nit=0L;
		nombre="";
		preciocompra=0;
		precioventa=0;	
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

<form action="Producto" method="post">
	<fieldset>
		<legend><h2>Productos</h2></legend>
		<div>
			<label class="l1">Codigo Producto</label>
			<input type="number" name="codigo_producto" placeholder="Ingrese codigo producto" value="<%=codigo%>" required <%=estado%>>
		</div>
		<input type="hidden" name="cod" value="<%=codigo%>">
		<div>
			<label class="l1">Nombre</label>
			<input type="text" name="nombre_producto" placeholder="Ingrese nombre producto" value="<%=nombre%>" required>
		</div>
		<div>
			<label class="l1">Nit Proveedor</label>
			<input type="number" name="nitproveedor" value="<%=nit%>" required <%=estado%>>
		</div>
		<input type="hidden" name="nitoculto" value="<%=nit%>">
		<div>
			<label class="l1">Iva de Compra</label>
			<input type="number" name="iva_compra" value="<%=ivacompra%>" required <%=estado%>>
		</div>
		<input type="hidden" name="ivaoculto" value="<%=ivacompra%>">
		<div>
			<label class="l1">Precio Compra</label>
			<input type="numbrer" name="precio_compra" value="<%=preciocompra%>" <%=estado%>>
		</div>
		<input type="hidden" name="preciocomoculto" value="<%=preciocompra%>">
		<div>
			<label class="l1">Precio Venta</label>
			<input type="number" name="precio_venta" value="<%=precioventa%>">
		</div>
		
		
		  <table style="margin: 0 auto;">
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
			  <input type="submit" onclick="return confiborrar();"  value="Eliminar" name="delete" id="delete" class="btn">
		     </td>
		     <td>
			  <input type="submit" value="Limpiar" name="limpiar" class="btn">
		     </td>
		    
		  </tr> 
		  		 
		   
		  </table>
		
		
	</fieldset>
</form>


<form action="Producto" method="post">
<fieldset>
<legend><h2>Consultar</h2></legend>

<div><label class="l1">Codigo Producto: </label><input type="number" name="codigo_producto2" required></div>
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