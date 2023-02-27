package webapp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import webapp.Dto.UserFrom;

public class DataAccessObject {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();	
	
	
	public UserFrom SaveDate(UserFrom user) {
		try {
			EntityTransaction tran = manager.getTransaction();
			 manager.persist(user);
			 tran.begin();
			 tran.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public UserFrom userVerification(String name ,String password) {
		Query q = manager.createQuery("Select U From UserFrom U Where U.Username=?1 and U.password=?2");
		q.setParameter(1, name);
		q.setParameter(2, password);
		List<UserFrom>users = q.getResultList();
		if(users.size()>0) {
			return users.get(0);
		}
		return null;
			
	}
	
	public   List<UserFrom> ShowAllUser(){
		Query q = manager.createQuery("Select U From UserFrom U ");
		return q.getResultList();

	}
	public boolean DeleteUser(int id) {
		EntityTransaction transaction = manager.getTransaction();
		UserFrom u = manager.find(UserFrom.class, id);
		if(u!=null) {
			manager.remove(u);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}
	
	public UserFrom findUserById(int id) {
		return manager.find(UserFrom.class, id);
	}
	
	public UserFrom updateUser(UserFrom user) {
		EntityTransaction entityTransaction = manager.getTransaction();
		entityTransaction.begin();
		manager.merge(user);
		entityTransaction.commit();
		return user;
	}
	

}
