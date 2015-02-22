package ejbimpl.ejb;

import javax.ejb.Stateless;

import ejbinterface.factory.ModelFactory;
import ejbinterface.interfaces.UserLocal;
import ejbinterface.interfaces.UserRemote;
import ejbinterface.model.UserShared;
import ejbpersistance.dao.UserDao;
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
    	
	public boolean emailExist(String email) {
		UserDao userdao = new UserDao();
		try {
			User exist = userdao.emailExist(email);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public UserShared findOne(Object id) {
		UserDao userdao = new UserDao();
		User u = userdao.get((Integer)id);		
		try {
			return ModelFactory.convert(UserShared.class, u);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
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
		user.setSubscriber(false);
		
		User uz = userdao.save(user);

		return ModelFactory.convert(UserShared.class, user);
	}

	public void update(UserShared user) {
		UserDao userdao = new UserDao();
		
		User u = new User();
		u.setEmail(user.getMail());
		u.setPassword(user.getPassword());
		u.setId(user.getId());
		u.setSubscriber(user.getSubscriber());
		User uz = userdao.save(u);

	}

	public UserShared createUser(String mail, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserShared getUser(String mail, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
