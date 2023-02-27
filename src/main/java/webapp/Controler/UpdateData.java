package webapp.Controler;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.Dao.DataAccessObject;
import webapp.Dto.UserFrom;

@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("nm");
		String mail = req.getParameter("ml");
		long phone = Long.parseLong(req.getParameter("ph"));
		String pass = req.getParameter("pd");
		UserFrom uf = new UserFrom();
		uf.setId(id);
		uf.setUsername(name);
		uf.setPassword(pass);
		uf.setMail(mail);
		uf.setPhone(phone);
	    DataAccessObject dao = new DataAccessObject();
	    dao.updateUser(uf);
		
		
		
		if(uf!=null) {
			RequestDispatcher dispactcher = req.getRequestDispatcher("Home.jsp");
			dispactcher.forward(req, resp);
						
		}
		
	}
		
	}

