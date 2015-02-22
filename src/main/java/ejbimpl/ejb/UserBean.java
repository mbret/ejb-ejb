package ejbimpl.ejb;

import javax.ejb.Stateless;

import ejbinterface.model.UserShared;
import ejbinterface.factory.ModelFactory;
import ejbinterface.interfaces.UserLocal;
import ejbinterface.interfaces.UserRemote;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.User;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserBean implements UserRemote, UserLocal {

	
	// Authentification
	public UserShared getUser(String mail, String password) {
		UserDao userdao = new UserDao();
		User u;
		UserShared us;
		try {
			u = userdao.findOne(mail, password);
			us = ModelFactory.convert(UserShared.class, u);
		} catch (Exception e) {
			us=null;
		}
		return us;
	}
    
	// Inscription
	public UserShared createUser(String mail, String password) {
		
		UserDao userdao = new UserDao();
		
		User user = new User();
		user.setEmail(mail);
		user.setPassword(password);
		
		userdao.save(user);
		
		//@todo
		return null;
	}
	
	public boolean emailExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

	public UserShared findOne(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserShared save(String mail, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(UserShared user) {
		// TODO Auto-generated method stub
		
	}
	
}
