package pl.coderslab.Dao;

import pl.coderslab.Entity.Group;
import pl.coderslab.Service.DBService;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupDao {

    private String dbName = "school";
    private String tableName = "group";

    // add a new group
    public void addGroup(Group group){
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

    // delete a group
    public void deleteGroup(Integer id){
        String query = "DELETE FROM `group` WHERE `group`.`id` = ?;";
        List<String> params = new ArrayList<>();
        params.add(id.toString());
        try{
            DBService.executeUpdate(dbName, query, params);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    // get by id
    public Group getById(Integer id){
        String query = "SELECT * FROM `group` WHERE `group`.`id` = ?";
        List<String> params = new ArrayList<>();
        params.add(id.toString());
        try{
            // beacuse executeSelect returns a List<Map>
            List<Map<String, String>> result = DBService.executeSelect(dbName, query, params);
            Map<String, String> resultGroup = result.get(0);
            Group group = new Group();
            group.setId(Integer.parseInt(resultGroup.get("id")));
            group.setName(resultGroup.get("name"));
            return group;

        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    // show all groups
    public List<Group> getAllGroups(){
        String query = "SELECT * FROM `group` ";

        try{
            List<Map<String, String>> result = DBService.executeSelect(dbName, query, null);
            List<Group> groups = new ArrayList<>();

            for(Map<String, String> row: result){
                Group group = new Group();
                group.setId(Integer.parseInt(row.get("id")));
                group.setName(row.get("name"));
                groups.add(group);
            }
            return groups;
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }


}
