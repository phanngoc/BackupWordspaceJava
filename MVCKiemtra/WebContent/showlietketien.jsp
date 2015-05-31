<%@page import="model.bean.LietkeTien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.LietkeTien"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liet ke toan bo lich su tiem phong</title>
<style type="text/css">
.wrap{
  	display : block;
  	margin : 10px auto;
  	width : 80%;
}


table {
	display: block;
	width: 50%;
	margin: 20px auto;
}
table tr td,table tr th{
  border : 1px solid black;

}

h3{
	display: block;
	margin : 0px auto;
	width : 50%;
	color : red;
	font-weight : bold;
}

</style>
</head>
<body>
 <div class="wrap">
  <h3>Liệt kê lịch sử tiêm phòng</h3>
  <table class="table">
  	<thead>
  		<tr>

  		</tr>
  	</thead>
  	<tbody>
  			<%
			ArrayList<LietkeTien> lietkes = (ArrayList<LietkeTien>) request.getAttribute("lietkes");
			for (int i = 0; i < lietkes.size(); i++) {
		%>
		<tr>
			<td><%=lietkes.get(i).getMakhachhang()%></td>
			<td><%=lietkes.get(i).getTenkhachhang()%></td>
			<td><%=lietkes.get(i).getDiachikhachhang()%></td>
			<td><%=lietkes.get(i).getTongtien()%></td>
		</tr>
		<%
			}
		%>
  	</tbody>
  </table>
 </div>
</body>
</html>