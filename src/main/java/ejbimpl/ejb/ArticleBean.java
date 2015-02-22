package ejbimpl.ejb;

import java.util.List;

import javax.ejb.Stateless;

import ejbinterface.factory.ModelFactory;
import ejbinterface.interfaces.ArticleLocal;
import ejbinterface.interfaces.ArticleRemote;
import ejbinterface.model.ArticleShared;
import ejbpersistance.dao.ArticleDao;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.Article;
import ejbpersistance.entities.User;

import javax.ejb.Stateless;
import java.util.List;


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
		ArticleDao adao = new ArticleDao();
		
		Article a = new Article();
		a = adao.get((Integer)id);
		try {
			return ModelFactory.convert(ArticleShared.class, a);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

	public ArticleShared save(String title, String content, Object userID) {
		ArticleDao adao = new ArticleDao();
		UserDao udao = new UserDao();
		
		Article a = new Article();
		a.setTitle(title);
		a.setContent(content);
		User u = udao.get((Integer)userID);
		a.setUser(u);
		
		Article az = adao.save(a);
		try {
			return ModelFactory.convert(ArticleShared.class, az);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

}
