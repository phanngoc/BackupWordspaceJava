<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="model.bean.Account"%>


<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Language"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Screen</title>
</head>
<body>
      <% String userName = request.getParameter("userName"); 
         Account account = (Account)request.getAttribute("account");
         ArrayList<Language> langArray = (ArrayList<Language>)request.getAttribute("langArray");
      %>

      Welcome <%=userName%>! <br>
      Your fullname is <%=account.getFullName()%> <br>
      Your age are <%=account.getAge()%> <br>
      Are you female? <%=account.isFemale()%> <br>
      Are you usua? <%=account.isUsua()%> <br>
      
      Your language: <br>
      
      <table border="2">
          <tr><th>Name</th><th>Months of Experience</th></tr>
        <% for (int i = 0; i < langArray.size(); i++) { %>
              <tr>
                  <td><%=langArray.get(i).getName()%></td>
                  <td><%=langArray.get(i).getMonthsExperience()%></td>
              </tr>
        <% } %>
      </table>
      
 
</body>
</html>