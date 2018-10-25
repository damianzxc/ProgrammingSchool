package pl.coderslab.Dao;

import pl.coderslab.Entity.Group;
import pl.coderslab.Service.DBService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {

    private String dbName = "school";
    private String tableName = "group";

    // add a new group
    public void addGroup (Group group){
        String query = "INSERT INTO `group` (`id`, `name`) VALUES (NULL, ?)";
        List<String> params = new ArrayList<>();
        params.add(group.getName());

        try{
            Integer newGroupId = DBService.executeInsert(dbName, query, params);
            if(newGroupId != null){
                group.setId(newGroupId);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
