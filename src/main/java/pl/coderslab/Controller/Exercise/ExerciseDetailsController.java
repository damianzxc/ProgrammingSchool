package pl.coderslab.Controller.Exercise;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Dao.SolutionDao;
import pl.coderslab.Entity.Exercise;
import pl.coderslab.Entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ExerciseDetailsController")
public class ExerciseDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Exercise exercise = null;
        List<Solution> solutions = null;

        try{
            Integer id = Integer.parseInt(request.getParameter("id"));
            ExerciseDao exerciseDao = new ExerciseDao();
            exercise = exerciseDao.findById(id);
            SolutionDao solutionDao = new SolutionDao();
            solutions = solutionDao.findAll();
        }catch (Exception e){
            System.out.println(e);
        }

        request.setAttribute("exercise", exercise);
        request.setAttribute("solutions", solutions);

        getServletContext().getRequestDispatcher("/WEB-INF/views/exercise/details.jsp")
                .forward(request, response);
    }
}
