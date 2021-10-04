$(document).ready(function(){

let i=0
function linea(){
	i=i+1
	var tabla=document.querySelector("#productos")

	tabla.innerHTML+=`
						<tr>
			 				<th><input id="prod${i}"  class="codpr"></input> <input type="submit" value="Consultar" class="btn1" ></th>
			 				<th><input id="nompro${i}" class="inptransp" disabled></input></th>
			 				<th><input class="inptransp" id="a${i}" ></input></th>
			 				<th><input id="b${i}" class="peq"></input></th>
			 				<th id="tot${i}">_____________</th>
			 			</tr>`

}

function mul(){
	
	let totven=0
	for(let mul=1; mul<=i; mul++){
		
		var n1=parseInt(document.getElementById("a"+mul).value);
		/*alert(n1);*/
		var n2=parseInt(document.getElementById("b"+mul).value);
		var mult=n1*n2
		
		totven=totven+mult
		console.log("tot es "+mult)
		/*alert(mult);*/
		
		var tot=document.querySelector("#tot"+mul)
		tot.innerHTML=mult;
	}
	var totvjs=document.querySelector("#totv")
	totvjs.innerHTML=totven;
	
	var totiva=totven*0.19
	var totivajs=document.querySelector("#totiva")
	totivajs.innerHTML=totiva;
	
	var totveiva= totiva+totven
	var totveivajs=document.querySelector("#totveiva")
	totveivajs.innerHTML=totveiva
	 	
}

$('#mas').on('click', function(){
	linea()
});


$('#mult').on('click', function(){
	mul()
});

});


