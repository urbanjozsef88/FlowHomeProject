package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Entity.CompletedWorkout;
import hu.flow.workoutTracker.Service.WorkoutHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouthistory")
public class WorkoutHistoryController {


    @Autowired
    private WorkoutHistoryService workoutHistoryService;

    @GetMapping("/{id}")
    public CompletedWorkout getWorkoutById(@PathVariable int id){
        return workoutHistoryService.getCompletedWorkoutById(id);
    }

    @GetMapping
    public List<CompletedWorkout> getAllWorkout(){
        return workoutHistoryService.getAllCompletedWorkouts();
    }

    @GetMapping("/user/{userId}")
    public List<CompletedWorkout> getAllWorkoutByUser(@PathVariable int userId){
        return workoutHistoryService.getComletedWorkoutsByUser(userId);
    }

    @PostMapping
    public void createWorkout(@RequestBody CompletedWorkout completedWorkout){
        workoutHistoryService.createWorkout(completedWorkout);
    }


}
