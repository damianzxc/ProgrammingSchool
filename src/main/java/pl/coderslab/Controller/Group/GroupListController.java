package pl.coderslab.Controller.Group;

import pl.coderslab.Dao.GroupDao;
import pl.coderslab.Dao.SolutionDao;
import pl.coderslab.Entity.Group;
import pl.coderslab.Entity.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GroupListController", urlPatterns = {"/groups"})
public class GroupListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupDao groupDao = new GroupDao();
        List<Group> groups = groupDao.getAllGroups();

        request.setAttribute("groups", groups);

        getServletContext().getRequestDispatcher("/WEB-INF/views/group/list.jsp")
                .forward(request, response);
    }
}
