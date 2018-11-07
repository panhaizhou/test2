<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function login(){ 
	    document.form1.action="login.do";
	    document.form1.submit();
	}
	function regist(){
	    document.form1.action="init2.do";
	    document.form1.submit();
	}
</script>

</head>
<body>
	<form name="form1" method="post">
		用户名:<input type="text" name="username"/>
		<br/>
		密码:<input type="password" name="pwd"/>
		<br/>
		<!-- <input type="submit" value="登录"/> -->
		<input type="button" name="btn1" value="登录" onclick="login()" />
		<input type="button" name="btn2" value="注册" onclick="regist()" />
	</form>
	<div>${message}</div>
</body>
</html>