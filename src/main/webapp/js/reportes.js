$(document).ready(function(){	

function listarClientes(){	
    
	$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"clientes"},
	success:function(result){
		console.log(result)
		var h3 = document.querySelector("#titulo-reporte")
		var tabla=document.querySelector("#tabla")
		 
	     h3.innerHTML=`<h3>Listado de Clientes</h3>`
         tabla.innerHTML=''      
         tabla.innerHTML+=`<thead>
        <tr>
		<th align="center">Cedula</th>
		<th align="center">Nombre</th>
		<th align="center">Correo Electronico</th>
		<th align="center">Dirección</th>
		<th align="center">Telefono</th>
		</tr>
		</thead>`        
        
       for(let cli of result){
			tabla.innerHTML+=`<tr>
			<td>${cli.cedula_cliente}</td>
			<td>${cli.nombre_cliente}</td>
			<td>${cli.email_cliente}</td>						
			<td>${cli.telefono_cliente}</td>
			<td>${cli.direccion_cliente}</td>
			</tr>`
		} 		
		 
		
		}
	})	
}

function listarUsuarios(){
	
    
	$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"usuarios"},
	success:function(result){
		console.log(result)
		var h3 = document.querySelector("#titulo-reporte")
		var tabla=document.querySelector("#tabla")
		 
	     h3.innerHTML=`<h3>Listado de Usuarios</h3>`
         tabla.innerHTML=''      
         tabla.innerHTML+=`<thead>
        <tr>
		<th align="center">Cedula</th>
		<th align="center">Nombre</th>
		<th align="center">Correo Electronico</th>
		<th align="center">Usuario</th>
		<th align="center">Password</th>
		</tr>
		</thead>`        
        
       for(let usu of result){
			tabla.innerHTML+=`<tr>
			<td>${usu.cedula_usuario}</td>
			<td>${usu.nombre_usuario}</td>
			<td>${usu.email_usuario}</td>						
			<td>${usu.password}</td>
			<td>${usu.usuario}</td>
			</tr>`
		} 		
		 
		
		}
	})	
}


function listarProductos(){
	    
	$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"productos"},
	success:function(result){
		console.log(result)
		var h3 = document.querySelector("#titulo-reporte")
		var tabla=document.querySelector("#tabla")
		 
	     h3.innerHTML=`<h3>Listado de Productos</h3>`
         tabla.innerHTML=''      
         tabla.innerHTML+=`<thead>
        <tr>
		<th align="center">Codigo</th>
		<th align="center">Nombre</th>
		<th align="center">Iva Compra</th>
		<th align="center">Nit Proveedor</th>
		<th align="center">Precio Compra</th>
		<th align="center">Precio Venta</th>
		</tr>
		</thead>`        
        
       for(let prod of result){
			tabla.innerHTML+=`<tr>
			<td>${prod.codigo_producto}</td>
			<td>${prod.nombre_producto}</td>
			<td>${prod.ivacompra}</td>						
			<td>${prod.nitproveedor}</td>
			<td>${prod.precio_compra}</td>
			<td>${prod.precio_venta}</td>
			</tr>`
		} 		
		 
		
		}
	})	
}

function listarProveedores(){
	    
	$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"proveedores"},
	success:function(result){
		console.log(result)
		var h3 = document.querySelector("#titulo-reporte")
		var tabla=document.querySelector("#tabla")
		 
	     h3.innerHTML=`<h3>Listado de Proveedores</h3>`
         tabla.innerHTML=''      
         tabla.innerHTML+=`<thead>
        <tr>
		<th align="center">Nit</th>
		<th align="center">Nombre</th>
		<th align="center">Ciudad</th>
		<th align="center">Direccion</th>
		<th align="center">Telefono</th>
		</tr>
		</thead>`        
        
       for(let prov of result){
			tabla.innerHTML+=`<tr>
			<td>${prov.nitproveedor}</td>
			<td>${prov.nombre_proveedor}</td>
			<td>${prov.ciudad_proveedor}</td>						
			<td>${prov.direccion_proveedor}</td>
			<td>${prov.telefono_proveedor}</td>
			</tr>`
		} 		
		 
		
		}
	})	
}

$('.listaUsuario').on('click',function(){
	 
	listarUsuarios();
    })
    

$('.listaCliente').on('click',function(){
	 
	listarClientes();
    })

$('.listaProducto').on('click',function(){
	 
	listarProductos();
    })

$('.listaProveedor').on('click',function(){
	 
	listarProveedores() ;
    })
 
 

})



