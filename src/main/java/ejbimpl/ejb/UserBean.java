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
     * @throws Exception 
     */
	public UserShared findOne(String mail, String password) throws Exception {
		UserDao userdao = new UserDao();
		User u;
		UserShared us = null;
		u = userdao.findOne(mail, password);
		if(u != null){
			us = ModelFactory.convert(UserShared.class, u);
		}
		return us;
	}
    
	public boolean emailExist(String email) {
		UserDao userdao = new UserDao();
		return userdao.emailExist(email);
	}

	public UserShared findOne(Object id) throws Exception {
		UserDao userdao = new UserDao();
		User u = userdao.get((Integer)id);		
		return ModelFactory.convert(UserShared.class, u);
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
		
		String mail = user.getMail();
		String pwd = user.getPassword();
		int id = user.getId();
		boolean sub = user.getSubscriber();
		
		User u = userdao.updateUser(id, mail, pwd, sub);

	}
}
