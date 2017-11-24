/*
* app.js
*/
function changeColor() {
	var e = document.getElementById('t-color-inp');
	var color = e.options[e.selectedIndex].value;
	var colour = "#d37070"
	switch(color) {
		case 'red':
			colour = "#d37070";	break;
		case 'green':
			colour = "#51db5a";	break;		
		case 'yellow':
			colour = "#edd30e";	break;
		case 'black':
			colour = "#000000";	break;
		case 'white':
			colour = "#ffffff";	break;
		default:
			colour = "#ffffff";
	}	document.getElementById('container').style.backgroundColor = colour
}
