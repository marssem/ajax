<%@page import="java.io.PrintWriter"%>
<%@page import="com.ajax.test.common.Connector"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
{
try{
int result = 0;
Connection con = Connector.con();
String sql = "call increase_salary(?,?)";
PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1,"dragon");
ps.setDouble(2, 0.05);
result = ps.executeUpdate();
if(result ==1){
}
}catch(Exception e){
	e.printStackTrace();
}
}
%>

</body>
</html>