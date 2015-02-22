package ejbimpl.ejb;

import javax.ejb.Stateless;

import ejbinterface.factory.ModelFactory;
import ejbinterface.interfaces.UserLocal;
import ejbinterface.interfaces.UserRemote;
import ejbinterface.model.UserShared;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.User;

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
		UserShared us = null;
		try {
			u = userdao.findOne(mail, password);
			if(u != null){
				us = ModelFactory.convert(UserShared.class, u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}
    	
	public boolean emailExist(String email) {
		UserDao userdao = new UserDao();
		return userdao.emailExist(email);
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
		userdao.save(user);

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
}
