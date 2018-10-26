package pl.coderslab.Dao;

import pl.coderslab.Entity.Exercise;
import pl.coderslab.Entity.Solution;
import pl.coderslab.Entity.User;
import pl.coderslab.Service.DBService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolutionDao {

    private String dbName = "school";
    private String tableName = "solution";

    /*
    TODO
    createUser
    createExercise
    createSolution
     */

    public Solution createSolution(Map<String, String> data){
        UserDao userDao = new UserDao();
        User user = userDao.getById(Integer.parseInt(data.get("user_id")));

        ExerciseDo exerciseDo = new ExerciseDo();
        /*
        nie mam jeszcze metod w klasie exerciseDao
         */
        Exercise exercise = null;

        Solution solution = new Solution();
        solution.setUser(user);
        solution.setExercise(exercise);
        solution.setId(Integer.parseInt(data.get("id")));
        solution.setCreated(data.get("created"));
        solution.setUpdated(data.get("updated"));
        solution.setDescription(data.get("description"));

        return solution;
    }

    public List<Solution> findAll(){
        String query = "SELECT * FROM `solution` ";
        return find(query);
    }

    public List<Solution> findAll(Integer limit){
        String query = "SELECT * FROM `solution` ORDER BY `updated` DESC LIMIT "+limit;
        return find(query);
    }

    private List<Solution> find(String query){
        try{
            // executeSelect returns a List<Map>
            List<Map<String, String>> result = DBService.executeSelect(dbName, query, null);
            // I need a list of all solutions
            List<Solution> solutionList= new ArrayList<>();

            for(Map<String, String> row: result){
                Solution solution = createSolution(row);
                solutionList.add(solution);
            }
            return solutionList;

        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
