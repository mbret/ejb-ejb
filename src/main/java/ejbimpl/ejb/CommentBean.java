package ejbimpl.ejb;

import javax.ejb.Stateless;

import ejbinterface.interfaces.CommentLocal;
import ejbinterface.interfaces.CommentRemote;

@Stateless
public class CommentBean implements CommentLocal, CommentRemote {

}
