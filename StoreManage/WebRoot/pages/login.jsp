<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>登录页面</title>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
   <style type="text/css">
   	.red{color:red}
   </style>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.cookie.js"></script>
   
   <script type="text/javascript">	
    var flag=false;
	$(document).ready(function(){
	$("#inputCode").blur(function (){	
		var vCode=$("#inputCode").val();
	 	 if(!!vCode){
	 	 	$.ajax({  
	                type:"POST",  
	                url:"${pageContext.request.contextPath}/user/validCode.action",
	                dataType:"json", 
	                data:{
	               		vCode:vCode,
	               		userName:""
	                },
	                success:function(data){ 
	                	if(data.msg=='1'){
	                      	flag=true;
                      	 	//alert("验证码正确！");
                      	 	$("#error_html").removeClass("red").html("");
                       }else{
                        	//alert("验证码不正确！");
                        	$("#error_html").addClass("red").html("验证码不正确!");
                        	flag=false;
                       }
	                },
	                error:function (){
	                	alert("系统出现异常！");
	                }    
	         }); 
	         
         }else{
           flag=false;
           alert("验证码不能为空")
         }
         
	} );
	
	});
		
	function login(){
		var userName=$("#inputEmail").val();//获取用户名
		var psw=$("#inputPassword").val();
		var vCode=$("#inputCode").val();
			if(!/^\w{4,16}$/.test(userName)){
				alert("用户名不合法! 4-16位，字母，数字，下划线");
				return false;
			}else if(psw.length>16 || psw.length<6){
				alert("密码不合法! 6-16位，字母，数字");
				return false;
			}else if(!flag){
				alert("验证码不正确！");
				return false;
			}else{
				$.ajax({  
	                type:"POST",  
	                url:"${pageContext.request.contextPath}/user/login.action",
	                dataType:"json",  
	                data:{
	                	vCode:vCode,
	               		password:psw,
	                	userName:userName
	                },  
	                success:function(data){ 
	                  if( data.res=="1"){
	                 	 alert("ok");
	                 	 window.location.href="${pageContext.request.contextPath}/index.action";
	                  }else if(data.res=="0"){
	                  	alert("验证码错误！");
	                  	return false;
	                  }else{
	                  	alert("登录失败");
	                  	return false;
	                  }
	                }   
         });
	}

	}
</script>
  </head>
  
  <body>
  
  
    <p id="pppp">45455<a href="">123</a>656566</p>
    
    <div class="container">
      <form class="form-signin" method="post" action="##">
        <h3 class="form-signin-heading">请登录</h3>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="用户名"  name="username" maxlength="20" value="admin" >
         <label id="userNameError"></label>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" name="password" maxlength="10">
       
        <label for="inputEmail" class="sr-only" >验证码</label>
        <input type="text" id="inputCode" placeholder="验证码" name="code" tabindex="6" style="width:80px;text-transform:uppercase;ime-mode:disabled" maxlength="4">
        <img id="vdimgck"  src="${pageContext.request.contextPath}/pages/image.jsp?d="+new Date()+"" alt="看不清？点击更换" align="absmiddle" width="75" style="cursor:pointer" onclick="this.src=this.src+'?'" />
      	<label id="error_html" style="font-size:18px;"></label>
       <div class="checkbox" id="checkboxid">
          <label>
            <input type="checkbox" name="rememberMe"> 记住我
          </label>
        </div>
        <p class="bg-warning">${error}</p>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="return login()">登录</button>
      </form>
    </div> <!-- /container -->
    
</body>
</html>
