package ejbimpl.ejb;

import java.util.List;

import javax.ejb.Stateless;

import ejbinterface.interfaces.CommentLocal;
import ejbinterface.interfaces.CommentRemote;
import ejbinterface.model.CommentShared;

@Stateless
public class CommentBean implements CommentLocal, CommentRemote {

	public List<CommentShared> findAllByArticle(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public CommentShared save(String content, Object userID, Object articleID) {
		// TODO Auto-generated method stub
		return null;
	}

}
