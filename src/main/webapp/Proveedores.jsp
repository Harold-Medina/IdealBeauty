<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="Admin.css">
<head>
<meta charset="ISO-8859-1">
<title>Registro Proveedores</title>

</head>
<body>

<%
	Conexion con=new Conexion();
%>

<%!String mensaje="",ciudad="",direccion="",nombre="",telefono="",  estado="";
long nit=0L;
%>

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


<form action="Proveedor" method = "post" class=formul>
    <fieldset>
      <legend><h2>Proveedores</h2></legend>
       <div>
          <label class="l1"> NIT   </label>
            <input type="number" name="nitproveedor" value="<%=nit%>" <%=estado%> required>
			
		</div>
        <input type="hidden" name="nitprov" value="<%=nit%>">
        <div>
           <label class="l1">Teléfono </label>
           <input type="text"  name="telefono_proveedor" value="<%=telefono%>" required>
			
		</div>
        <div>
			<label>Nombre Proveedor </label>
			<input type="text"  name="nombre_proveedor" value="<%=nombre%>" required>
			
		</div>
        <div>
			<label>Ciudad</label>
			<input type="text" name="ciudad_proveedor" value="<%=ciudad%>" required>
	    </div>
        <div>
			<label class="l1">Dirección </label>
			<input type="text" name="direccion_proveedor" value="<%=direccion%>" required>
			
		</div>	  
		
		<div>
			<input type="submit" name="registrar" value="Registrar" class="btn">
			<input type="submit" name="actualizar" value="Actualizar" class="btn">
			<input type="submit" name="eliminar" value="Eliminar" class="btn">
		</div>   		
    
        
    </fieldset>
 </form>


 
<form action="Proveedor" method="post">
<fieldset>
<legend><h2>Consultar</h2></legend>
<div><label class="l1">NIT: </label><input type="number" name="nitproveedor2" required></div>
<div><input type="submit" name="consultar" value="Consultar" class="btn"></div>
</fieldset>
</form>
   
  <h2><%=mensaje %></h2> 
  

</div>
</body>
</html>