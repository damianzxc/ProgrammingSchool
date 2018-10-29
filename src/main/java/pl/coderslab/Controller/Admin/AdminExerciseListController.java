package pl.coderslab.Controller.Admin;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Entity.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminExerciseListController" ,urlPatterns = {"/panelExerciseList"})
public class AdminExerciseListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Exercise> exerciseList = null;

        try{
            ExerciseDao exerciseDao = new ExerciseDao();
            exerciseList = exerciseDao.findAll();
        }catch(Exception e){
            System.out.println(e);
        }
        request.setAttribute("exerciseList", exerciseList);
        getServletContext().getRequestDispatcher("/WEB-INF/views/admin/exercises.jsp")
                .forward(request, response);
    }
}
