package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Entity.Workout;
import hu.flow.workoutTracker.Service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/{id}")
    public Workout getWorkoutById(@PathVariable int id){
        return workoutService.getWorkoutById(id);
    }

    @GetMapping("/{name}")
    public Workout getWorkoutByName(@PathVariable String name){
        return workoutService.getWorkoutByName(name);
    }

    @GetMapping
    public List<Workout> getAllWorkout(){
        return workoutService.getAllWorkouts();
    }


    @PostMapping
    public void createWorkout(@RequestBody Workout workout){
        workoutService.createWorkout(workout);
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
