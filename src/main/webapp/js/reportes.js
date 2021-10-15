$(document).ready(function(){	

function listarClientes(){	
    
	$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"clientes"},
	success:function(result){
		console.log(result)
		var  btnExportar = document.querySelector("#btnExportar");
		var h3 = document.querySelector("#titulo-reporte")
		var tabla=document.querySelector("#tabla")
		 
	     h3.innerHTML=`<h3>Listado de Clientes</h3>`
         btnExportar.innerHTML=`<button style="display: inline">Exportar Datos a Excel</button>`         
         tabla.innerHTML=''      
         tabla.innerHTML+=`<thead>
        <tr>
		<th align="center">Cedula</th>
		<th align="center">Nombre</th>
		<th align="center">Correo Electronico</th>
		<th align="center">Direccion</th>
		<th align="center">Telefono</th>
		</tr>
		</thead>`        
        
       for(let cli of result){
			tabla.innerHTML+=`<tr>
			<td>${cli.cedula_cliente}</td>
			<td>${cli.nombre_cliente}</td>
			<td>${cli.email_cliente}</td>			
			<td>${cli.direccion_cliente}</td>
			<td>${cli.telefono_cliente}</td>
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
		var  btnExportar = document.querySelector("#btnExportar");
		var h3 = document.querySelector("#titulo-reporte")
		var tabla=document.querySelector("#tabla")
		 
	     h3.innerHTML=`<h3>Listado de Usuarios</h3>`
         btnExportar.innerHTML=`<button style="display: inline">Exportar Datos a Excel</button>` 
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
			<td>${usu.usuario}</td>
			<td>${usu.password}</td>
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
		var  btnExportar = document.querySelector("#btnExportar");
		var h3 = document.querySelector("#titulo-reporte")
		var tabla=document.querySelector("#tabla")
		 
	     h3.innerHTML=`<h3>Listado de Productos</h3>`
         btnExportar.innerHTML=`<button style="display: inline">Exportar Datos a Excel</button>` 
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
		var  btnExportar = document.querySelector("#btnExportar");
		var h3 = document.querySelector("#titulo-reporte")
		var tabla=document.querySelector("#tabla")
		 
	     h3.innerHTML=`<h3>Listado de Proveedores</h3>`
         btnExportar.innerHTML=`<button style="display: inline">Exportar Datos a Excel</button>` 
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

function ventasClientes(){
	console.log("Entro en la funcion listarLibros");
    
	$.ajax({
	type:"post",
	url:"Reportes",
	dataType:"json",
	data:{opcion:"ventascliente"},
	success:function(result){
		console.log(result)
		var totalventas=0;
		var  btnExportar = document.querySelector("#btnExportar");
		var h3 = document.querySelector("#titulo-reporte")
		var tabla=document.querySelector("#tabla")
		
		h3.innerHTML=`<h3>Total de Ventas por Cliente</h3>`  
		btnExportar.innerHTML=`<button style="display: inline">Exportar Datos a Excel</button>` 
		tabla.innerHTML=''      
        tabla.innerHTML+=`<thead>
        <tr>
		<th align="center">Cedula</th>
		<th align="center">Nombre</th>
		<th align="center">Valor Total Ventas</th>
		</tr>
		</thead>`        
       
       for(let vencli of result){
	        totalventas+=vencli.valor_venta;
			tabla.innerHTML+=`<tr>
			<td>${vencli.cedula_cliente}</td>
			<td>${vencli.nombre_cliente}</td>
			<td>${vencli.valor_venta}</td>						
			</tr>`
		} 		
		
		tabla.innerHTML+=`<tr>
			<td></td>	
			<td style="font-weight: bold;">Total Ventas $</td>	
			<td style="font-weight: bold;">${totalventas}</td>
			</tr>`
						
		}
	})	
}


$('.listaUsuario').on('click',function(){
	var btn_1 = document.getElementById('btnExportar');
	listarUsuarios();
	btn_1.style.display = 'inline';
    })
    

$('.listaCliente').on('click',function(){
	var btn_1 = document.getElementById('btnExportar'); 
	listarClientes();
	btn_1.style.display = 'inline';
    })

$('.listaProducto').on('click',function(){
	var btn_1 = document.getElementById('btnExportar');
	listarProductos();
	btn_1.style.display = 'inline';
    })

$('.listaProveedor').on('click',function(){
	var btn_1 = document.getElementById('btnExportar'); 
	listarProveedores() ;
	btn_1.style.display = 'inline';
    })

$('.ventaCliente').on('click',function(){	 
	var btn_1 = document.getElementById('btnExportar'); 
	ventasClientes();
	btn_1.style.display = 'inline';
    })
 

})



