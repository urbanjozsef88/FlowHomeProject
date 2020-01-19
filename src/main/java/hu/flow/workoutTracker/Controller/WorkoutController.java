package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Entity.DTO.WorkoutRequestDTO;
import hu.flow.workoutTracker.Entity.Workout;
import hu.flow.workoutTracker.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
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

/*    @GetMapping("/{name}")
    public Workout getWorkoutByName(@PathVariable String name){
        return workoutService.getWorkoutByName(name);
    }*/

    @GetMapping                                   // There will be no need for all workouts, just by users
    public List<Workout> getAllWorkout(){
        return workoutService.getAllWorkouts();}


    @GetMapping("/user/{userId}")
    public List<Workout> getAllWorkoutByUser(@PathVariable int userId){
        return workoutService.getAllWorkoutByUser(userId);
    }


    @PostMapping
    public void createWorkout(@RequestBody WorkoutRequestDTO workoutRequestDTO){
        workoutService.createWorkout(workoutRequestDTO);
    }

    @PutMapping()
    public void updateWorkout(@RequestBody Workout workout){
        workoutService.updateWorkout(workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable int id){
        workoutService.deleteWorkout(id);
    }



}
