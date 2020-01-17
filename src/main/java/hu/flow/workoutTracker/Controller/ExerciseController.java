package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Entity.Exercise;
import hu.flow.workoutTracker.Service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public List<Exercise> getAllExercise(){
        return exerciseService.getAllExercise();
    }

/*    @GetMapping("/{id}")
    public Exercise getExerciseById(@PathVariable int id){
        return exerciseService.getExerciseById(id);
    }*/

    @GetMapping("/{workoutId}")
    public List<Exercise> getAllExerciseByWorkout(@PathVariable int workoutId){
        return exerciseService.getAllExerciseByWorkout(workoutId);
    }



}
