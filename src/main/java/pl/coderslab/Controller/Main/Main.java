package pl.coderslab.Controller.Main;

import pl.coderslab.Dao.SolutionDao;
import pl.coderslab.Entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Main", urlPatterns = {"/school"})
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SolutionDao solutionDao = new SolutionDao();
        List<Solution> solutionList = solutionDao.findAll(5);

        request.setAttribute("solutionList", solutionList);

        getServletContext().getRequestDispatcher("/WEB-INF/views/school/school.jsp")
                .forward(request, response);
    }
}
