package pl.coderslab.Dao;

import pl.coderslab.Entity.Exercise;
import pl.coderslab.Service.DBService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExerciseDao {

    private String dbName = "school";

    public List<Exercise> findAll(){
        String query = "SELECT * FROM `exercise` ";
        return find(query);
    }
    public Exercise findById(Integer id){
        String query = "SELECT * FROM `exercise` WHERE `exercise`.`id` ="+id;
        List<Exercise> result = find(query);

        if(result.size()>0){
            Exercise exercise = result.get(0);
            return exercise;
        }
        return null;
    }

    private List<Exercise> find(String query){
        try {
            List<Map<String, String>> result = DBService.executeSelect(dbName, query, null);
            List<Exercise> exerciseList = new ArrayList<>();

            for (Map<String, String> row : result) {
                Exercise exercise = createExercise(row);
                exerciseList.add(exercise);
            }
            return exerciseList;

        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    public Exercise createExercise(Map<String, String> data){

        Exercise exercise = new Exercise();
        exercise.setId(Integer.parseInt(data.get("id")));
        exercise.setTitle(data.get("title"));
        exercise.setDescription(data.get("description"));

        return exercise;
    }
}
