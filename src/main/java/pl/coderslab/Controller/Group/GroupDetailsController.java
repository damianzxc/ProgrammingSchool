package pl.coderslab.Controller.Group;

import pl.coderslab.Dao.GroupDao;
import pl.coderslab.Dao.UserDao;
import pl.coderslab.Entity.Group;
import pl.coderslab.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroupDetailsController", urlPatterns = "/groupdisplay")
public class GroupDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Group group = null;
        List<User> users = null;


        try{
            Integer id = Integer.parseInt(request.getParameter("id"));
            GroupDao groupDao = new GroupDao();
            group = groupDao.getById(id);
            UserDao userDao = new UserDao();
            users = userDao.findByGroup(id);
        }catch (Exception e){
            System.out.println(e);
        }

        request.setAttribute("group", group);
        request.setAttribute("users", users);

        getServletContext().getRequestDispatcher("/WEB-INF/views/group/details.jsp")
                .forward(request, response);
    }
}
