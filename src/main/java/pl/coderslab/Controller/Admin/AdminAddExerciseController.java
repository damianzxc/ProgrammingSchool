package pl.coderslab.Controller.Admin;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminAddExerciseController", urlPatterns = {"/panelAddExercise"})
public class AdminAddExerciseController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Exercise exercise = new Exercise(title, description);

        ExerciseDao exerciseDao = new ExerciseDao();
        exerciseDao.addExercise(exercise);

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/views/admin/add_exercise.jsp")
                .forward(request, response);
    }
}
