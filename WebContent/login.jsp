<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<!-- <link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css"> -->
<script src="res/js/jquery-3.2.0.min.js"></script>
<script src="res/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="res/css/bootstrap.min.css" />
<link rel="stylesheet" href="res/css/style.css" />
<!-- <script src="res/js/bootstrap.min.js"></script> -->
</head>
<body>
	<form method="post" id="frm_login">
    	<div class="mycenter">
            <div class="mysign">
                <div class="col-lg-11 text-center text-info">
                    <h2>请登录</h2>
                </div>
                <div class="col-lg-10">
                    <input type="text" class="form-control" name="username" placeholder="请输入账户名" required autofocus/>
                </div>
                <div class="col-lg-10"></div>
                <div class="col-lg-10">
                    <input type="password" class="form-control" name="password" placeholder="请输入密码" required autofocus/>
                </div>
                <div class="col-lg-10">
                    <button type="button" id="divLogin" class="btn btn-success col-lg-12">登录</button>
                </div>
            </div>
        </div>
	</form>
	<script type="text/javascript">
	$("#divLogin").click(function(){
		$.ajax({
					   url: "userLogin.action",
					   type: 'POST',
					   data:{
						   name:$("input[name=username]").val(),
						   password:$("input[name=password]").val()
					   },
					   dataType:'json',
					   success: function(data){
						   alert("登录成功，欢迎"+$("input[name=username]").val());
						   $(location).attr('href', 'success_login.html');
						   /*$(location).prop('href','success_login.html');
 						  	$(window).attr('location','success_login.html');
						    */
					    /* var obj=JSON.parse(data);
 						   alert(obj.name);
						   alert(obj.password); */
					   },
					   error: function(data){
					   		alert("用户或密码有误。 ");
					   }
				});
			
	})
	</script>
</body>
</html>