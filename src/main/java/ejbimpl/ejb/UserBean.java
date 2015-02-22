package ejbimpl.ejb;

import javax.ejb.Stateless;

import ejbinterface.model.ArticleShared;
import ejbinterface.model.UserShared;
import ejbinterface.factory.ModelFactory;
import ejbinterface.interfaces.UserLocal;
import ejbinterface.interfaces.UserRemote;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.Article;
import ejbpersistance.entities.User;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserBean implements UserRemote, UserLocal {


    /**
     * 
     * @param mail
     * @param password
     * @return
     */
	public UserShared findOne(String mail, String password) {
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

    /**
     *
     * @param mail
     * @param password
     * @return
     */
	public UserShared save(String mail, String password) throws Exception{
		
		UserDao userdao = new UserDao();
		
		User user = new User();
		user.setEmail(mail);
		user.setPassword(password);
		userdao.save(user);

		return ModelFactory.convert(UserShared.class, user);
	}

	public void update(UserShared user) {
		// TODO Auto-generated method stub
		
	}
	
}
