package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Model.Exercise;
import hu.flow.workoutTracker.Service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
@CrossOrigin("http://localhost:4200")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public List<Exercise> getAllExercise(){
        return exerciseService.getAllExercise();
    }

    @GetMapping("/{id}")
    public Exercise getExerciseById(@PathVariable long id){
        return exerciseService.getExerciseById(id);
    }

    @GetMapping("/byworkout/{workoutId}")
    public List<Exercise> getAllExerciseByWorkout(@PathVariable long workoutId){
        return exerciseService.getAllExerciseByWorkout(workoutId);
    }


    @PostMapping
    public ResponseEntity<Void> createExercise(@RequestBody Exercise exercise){
       return exerciseService.addExercise(exercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateExcercise(@PathVariable long id, @RequestBody Exercise exercise){
        return exerciseService.updateExercise(id, exercise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable long id){
        return exerciseService.deleteExercise(id);
    }


}
