package pl.coderslab.Dao;

import com.sun.xml.internal.bind.v2.TODO;
import pl.coderslab.Entity.Group;
import pl.coderslab.Entity.User;
import pl.coderslab.Service.DBService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    public User getById(Integer id){
        String query = "SELECT * FROM `user` WHERE `user`.`id` = ? ";
        List<String> params = new ArrayList<>();
        params.add(id.toString());

        try{
            // get result from executed select query
            List<Map<String, String>> result = DBService.executeSelect(dbName, query, params);
            if(result.size()>0){
                Map<String, String> select = result.get(0);

                User user = createUser(select);

                return user;
            }


        }catch (SQLException e){
            System.out.println(e);
        }

        return null;
    }

    public User createUser(Map<String, String> data){
        GroupDao groupDao = new GroupDao();
        Group group = groupDao.getById(Integer.parseInt(data.get("group_id")));

        User user = new User();
        user.setId(Integer.parseInt(data.get("id")));
        user.setUsername(data.get("username"));
        user.setPassword(data.get("password"));
        user.setEmail(data.get("email"));
        user.setGroup(group);

        return user;
    }

    public List<User> findAll(){
        String query = "SELECT * FROM `user` ";
        return find(query, null);
    }

    public List<User> findByGroup(Integer groupId){
        String query = "SELECT * FROM `user` WHERE `user`.`group_id` ="+groupId;
        return find(query, null);
    }

    private List<User> find(String query, List<String> params){
        try{
            List<Map<String, String>> result = DBService.executeSelect(dbName, query, null);
            List<User> users = new ArrayList<>();

            if(result.size()>0){

                for(Map<String, String> row: result){

                    User user = createUser(row);
                    users.add(user);
                }

                return users;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

}
