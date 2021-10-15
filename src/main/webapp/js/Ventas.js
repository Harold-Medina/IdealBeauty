$(document).ready(function(){

let i=3
function linea(){
	i=i+1
	var tabla=document.querySelector("#productos")

	tabla.innerHTML+=`
						<tr>
			 				<th><input id="prod${i}"  class="codpr"></input> <input type="submit" value="Consultar" class="btn1" ></th>
			 				<th><input id="nompro${i}" class="inptranspp" disabled></input></th>
			 				<th><input class="inptranspp" id="a${i}" ></input></th>
			 				<th><input id="b${i}" class="peq"></input></th>
			 				<th id="tot${i}">_____________</th>
			 			</tr>`

}

function mul(){
	
	let totven=0
	let ivatotalfinal=0
	let mult=null
	
	for(let mul=1; mul<=3; mul++){
		
		var n1=parseInt(document.getElementById("a"+mul).value);
		//alert(n1);
		var n2=parseInt(document.getElementById("b"+mul).value);
		//alert(n2);
		var n3=parseInt(document.getElementById("iva"+mul).value);
		
		if(isNaN(n1)+isNaN(n2)){}else{
		 mult=n1*n2
		var totiva=n3/100*mult
		var prodtot=mult+totiva
		
		totven=totven+mult
		ivatotalfinal=ivatotalfinal+totiva
		
		
		console.log("tot es "+mult)
		//alert(mult);
		
		//var tot=document.querySelector("#tot"+mul)
		//tot.innerHTML=mult;
		document.getElementById("valven"+mul).value=mult.toFixed();
		document.getElementById("totiva"+mul).value=totiva.toFixed();
		document.getElementById("prodtot"+mul).value=prodtot.toFixed();
		document.getElementById("copiaprodtot"+mul).value=prodtot.toFixed();
		}	
	}
	if(mult=null){}else{
			
	document.getElementById("copiatotv").value=totven.toFixed();
	document.getElementById("totv").value=totven.toFixed();
	
	document.getElementById("copiaivatotalfinal").value=ivatotalfinal.toFixed();
	document.getElementById("ivatotalfinal").value=ivatotalfinal.toFixed();
	
	var totveiva= ivatotalfinal+totven

	document.getElementById("copiatotveiva").value=totveiva.toFixed();
	document.getElementById("totveiva").value=totveiva.toFixed();
	
	}
	 	
}

$('#mas').on('click', function(){
	linea()
});


$('#mult').on('click', function(){
	mul()
});

});


