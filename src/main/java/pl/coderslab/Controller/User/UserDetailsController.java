package pl.coderslab.Controller.User;

import pl.coderslab.Dao.SolutionDao;
import pl.coderslab.Dao.UserDao;
import pl.coderslab.Entity.Solution;
import pl.coderslab.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserDetailsController", urlPatterns = {"/user"})
public class UserDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = null;
        List<Solution> solutions = null;

        try{
            Integer id = Integer.parseInt(request.getParameter("id"));
            UserDao userDao = new UserDao();
            user = userDao.findById(id);


            // for test,
            SolutionDao solutionDao = new SolutionDao();
            solutions = solutionDao.findAll();
        }catch (NullPointerException e){
            System.out.println(e);
        }

        request.setAttribute("user", user);
        request.setAttribute("solutions", solutions);

        getServletContext().getRequestDispatcher("/WEB-INF/views/user/details.jsp")
                .forward(request, response);
    }
}
