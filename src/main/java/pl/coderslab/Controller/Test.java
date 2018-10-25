package pl.coderslab.Controller;

import pl.coderslab.Dao.GroupDao;
import pl.coderslab.Entity.Exercise;
import pl.coderslab.Entity.Group;
import pl.coderslab.Entity.Solution;
import pl.coderslab.Entity.User;

import java.util.concurrent.SynchronousQueue;

public class Test {

    public static void main(String[] args) {
        Group codersi = new Group("codersi");
        GroupDao groupDao = new GroupDao();
        //groupDao.addGroup(codersi);
        //groupDao.deleteGroup(8);
        System.out.println(groupDao.getById(1));
        Group g12 = groupDao.getById(5);
        System.out.println(g12.getName());
        System.out.println(g12.getId());




        //User damian = new User("damian", "damian.zxc@gmail.com", "asdf", codersi);
        //Exercise helloWorld = new Exercise("hello", "napisz program...");
        //Solution helloWorldSolution = new Solution("12.maj", "12.maj", "description", helloWorld, damian);

        //System.out.println(damian.getName());
    }
}
