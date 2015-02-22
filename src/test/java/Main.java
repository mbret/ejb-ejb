import java.util.ArrayList;
import java.util.List;

import ejbimpl.ejb.ArticleBean;
import ejbimpl.ejb.CommentBean;
import ejbimpl.ejb.UserBean;
import ejbinterface.model.ArticleShared;
import ejbinterface.model.CommentShared;
import ejbinterface.model.UserShared;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		
		/************************
		 * 
		 * Test UserBean
		 * 
		 ************************/
		
		UserBean ub = new UserBean();
		
		UserShared us = ub.findOne("test@test.fr", "psw");
		System.out.println(us.toString());
		us.setMail("fougeredecombat@hotmail.fr");
		ub.update(us);
		System.out.println(us.toString());

//		UserShared us = ub.save("test@test.fr", "psw");
//		UserShared us2 = ub.findOne(us.getId());
//		System.out.println(us2);
//		us2.setMail("testUpdate@test.fr");
//		us2.setPassword("pswupdate");
//		us2.setSubscriber(true);
//		ub.update(us2);
//		UserShared us3 = ub.findOne(us.getId());
//		System.out.println(us3);
//		UserShared us4 = ub.findOne("testUpdate@test.fr", "pswupdate");
//		System.out.println(us4);
//		UserShared us5 = ub.findOne("nonTrouve@test.fr", "pswupdate");
//		System.out.println(us5);
//		Boolean b = ub.emailExist("testUpdate@test.fr");
//		System.out.println("email exist : "+b);
//		b = ub.emailExist("nonTrouve@test.fr");
//		System.out.println("email exist : "+b);
		
		
		/************************
		 * 
		 * Test ArticleBean
		 * 
		 ************************/
		
//		ArticleBean ab = new ArticleBean();
//		
//		ArticleShared as = ab.save("titre", "contenu", us4.getId());
//		System.out.println(as);
//		List<ArticleShared> as2 = ab.findAll();
//		for(ArticleShared as3 : as2){
//			System.out.println(as3);
//		}
//		ArticleShared as4 = ab.findOne(as.getId());
//		System.out.println(as4);
		
		

		/************************
		 * 
		 * Test ArticleBean
		 * 
		 ************************/
		

//		CommentBean cb = new CommentBean();
//		
//		CommentShared cs = cb.save("cteihde", us.getId(), as.getId());
//		System.out.println(cs);

		CommentBean cb = new CommentBean();
		
		CommentShared cs = cb.save("cteihde", us.getId(), as.getId());
		System.out.println(cs);
		List<CommentShared> cs2 = cb.findAllByArticle(as.getId());
		for(CommentShared cs3 : cs2){
			System.out.println(cs3);
		}
		

	}

}
