package pl.coderslab.Controller.Admin;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminExerciseController", urlPatterns = {"/panelAdminExercise"})
public class AdminExerciseController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Exercise exercise = null;

        try{
            Integer id = Integer.parseInt(request.getParameter("id"));
            ExerciseDao exerciseDao = new ExerciseDao();
            exercise = exerciseDao.findById(id);
        }catch (Exception e){
            System.out.println(e);
        }
        request.setAttribute("exercise", exercise);
        getServletContext().getRequestDispatcher("/WEB-INF/views/admin/exercise_details.jsp")
                .forward(request, response);
    }
}
