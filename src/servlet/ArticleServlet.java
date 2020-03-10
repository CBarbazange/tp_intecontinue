package servlet;

import modele.*;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.ServletOutputStream;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;
    import java.text.ParseException;
    import java.util.List;

@WebServlet("/articles/*")
public class ArticleServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	int id = Integer.parseInt(req.getPathInfo().substring(1));
        ArticleDAO dao = new ArticleDAO();
        List<Article> articles = dao.getArticles(id);
        System.out.println(articles);
        req.setAttribute("articles", articles);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/articles.jsp");
        rd.forward(req, resp);
    }

}
