$(function(){
	//solving the active menu problem.
	switch(menu){
	
	case'About Us':
		$('#about').addClass('active');
		break;
	
	case'Contact Us':
		$('#contact').addClass('active');
		 break;
		
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
		
	default:
		if(manu == "Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	
	
	//code for jquery dataTable
	//create a dataset
	var products = [
	                	['1','ABC'],
	                	['2','WER'],
	                	['3','YUI'], 
	                	['4','TYU'],
	                	['5','HJY'],
	                	['6','EER'],
	                	['7','WWH'],
	                	['8','OOP']
	                	                
	                ];
	
	var $table = $('#productListTable');
	// execute the below code only where we have this table
	 if($table.length){
		 
		 //console.log('Inside the table');
		 $table.dataTable({
			lengthMenu:[[3,5,10,-1],['3 Records', '5 Records', '10 Records','ALL']],
			pageLength: 5,
			data: products 
		 });
		 
	 }
});


