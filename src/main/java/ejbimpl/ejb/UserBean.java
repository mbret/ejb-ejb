package ejbimpl.ejb;

import javax.ejb.Stateless;

import ejbinterface.interfaces.UserLocal;
import ejbinterface.interfaces.UserRemote;
import ejbinterfaces.entities.UserShared;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.User;

@Stateless
public class UserBean implements UserRemote, UserLocal {

	// Authentification
	@Override
	public UserShared getUser(String mail, String password) {
		return null;
	}

	// Inscription
	@Override
	public boolean createUser(String mail, String password) {
		
		UserDao userdao = new UserDao();
		
		User user = new User();
		user.setEmail(mail);
		user.setPassword(password);
		
		userdao.save(user);
		
		return true;
	}

}
