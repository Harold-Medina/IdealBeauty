<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Proveedores</title>
<style type="text/css">
  <%@include file="MenuAdmin.css" %>
</style>
</head>
<body id="fondo">
<%!String mensaje="",ciudad="",direccion="",nombre="",telefono="",  estado="";
long nit=0L;
%>
<!-- ULTIMO COMENTARIO-->
<%
//recogemos la respuesta del servlet y la asociamos a variables
if (request.getParameter("nit")!=null){
	nit=Long.parseLong(request.getParameter("nit"));
	ciudad=request.getParameter("ciudad");
	direccion=request.getParameter("direccion");	
	nombre=request.getParameter("nombre");
	telefono=request.getParameter("telefono");
	estado="disabled";
}
%>

<%
if(request.getParameter("men")!=null){
	nit=0L;
	ciudad="";
	direccion="";
	nombre="";
	telefono="";
	estado="";
	mensaje = request.getParameter("men");}
    //codigo javascript, mensaje con alert de javascript
    //out.print("<script>alert('"+mensaje+"');</script>");
%>

<div class="content">
<div class="box-area">
		<header>
			<div class="wrapper">
				<div class="logo">
					<a href="Index.jsp">Ideal Beauty</a>
				</div>
				<nav>
					<a href="MenuAdmin.jsp">Usuarios</a>
                    <a href="Clientes.jsp">Clientes</a>
                    <a href="Proveedores.jsp">Proveedores</a>
                    <a href="#">Productos</a>
                    <a href="#">Ventas</a>
                    <a href="#">Reportes</a>
				</nav>
			</div>
		</header>
	</div>
<hr>

<form action="Proveedor" method = "post" class=formul>
    <table class="tablit">
        <caption>Ingrese los datos para crear un nuevo proveedor</caption>
        	<tr><th id="padin"><label>NIT</label>
        	<input type="number" placeholder="Ingrese NIT proveedor" name="nitproveedor" value="<%=nit%>" <%=estado%> required>
        	<input type="hidden" name="nitprov" value="<%=nit%>">
        	</th>
        	<th id="padin"><label>Teléfono</label>
    		<input type="text" placeholder="Ingrese telefono proveedor" name="telefono_proveedor" value="<%=telefono%>" required></th>
        	
        	</tr>
        	<tr><th id="padin"><label>Nombre Proveedor</label>
    		<input type="text" placeholder="Ingrese nombre de proveedor" id="proveedor" name="nombre_proveedor" value="<%=nombre%>" required></th>
        	<th id="padin"><label>Ciudad</label>
        	<input type="text" placeholder="Ingrese ciudad proveedor" name="ciudad_proveedor" value="<%=ciudad%>" required></th>
        	</tr>
        	<tr><th id="padin"><label>Dirección</label>
        	<input type="text" placeholder="Ingrese direccion proveedor" name="direccion_proveedor" value="<%=direccion%>" required></th></tr>
    </table>
    <div class="boton">
       
        <input type="submit" name="registrar" value="Registrar" >
        <input type="submit" name="actualizar" value="Actualizar" >
        <input type="submit" name="eliminar" value="Eliminar" >
    </div>
 </form>
   
 <form action="Proveedor" method = "post">			
		<div><label class="titulosconsultar" >Cedula :</label><input type="number" name="nitproveedor2" required></div>
		<div><input type="submit" name="consultar" value="Consultar"></div> 	
 </form> 
    
    

</div>
</body>
</html>