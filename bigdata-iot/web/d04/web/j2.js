/**
 * 
 */

var i = 100;
var i = 214;
alert('start: '+i);
window.onload = function(){
	document.querySelector('h2').innerHTML = "START.."
}; //순차실행되기 땜에 	h2 뿌려지기 전이라 오류남 > 모두 뿌리고 실행할수있도록 onload


function myFunction(){
	var data = 10;
	//alert('OK '+data);
	console.log('OK ' +data);
	//document.getElementById("demo").innerHTML = "Paragraph changed."; //old HTML
	document.querySelector('h2').innerHTML = "P changed."; //HTML5
}


