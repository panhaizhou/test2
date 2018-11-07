<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.11.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#username").blur(function(){
			$.ajax({
				url: "checkName.do",
				type: "post",
				data: {
					name: $(this).val()
				},
				dataType: "text",
				success: function(data){
					$("#tips").text(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<form action="registResult.do" method="post">
		用户名:<input type="text" name="username" id="username"/>
		<span id="tips"></span>
		<br/>
		密码:<input type="password" name="pwd"/>
		<br/>
		年龄:<input type="text" name="age"/>
		<br/>
		性别:<input type="text" name="sex"/>
		<br/>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>