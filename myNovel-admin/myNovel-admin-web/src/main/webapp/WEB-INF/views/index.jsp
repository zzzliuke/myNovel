<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
	欢迎来到我的小说网站!
	${msg }
	<form action="/test/date"  method="post" >
		<input type="text"  name="name"   value="name"/> 
		<input type="submit" value="请求"  >
	</form>
</body>
</html>