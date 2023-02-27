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


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//UserFrom uf = new UserFrom();
		String usernmae = req.getParameter("nm");
		String password = req.getParameter("pd");
		 DataAccessObject dao = new DataAccessObject();
		UserFrom uf =dao.userVerification(usernmae, password);
		PrintWriter write = resp.getWriter();
		if(uf!=null) {
			RequestDispatcher dispactcher = req.getRequestDispatcher("Home.jsp");
			dispactcher.forward(req, resp);

		}else {
			write.write("<html><body><h1>User Or PassWord Invalide</h1><body></html>");
			RequestDispatcher dispactcher = req.getRequestDispatcher("index.jsp");
			dispactcher.include(req, resp);
			
		}

		
	}

}
