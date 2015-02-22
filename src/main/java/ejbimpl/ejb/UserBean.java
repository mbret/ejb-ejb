package ejbimpl.ejb;

import ejbinterface.entities.UserShared;
import ejbinterface.interfaces.UserLocal;
import ejbinterface.interfaces.UserRemote;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.User;

import javax.ejb.Stateless;

@Stateless
public class UserBean implements UserRemote, UserLocal {

	// Authentification
	@Override
	public UserShared getUser(String mail, String password) {
		return null;
	}

    @Override
    public boolean test(){
        return true;
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
