import ejbimpl.ejb.UserBean;
import ejbinterface.model.UserShared;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		/************************
		 * 
		 * Test UserBean
		 * 
		 ************************/
		UserBean ub = new UserBean();
		
		UserShared us = ub.save("test@test.fr", "psw");
		UserShared us2 = ub.findOne(us.getId());
		System.out.println(us2);
		us2.setMail("testUpdate@test.fr");
		us2.setPassword("pswupdate");
		us2.setSubscriber(true);
		ub.update(us2);
		UserShared us3 = ub.findOne(us.getId());
		System.out.println(us3);
		Boolean b = ub.emailExist("testUpdate@test.fr");
		System.out.println("email exist : "+b);
		
		
		
		
		
		/************************
		 * 
		 * Test ArticleBean
		 * 
		 ************************/
	}

}
