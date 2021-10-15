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

<!-- sophia -->
<link rel="shortcut icon" href="images/favicon-96x96.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bodoni+Moda&display=swap" rel="stylesheet">

</head>

<body id="fondo">

<header>
		<nav class="op">
			<ul>	
			   <li><a href="Index.jsp" id="l">Ideal Beauty</a></li>
		       <li><a href="login.jsp">Login</a></li>
			</ul>
		</nav>
	<section class="container">
     <h1 class="title"> </h1>
     <h2 class="subtitle"> </h2>
   </section>
<div class="wave" style="height: 150px; overflow: hidden;" ><svg viewBox="0 0 500 150" preserveAspectRatio="none" style="height: 100%; width: 100%;"><path d="M-0.27,31.08 C149.99,150.00 378.38,-55.75 500.00,49.98 L500.00,150.00 L0.00,150.00 Z" style="stroke: none; fill: #fff;"></path></svg></div>
 
</header>

<div >
<img class="i" src="images/brochas.gif" width="500" height="500">
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
	<div class="footer__contact">
   <h3>Contactanos para cualquier inquietud de nuestros servicios</h3>
   <h3> telefono </h3>
   <p> 3211234567 </p>
   <h3 class="email"><a href="mailto:idealbeauty@gmail.com">idealbeauty@gmail.com</a></h3> 
   </div></div> 
   <h2 class="final_title">&copy; Ideal Beauty | D&M corporation</h2>
</footer>
</body>
</html>