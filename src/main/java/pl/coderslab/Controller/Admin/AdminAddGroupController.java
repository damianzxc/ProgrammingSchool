package pl.coderslab.Controller.Admin;

import pl.coderslab.Dao.GroupDao;
import pl.coderslab.Entity.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminAddGroupController", urlPatterns = {"/panelAddGroup"})
public class AdminAddGroupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        Group group = new Group(name);
        GroupDao groupDao = new GroupDao();
        groupDao.addGroup(group);

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/views/admin/add_group.jsp")
                .forward(request, response);
    }
}
