<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="res/css/bootstrap.min.css" />
<link rel="stylesheet" href="res/css/style.css" />
<script src="res/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="userLogin" method="post" id="frm_login">
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
					   url: "userLogin",
					   type: 'POST',
					   data: $(document.frm_login).serialize(),
					   success: function(data){
					   		window.location.href = "dynalist.html";
					   },
					   error: function(data){
					   		alert("意外错误："+data);
					   }
				});
			
	})
	</script>
</body>
</html>