<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.Vacxin"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Vacxin</title>
<style type="text/css">
  .wrap{
  	display : block;
  	margin : 10px auto;
  	width : 50%;
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
       <h3>Update Vacxin</h3>
        <%
			Vacxin vacxin = (Vacxin) request.getAttribute("vacxin");
		
		%>
	        <form action="CheckUpdateServlet" method="post">
	          <label for="mavacxin">Mã Vacxin</label>
	          <br/>
	          <input type="text" name="mavacxin" value="<%=vacxin.getMavacxin() %>"/>
	          <br/>
			  <label for="tenvacxin">Tên Vacxin</label>
			  <br/>
	          <input type="text" name="tenvacxin" value="<%=vacxin.getTenvacxin()%>"/>
	          <br/>
	          <label for="soluongmui">Số lượng mũi</label>
	          <br/>
	          <input type="text" name="soluongmui" value="<%=vacxin.getSoluongmui() %>"/>
	          <br/>
	          <label for="mota">Mô tả </label>
	          <br/>
	          <input type="text" name="mota" value="<%=vacxin.getMota()%>"/>
	          <br/>
	          <label for="giavacxin">Giá Vacxin</label>
	          <br/>
	          <input type="text" name="giavacxin" value="<%=vacxin.getGiavacxin()%>"/>
	          <br/>
	          <label for="tenhangsanxuat">Tên hãng sản xuất</label>
	          <br/>
	          <input type="text" name="tenhangsanxuat" value="<%=vacxin.getTenhangsanxuat()%>"/>
	          <br/>
	          <input type="submit" value="Update" /> 
	                      
	        </form>
            <br/>
            <br/>
            <br/>
            <br/>
            <a href="ShowLietkeServlet" >Liệt kê toàn bộ lịch sử tiêm phòng của khách hàng có mã là : <b>ma01</b></a>
       </div> 
</body>
</html>