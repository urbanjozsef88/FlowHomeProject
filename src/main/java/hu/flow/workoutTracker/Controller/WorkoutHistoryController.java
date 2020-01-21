package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Model.CompletedWorkout;
import hu.flow.workoutTracker.Service.WorkoutHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/currentuser/{userId}")
    public List<CompletedWorkout> getAllWorkoutByUser(@PathVariable int userId){
        return workoutHistoryService.getCompletedWorkoutsByUser(userId);
    }

    @PostMapping("/currentuser/{userId}/workout/{workoutId}")
    public ResponseEntity<Void> createCompletedWorkout(@PathVariable int userId, @PathVariable int workoutId) {
       return workoutHistoryService.createCompletedWorkout(userId, workoutId);
    }

//(@RequestBody CompletedWorkoutDTO dto)
}
