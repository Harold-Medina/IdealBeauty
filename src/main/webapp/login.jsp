<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
<style type="text/css">
  <%@include file="login.css" %>
</style>
</head>
<!-- ULTIMO COMENTARIO-->
<body>

<%! String msgg=""; %>
	<div class="log">
			
		<div class="log1">
			<form action="loginn" method="post" id="formul">
			    <div class="input">
			    	<h1 id="ideal"><a href="index.jsp" id="principal">Ideal Beauty</a></h1>
			    </div>
			    <hr>			
			    <div > 
			        <input type="text" placeholder="Ingrese su usuario" name="usuario-user" class="input1" required>
			    </div>
			    <div>
			        <input type="password" placeholder="Ingrese su Contraseña" name="clave-user" class="input1" id="inp2" required>
			    </div>			    
			   <div id=status>
					<h5 style=" text-align: right; margin:0px;"><%
					if(request.getParameter("mens")!=null)
					{
					msgg=request.getParameter("mens");
					}
					%>
					<%=msgg %></h5>
				</div>
			    <div>
			        <div><input type="submit" value="Aceptar" name="enviar"  class="boton"></div>
			        <div><a href="index.jsp"><input type="button" value="Cancelar" class="boton"></a></div>
			   </div>
			   <hr>
			</form>
		</div>
		
	</div>
	
	</body>
</html>