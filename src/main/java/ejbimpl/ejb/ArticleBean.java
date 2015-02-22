package ejbimpl.ejb;

import java.sql.Timestamp;
import java.time.Instant;
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


@Stateless
public class ArticleBean implements ArticleLocal, ArticleRemote {
	
	
	public List<ArticleShared> findAll() throws Exception{
		ArticleDao adao = new ArticleDao();
		
		List<Article> a = adao.getAll();
		List<ArticleShared> as = null;
		as = (List<ArticleShared>) ModelFactory.convert(ArticleShared.class, a);		
		return as;
		
	}

	public ArticleShared findOne(Object id) throws Exception {
		ArticleDao adao = new ArticleDao();
		
		Article a = new Article();
		a = adao.get((Integer)id);
		return ModelFactory.convert(ArticleShared.class, a);
	}

	public ArticleShared save(String title, String content, Object userID) throws Exception {
		ArticleDao adao = new ArticleDao();
		UserDao udao = new UserDao();
		java.util.Date date= new java.util.Date();
		Article a = new Article();
		a.setTitle(title);
		a.setContent(content);
		User u = udao.get((Integer)userID);
		a.setUser(u);
		a.setDate(new Timestamp(date.getTime()));
		
		Article az = adao.save(a);
		return ModelFactory.convert(ArticleShared.class, az);
	}

}
