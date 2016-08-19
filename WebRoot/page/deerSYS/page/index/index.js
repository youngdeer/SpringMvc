function getHtml(){
	ajax("get",basePath+"deerSYS/getHtml.json",{},function(data){
		alert(data.command);
		$("#getHtmlFromController").append(data.command);
	});
}

function pupupu(){
	$('#qipao').thoughtBubble({
      text: 'baby,I love you',
      font: 'avenir'

   });
	$('#qipao').mouseenter();
	
//	setTimeout("$('#qipao').mouseout();",5000); 
}