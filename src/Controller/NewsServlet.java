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
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "NewsServlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        ServletContext servletContext = this.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/articles.jsp");

        ArticleDao articles = new ArticleDao();
        List<Article> listArticles = articles.recupererTouslesArticles();

        Logger logger = Logger.getLogger("com.javacodegeeks.snippets.core");
        logger.warning("TAG_list => id du permier article: "+listArticles.get(0).getTitre());

        request.setAttribute("listArticles", listArticles);

        requestDispatcher.forward(request, response);
    }
}
