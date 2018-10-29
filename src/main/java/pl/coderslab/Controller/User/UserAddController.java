package pl.coderslab.Controller.User;

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

@WebServlet(name = "UserAddController", urlPatterns = {"/panelAddUser"})
public class UserAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String groupIp = request.getParameter("group_id");

        GroupDao groupDao = new GroupDao();
        Group group = groupDao.getById(Integer.parseInt(groupIp));

        User user = new User(username, email, password, group);
        UserDao userDao = new UserDao();
        userDao.addUser(user);

        response.sendRedirect("/user?id="+user.getId());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();
        List<Group> groupList = groupDao.getAllGroups();

        request.setAttribute("groupList", groupList);

        getServletContext().getRequestDispatcher("/WEB-INF/views/user/add.jsp")
                .forward(request, response);
    }
}
