package webapp.Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webapp.Dao.DataAccessObject;
import webapp.Dto.UserFrom;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataAccessObject dto = new DataAccessObject();
		 int  id = Integer.parseInt(req.getParameter("id"));
		 System.out.println(id);
		   boolean u=dto.DeleteUser(id);
		   if(u==true) {
			   RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
			   rd.forward(req, resp);
		   }
		  
		 
	}

}
