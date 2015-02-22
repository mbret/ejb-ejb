package ejbimpl.ejb;

import ejbinterface.factory.ModelFactory;
import ejbinterface.interfaces.ArticleLocal;
import ejbinterface.interfaces.ArticleRemote;
import ejbinterface.model.ArticleShared;
import ejbpersistance.dao.ArticleDao;
import ejbpersistance.entities.Article;

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

    @Override
    public ArticleShared save(String var1, String var2, Object var3) {
        return null;
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

}
