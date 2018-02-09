$(function() {
	switch (menu) {
	case 'About US':
		$("#about").addClass("active");
		break;
	case 'Contact':
		$("#contact").addClass("active");
		break;
	case 'All Products':
		$("#listProducts").addClass("active");
		break;
	case 'Home':
		$("#home").addClass("active");
		break;
	default:
		if(menu == "Home")break;
		$("#listProducts").addClass("active");
	    $("#a_"+menu).addClass('active');
		break;
	}
});