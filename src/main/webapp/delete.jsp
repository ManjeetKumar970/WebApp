<%@page import="webapp.Dto.UserFrom"%>
<%@page import="webapp.Dao.DataAccessObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%

     DataAccessObject dto = new DataAccessObject();
       int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        UserFrom u=dto.findUserById(id);
         if(u!=null){
  %>  
    	   <center>
        <form action="DeleteUser" method="post">
        <table>
         <tr>
          <th> User Name : <input type="text" name="id"  value="<%=u.getId() %>"/></th>
          <th> User Name : <input type="text" name="nm"  value="<%=u.getUsername() %>"/></th>
          <th> Phone No : <input type="text" name="ph"  value="<%=u.getPhone() %>"/></th>
          <th>  Email Id : <input type="text" name="ml"  value="<%=u.getMail() %>"/></th>
           <th> Password : <input type="text" name="pd"  value="<%=u.getPassword() %>"/></th>
          </tr> 
          
          </table>
                 <button class="btn btn-primary">DELETE</button>
          
        </form>
    
    
    
    </center>
    	   
    	   
       <%}%>
  
  
</body>
</html>