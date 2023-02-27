package webapp.Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.Dao.DataAccessObject;
import webapp.Dto.UserFrom;
@WebServlet("/addData")
public class addData extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("nm");
			String mail = req.getParameter("ml");
			long phone = Long.parseLong(req.getParameter("ph"));
			String pass = req.getParameter("pd");
			UserFrom uf = new UserFrom();
			uf.setUsername(name);
			uf.setPassword(pass);
			uf.setMail(mail);
			uf.setPhone(phone);
			DataAccessObject dao = new DataAccessObject();
			
			if(uf!=null) {
				dao.SaveDate(uf);
				RequestDispatcher dispactcher = req.getRequestDispatcher("Home.jsp");
				dispactcher.forward(req, resp);
							
			}
			
		}
	}

