package webapp.Controler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import webapp.Dao.DataAccessObject;
import webapp.Dto.UserFrom;

public class updateDataMain {
	public static void main(String[] args) {
		
		UserFrom uf = new UserFrom();
		uf.setId(1);
		uf.setPassword("1g0d2365");
		uf.setUsername("kdf0k");
		uf.setMail("k0hk");
		uf.setPhone(940);

	   DataAccessObject dao = new DataAccessObject();
	   dao.updateUser(uf);
	}

}
