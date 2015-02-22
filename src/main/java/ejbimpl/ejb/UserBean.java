package ejbimpl.ejb;

import javax.ejb.Stateless;

import ejbinterface.interfaces.UserLocal;
import ejbinterface.interfaces.UserRemote;
import ejbinterface.entities.UserShared;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.User;

@Stateless
public class UserBean implements UserRemote, UserLocal {

	
	// Authentification
	public UserShared getUser(String mail, String password) {
		UserDao userdao = new UserDao();
		User u;
		UserShared us;
		try {
			u = userdao.findOne(mail, password);
			us = new UserShared(u.getEmail(), u.getPassword());
		} catch (Exception e) {
			us=null;
		}
		return us;
	}

	// Inscription
	public boolean createUser(String mail, String password) {
		
		UserDao userdao = new UserDao();
		
		User user = new User();
		user.setEmail(mail);
		user.setPassword(password);
		
		userdao.save(user);
		
		return true;
	}
	
}
