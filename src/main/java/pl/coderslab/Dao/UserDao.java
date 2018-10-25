package pl.coderslab.Dao;

import com.sun.xml.internal.bind.v2.TODO;
import pl.coderslab.Entity.Group;
import pl.coderslab.Entity.User;
import pl.coderslab.Service.DBService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private String dbName = "school";
    private String tableName = "user";

    /*
    TODO
    1.find user by id
    2.get all users
    3.create user
    4.update user
    5.delete
    */

    // add a new user
    public void addUser(User user){
        String query = "INSERT INTO `user` (`id`, `username`, `email`, `password`, `group_id`) VALUES (NULL, ?, ?, ?, ?)";
        List<String> params = new ArrayList<>();
        params.add(user.getUsername());
        params.add(user.getEmail());
        params.add(user.getPassword());
        params.add(user.getGroup().getId().toString());

        /*
        TODO
        move it later to an external method (but where?, create a new Dao or put into DBService??
         */
        try{
            Integer newUserId = DBService.executeInsert(dbName, query, params);
            if(newUserId != null){
                user.setId(newUserId);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }


}
