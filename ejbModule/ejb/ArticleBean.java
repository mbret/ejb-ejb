package ejb;

import javax.ejb.Stateless;

import ejbinterface.interfaces.ArticleLocal;
import ejbinterface.interfaces.ArticleRemote;

@Stateless
public class ArticleBean implements ArticleLocal, ArticleRemote {

}
