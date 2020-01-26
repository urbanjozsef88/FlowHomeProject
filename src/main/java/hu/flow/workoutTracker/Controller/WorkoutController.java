package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Model.DTO.WorkoutRequestDTO;
import hu.flow.workoutTracker.Model.Workout;
import hu.flow.workoutTracker.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/{id}")
    public Workout getWorkoutById(@PathVariable int id){
        return workoutService.getWorkoutById(id);
    }


    @GetMapping                                   // There will be no need for all workouts, just by users
    public List<Workout> getAllWorkout(){
        return workoutService.getAllWorkouts();}


    @GetMapping("/currentuser/{userId}")
    public List<Workout> getAllWorkoutByUser(@PathVariable long userId){
        return workoutService.getAllWorkoutByUser(userId);
    }


    @PostMapping("/currentuser/{userId}")
    public ResponseEntity<Void> createWorkout(@PathVariable long userId, @RequestBody WorkoutRequestDTO workoutRequestDTO){
       return workoutService.createWorkout(userId, workoutRequestDTO);
    }

    @PutMapping()
    public void updateWorkout(@RequestBody Workout workout){
        workoutService.updateWorkout(workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable long id){
        workoutService.deleteWorkout(id);
    }


}
