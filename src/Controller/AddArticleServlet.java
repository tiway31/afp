package Controller;

import Bdd.ArticleDao;
import Model.bean.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Article article =new Article();




        String titre = request.getParameter("titre");
        request.setAttribute("titre", titre);
        article.setTitre(titre);

        String contenu = request.getParameter("contenu");
        request.setAttribute("contenu", contenu);
        article.setContenu(contenu);

        ArticleDao articleDao = new ArticleDao();
        articleDao.ajouterArticle(article);
       // request.setAttribute("articles", ArticleDao.recupererTouslesArticles());

        this.getServletContext().getRequestDispatcher("/WEB-INF/addarticle.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/addarticle.jsp");
        requestDispatcher.forward(request, response);
    }
}
