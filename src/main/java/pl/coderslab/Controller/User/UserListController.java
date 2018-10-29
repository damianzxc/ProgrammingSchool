package pl.coderslab.Controller.User;

import pl.coderslab.Dao.UserDao;
import pl.coderslab.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListController", urlPatterns = {"/userList"})
public class UserListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> userList = null;

        try{
            UserDao userDao = new UserDao();
            userList = userDao.findAll();
        }catch (Exception e){
            System.out.println(e);
        }

        request.setAttribute("userList", userList);

        getServletContext().getRequestDispatcher("/WEB-INF/views/user/list.jsp")
                .forward(request, response);
    }
}
