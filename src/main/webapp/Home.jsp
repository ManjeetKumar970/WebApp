<%@page import="webapp.Dao.DataAccessObject"%>
<%@page import="webapp.Dto.UserFrom"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap.min.css">

<title>Home</title>
</head>
<body>
<div  class="container">
 <center><h1>WELCOME TO HOME PAGE</h1></center>
<center>
   
<%


   DataAccessObject dao = new DataAccessObject();
     List <UserFrom> user =dao.ShowAllUser();
     for(UserFrom e :user){
%>
        
    	 <form >
    	 <table class="table table-striped">
           <tr>
           <input type=text value="<%=e.getId()%>" readonly="readonly"/>
           <input type=text value="<%=e.getUsername()%>" readonly="readonly"/>
           <input tyep="text" value="<%=e.getPhone()%>" readonly="readonly"/>
            <input type=text value="<%=e.getMail()%>" readonly="readonly"/>
            <input type=text value="<%=e.getPassword()%>" readonly="readonly"/>
    	
    	    <a href="delete.jsp?id=<%=e.getId()%>" >DELETE</a>
    	    <a href="update.jsp?id=<%=e.getId()%>" >UPDATE</a>
    	     <a href="Add.jsp" >ADD</a>
       </tr>
       </table>
    	</form>
    	 
    
    	 
     <%}%>


</center>
</div>
</body>


</html>