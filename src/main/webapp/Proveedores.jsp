
<%@page import="Controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="botones.css">
<link rel="stylesheet" type="text/css" href="Admin.css">
<head>
<meta charset="ISO-8859-1">
<title>Registro Proveedores</title>

</head>
<body background="images/fondomodulos8.jpg">

<%
	Conexion con=new Conexion();
    String mensaje=""; 
%>

<%!String mensaje="";
   String ciudad="";
   String direccion="";
   String nombre="";
   String telefono="";
   String estado="";
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
if (request.getParameter("reset")!=null){
estado="enabled";
}
%>

<%
if(request.getParameter("rest")!=null)
{
	nit=0L;
	ciudad="";
	direccion="";
	nombre="";
	telefono="";
	estado="";
	mensaje=request.getParameter("men");
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
	mensaje = request.getParameter("men");
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


<form action="Proveedor" method = "post" class=formul>
    <fieldset>
      <legend><h2>Proveedores</h2></legend>
      <table>
       <div>
          <label class="l1"> NIT</label>
            <input type="number" name="nitproveedor" value="<%=nit%>" <%=estado%> required>
			
		</div>
        <input type="hidden" name="nitprov" value="<%=nit%>">
        <div>
           <label class="l1">Teléfono</label>
           <input type="text"  name="telefono_proveedor" value="<%=telefono%>" required>
			
		</div>
        <div>
			<label>Nombre Proveedor</label>
			<input type="text"  name="nombre_proveedor" value="<%=nombre%>" required>
			
		</div>
        <div>
			<label>Ciudad</label>
			<input type="text" name="ciudad_proveedor" value="<%=ciudad%>" required>
	    </div>
        <div>
			<label class="l1">Dirección</label>
			<input type="text" name="direccion_proveedor" value="<%=direccion%>" required>
			
		</div>			
	  </table>
	  
	  <!--  tabla para los botones-->
		
		 <table style="margin: 0 auto;" >
		  <tr>
		     <td>
			  <label></label>
			 </td>
			
			 <td>
			  <input type="submit" name="registrar" value="Registrar" class="btn">
			 </td>
			 <td> 
		      <input type="submit" onclick="return confiupdate();" value="Actualizar" name="update"  id="update" class="btn">
			 </td>
			 <td>
			  <input type="submit" onclick="return confiborrar();" value="Eliminar" name="delete"  id="delete" class="btn">
		     </td>
		     <td>
			  <input type="submit" value="Limpiar" name="limpiar" class="btn">
		     </td>		    
		  </tr>   		 
	   </table>				
    
        
    </fieldset>
 </form>


 
<form action="Proveedor" method="post">
<fieldset>
<legend><h2>Consultar</h2></legend>
<div><label class="l1">NIT: </label><input type="number" name="nitproveedor2" required></div>
<div><input type="submit" name="consultar" value="Consultar" class="btn"></div>
</fieldset>
</form>

<script type="text/javascript">
	function confiborrar()
	{
		var respuesta = confirm("¿Seguro de eliminar este proveedor?");
		
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
		var respuesta = confirm("¿Seguro de actualizar este proveedor?");
		
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
  

</div>
</body>
</html>