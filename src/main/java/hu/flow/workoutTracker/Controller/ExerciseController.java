package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Model.Exercise;
import hu.flow.workoutTracker.Service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
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

    @GetMapping("/byworkout/{workoutId}")
    public List<Exercise> getAllExerciseByWorkout(@PathVariable int workoutId){
        return exerciseService.getAllExerciseByWorkout(workoutId);
    }


    @PostMapping
    public void createExercise(@RequestBody Exercise exercise){
        exerciseService.addExercise(exercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateExcercise(@PathVariable int id, @RequestBody Exercise exercise){
        return exerciseService.updateExercise(id, exercise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable int id){
        return exerciseService.deleteExercise(id);
    }



}
