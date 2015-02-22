package ejbimpl.ejb;

import java.util.List;

import ejbimpl.ejb.*;
import ejbinterface.factory.ModelFactory;
import ejbinterface.interfaces.ArticleLocal;
import ejbinterface.interfaces.ArticleRemote;
import ejbinterface.model.ArticleShared;
import ejbinterface.model.UserShared;
import ejbpersistance.dao.ArticleDao;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.Article;
import ejbpersistance.entities.User;

import javax.ejb.Stateless;

@Stateless
public class ArticleBean implements ArticleLocal, ArticleRemote {
	
	public boolean createArticle(String title, String content){		
		ArticleDao adao = new ArticleDao();
		
		Article a = new Article();
		a.setTitle(title);
		a.setContent(content);
		
		adao.save(a);
		
		return true;
	}
	
	public List<ArticleShared> findAll(){
		ArticleDao adao = new ArticleDao();
		
		List<Article> a = adao.getAll();
		List<ArticleShared> as = null;
		try {
			as = (List<ArticleShared>) ModelFactory.convert(ArticleShared.class, a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return as;
		
	}

	public ArticleShared findOne(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArticleShared save(String title, String content, UserShared user) {
		ArticleDao adao = new ArticleDao();
		
		Article a = new Article();
		a.setTitle(title);
		a.setContent(content);
		User u = (User)ModelFactory.convert(UserShared.class, user);
		a.setUser(u);
		
		adao.save(a);
		
		return true;
	}

}
