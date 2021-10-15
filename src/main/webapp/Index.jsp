<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ideal Beauty</title>

<!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link href="css/estilos.css" rel="stylesheet">

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="Index.css">
</head>

<body id="fondo">

<header>
		<nav class="op">
			<ul>	
			   <li><a href="Index.jsp" id="l">Ideal Beauty</a></li>
		       <li><a href="login.jsp">Login</a></li>
			</ul>
		</nav>
</header>

<div >
<img class="i" src="images/girl2.jpg" width="500" height="500">
</div>
<label></label>


<!--Catalogo de Productos-->
  <main>
    <div class="container">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        
        <div class="col">
          <div class="card shadow-sm">
          
            <img src="images/cremasrostro.jpg">
            <div class="card-body">
              <h5 class="card-title">Crema para el Rostro</h5>
               <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                </div>
               </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <img src="images/cremacorporal.jpg" width="360" height="200" >
            <div class="card-body">
              <h5 class="card-title">Crema Corporal</h5>
               <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                </div>
               </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <img src="images/labiales2.jpg" width="360" height="200">
            <div class="card-body">
              <h5 class="card-title">Labiales</h5>
               <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                </div>
               </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <img src="images/esmaltes.jpg" width="360" height="240"">
            <div class="card-body">
              <h5 class="card-title">Esmaltes</h5>
               <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                </div>
               </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <img src="images/exfoliante.jpg" width="360" height="240">
            <div class="card-body">
              <h5 class="card-title">Exfoliantes</h5>
               <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                </div>
               </div>
            </div>
          </div>
        </div>
        
        <div class="col">
          <div class="card shadow-sm">
            <img src="images/hidratante.jpg" width="360" height="240">
            <div class="card-body">
              <h5 class="card-title">Hidratantes</h5>
               <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                </div>
               </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>

<label></label>


<div class="bk2">
    <div class="cont2"><article class="b"> 
	    <h1 class="b"> ¿Quiénes somos?</h1>
	    <p class="b">  Somos una empresa que busca resaltar la belleza nata de cada cliente, por ello, ofrecemos los mejores productos para el cuidado de la estética facial corporal y capilar. Además, contamos con una calidad de productos totalmente premium que garantiza resultados excelentes.
Por otro lado, también contamos con productos de maquillaje para que pueda demostrar su belleza ideal ante el mundo. Nuestro propósito es demostrar al mundo que cada ser humano posee belleza en sí mismo</p></article> 
    </div> 

</div>

<footer>
	<div>
	    <h3>SOMOS UNA EMPRESA EMPRENDEDORA</h3> <P1>llámanos o escríbenos para cualquier inquietud de nuestros servicios </P1> <p>-3211234567-</p><h><a href="mailto:idealbeauty@gmail.com">email</a></h>	
</div>
</footer>
</body>
</html>