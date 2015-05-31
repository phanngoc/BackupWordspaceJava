<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Them moi vacxin</title>
<style type="text/css">
  .wrap{
  	display : block;
  	margin : 10px auto;
  	width : 50%;
  }
</style>
</head>
<body>

       <div class="wrap">
        
	        <form action="CheckLoginServlet" method="post">
	          <label for="mavacxin">Mã Vacxin</label>
	          <br/>
	          <input type="text" name="mavacxin" />
	          <br/>
			  <label for="tenvacxin">Tên Vacxin</label>
			  <br/>
	          <input type="text" name="tenvacxin" />
	          <br/>
	          <label for="soluongmui">Số lượng mũi</label>
	          <br/>
	          <input type="text" name="soluongmui" />
	          <br/>
	          <label for="mota">Mô tả </label>
	          <br/>
	          <input type="text" name="mota" />
	          <br/>
	          <label for="giavacxin">Giá Vacxin</label>
	          <br/>
	          <input type="text" name="giavacxin" />
	          <br/>
	          <label for="tenhangsanxuat">Tên hãng sản xuất</label>
	          <br/>
	          <input type="text" name="tenhangsanxuat" />
	          <br/>
	          <input type="submit" value="Add" /> 
	                      
	        </form>
        
       </div> 
</body>
</html>