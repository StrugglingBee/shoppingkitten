function init(){
	nav_click();
}
$(init);
function nav_click(){
	$("#context_top li").mouseenter(function(){
//		alert("aaaS");
		   $(this).css("border-bottom","1px solid white");
		   $(this).css("background-color","white");
		   
		   $("#context_footer").show();
	});
	$("#context_top li").mouseleave(function(){
//		alert("123");
	$("#context_top li").css("border-bottom","1px solid #ABCF9F");
	 $(this).css("background-color","#E8F6E5");
	 
	 $("#context_footer").hide();
});
}
//function nav_msg(){
//	$("#context_top li").mouseenter(function())
//}
