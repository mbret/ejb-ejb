package ejbimpl.ejb;

import java.util.List;

import javax.ejb.Stateless;

import ejbinterface.factory.ModelFactory;
import ejbinterface.interfaces.CommentLocal;
import ejbinterface.interfaces.CommentRemote;
import ejbinterface.model.CommentShared;
import ejbinterface.model.UserShared;
import ejbpersistance.dao.ArticleDao;
import ejbpersistance.dao.CommentDao;
import ejbpersistance.dao.UserDao;
import ejbpersistance.entities.Comment;
import ejbpersistance.entities.User;

@Stateless
public class CommentBean implements CommentLocal, CommentRemote {

	public List<CommentShared> findAllByArticle(Object id) {
		return null;
		/*
		CommentDao cdao = new CommentDao();
		List<Comment> u = cdao.findAllByArticle((Integer)id);		
		try {
			return ModelFactory.convert(CommentShared.class, u);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		*/
	}

	public CommentShared save(String content, Object userID, Object articleID) {
		return null;
		/*
		CommentDao cdao = new CommentDao();
		UserDao userdao = new UserDao();
		ArticleDao adao = new ArticleDao();
		
		Comment comm = new Comment();
		comm.setContent(content);
		comm.setUser(userdao.get((Integer)userID));
		comm.setArticle(adao.get((Integer)articleID));
		
		Comment co = cdao.save(comm);

		try {
			return ModelFactory.convert(CommentShared.class, co);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		*/
	}

}
