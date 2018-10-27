package pl.coderslab.Controller.Exercise;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ExerciseListController", urlPatterns = {"/exercises"})
public class ExerciseListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExerciseDao exerciseDao = new ExerciseDao();
        List<Exercise> exercises = exerciseDao.findAll();

        request.setAttribute("exercises", exercises);

        getServletContext().getRequestDispatcher("/WEB-INF/views/exercise/list.jsp")
                .forward(request, response);

    }
}
