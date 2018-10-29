package pl.coderslab.Controller.Admin;

import pl.coderslab.Dao.ExerciseDao;
import pl.coderslab.Dao.GroupDao;
import pl.coderslab.Dao.UserDao;
import pl.coderslab.Entity.Exercise;
import pl.coderslab.Entity.Group;
import pl.coderslab.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminPanelController", urlPatterns = {"/panelAdmin"})
public class AdminPanelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Exercise> exerciseList = null;
        List<Group> groupList = null;
        List<User> userList = null;

        try{
            ExerciseDao exerciseDao = new ExerciseDao();
            exerciseList = exerciseDao.findAll();
            GroupDao groupDao = new GroupDao();
            groupList = groupDao.getAllGroups();
            UserDao userDao = new UserDao();
            userList = userDao.findAll();
        }catch (Exception e){
            System.out.println(e);
        }
        request.setAttribute("exerciseList", exerciseList);
        request.setAttribute("groupList", groupList);
        request.setAttribute("userList", userList);

        getServletContext().getRequestDispatcher("/WEB-INF/views/admin/panel.jsp")
                .forward(request, response);
    }
}
