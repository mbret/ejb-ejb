package ejbimpl.ejb;

import java.sql.Timestamp;
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

	public List<CommentShared> findAllByArticle(Object id) throws Exception {
		CommentDao cdao = new CommentDao();
		List<Comment> u = cdao.findAllByArticle((Integer)id);		
		return ModelFactory.convert(CommentShared.class, u);
	}

	public CommentShared save(String content, Object userID, Object articleID) throws Exception{
		
		CommentDao cdao = new CommentDao();
		UserDao userdao = new UserDao();
		ArticleDao adao = new ArticleDao();

		java.util.Date date= new java.util.Date();
		
		Comment comm = new Comment();
		comm.setContent(content);
		comm.setUser(userdao.get((Integer)userID));
		comm.setArticle(adao.get((Integer)articleID));
		comm.setDate(new Timestamp(date.getTime()));
		
		Comment co = cdao.save(comm);
		return ModelFactory.convert(CommentShared.class, co);
		
	}

}
