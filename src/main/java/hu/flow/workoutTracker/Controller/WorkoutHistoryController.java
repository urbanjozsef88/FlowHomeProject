package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Model.CompletedWorkout;
import hu.flow.workoutTracker.Service.WorkoutHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouthistory")
@CrossOrigin("http://localhost:4200")
public class WorkoutHistoryController {


    @Autowired
    private WorkoutHistoryService workoutHistoryService;

 /*   @GetMapping("/{id}")
    public CompletedWorkout getWorkoutById(@PathVariable long id){
        return workoutHistoryService.getCompletedWorkoutById(id);
    }*/

 /*   @GetMapping
    public List<CompletedWorkout> getAllWorkout(){
        return workoutHistoryService.getAllCompletedWorkouts();
    }*/

    @GetMapping("/currentuser/{userId}")
    public List<CompletedWorkout> getAllWorkoutByUser(@PathVariable long userId){
        return workoutHistoryService.getCompletedWorkoutsByUser(userId);
    }

    @PostMapping("/currentuser/{userId}/workout/{workoutId}")
    public ResponseEntity<Void> createCompletedWorkout(@PathVariable long userId, @PathVariable long workoutId) {
       return workoutHistoryService.createCompletedWorkout(userId, workoutId);
    }

    @DeleteMapping("/currentuser/{userId}")
    public ResponseEntity<Void> deleteWorkoutHistory(@PathVariable long userId){
        return workoutHistoryService.clearHisroy(userId);
    }

//(@RequestBody CompletedWorkoutDTO dto)
}
