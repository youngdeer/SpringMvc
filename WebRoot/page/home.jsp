<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="page/js/jquery-1.10.1.min.js"></script> 

  <style type="text/css">
  	#fullbg{background-color: Gray;display:none;z-index:3;position:absolute;left:0px;top:0px;filter:Alpha(Opacity=30);/* IE */-moz-opacity:0.4;/* Moz + FF */opacity: 0.4;}  
 
            #dialog {position:absolute;width:200px;height:200px;background:#F00;display: none;z-index: 5;}  
 
            #main {  
                height: 1500px;  
            }  
  </style>	
  
  <script>
  	//ÏÔÊ¾»ÒÉ«JSÕÚÕÖ²ã  
            function showBg(){  
                var bH=$("body").height();  
                var bW=$("body").width()+16;  
                $("#fullbg").css({width:bW,height:bH,display:"block"});   
                $(window).scroll(function(){resetBg()});  
                $(window).resize(function(){resetBg()});  
            }  
            function resetBg(){  
                var fullbg=$("#fullbg").css("display");  
                if(fullbg=="block"){  
                    var bH2=$("body").height();  
                    var bW2=$("body").width()+16;  
                    $("#fullbg").css({width:bW2,height:bH2});  
                    var objV=getObjWh("dialog");  
                    var tbT=objV.split("|")[0]+"px";  
                    var tbL=objV.split("|")[1]+"px";  
                    $("#dialog").css({top:tbT,left:tbL});  
                }  
            }  
 
            //¹Ø±Õ»ÒÉ«JSÕÚÕÖ²ãºÍ²Ù×÷´°¿Ú  
            function closeBg(){  
                $("#fullbg").css("display","none");
            }
            
            function showAlert(){
            	showBg();
            	var flag = confirm('ÕÚ¸ÇÌáÊ¾¿ò£¡');
            	if(flag){
            		closeBg();
            	}else{
            		closeBg();
            	}
            }
  </script>
  </head>
  
  <body>
    <h2>spring mvc ÊµÀý</h2>
    <form action="login.html" method="post">  
    username:<input type="text" name="username" />  
    <p>  
    password:<input type="password" name="password"/>  
    <p>  
    <input type="submit" value="submit" />  
</form>

<form action="contacts.html" method="post"> 
	<input type="submit" value="Ìø×ªÖÁcontractsÒ³Ãæ" />   
</form>

<input type="button" value="²âÊÔÕÚ¸Ç" onclick='showAlert()'/>
<hr/>

<!-- JSÕÚÕÖ²ã --> 
<div id="fullbg"></div> 
<!-- end JSÕÚÕÖ²ã --> 
  </body>
</html>
