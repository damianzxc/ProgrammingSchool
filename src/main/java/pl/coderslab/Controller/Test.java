package pl.coderslab.Controller;

import pl.coderslab.Entity.Exercise;
import pl.coderslab.Entity.Group;
import pl.coderslab.Entity.Solution;
import pl.coderslab.Entity.User;

import java.util.concurrent.SynchronousQueue;

public class Test {

    public static void main(String[] args) {
        Group codersi = new Group("codersi");
        User damian = new User("damian", "damian.zxc@gmail.com", "asdf", codersi);
        Exercise helloWorld = new Exercise("hello", "napisz program...");
        Solution helloWorldSolution = new Solution("12.maj", "12.maj", "description", helloWorld, damian);

        System.out.println(damian.getName());
    }
}
