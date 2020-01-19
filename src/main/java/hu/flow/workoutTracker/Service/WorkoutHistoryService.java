package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Entity.CompletedWorkout;
import hu.flow.workoutTracker.Entity.Workout;
import hu.flow.workoutTracker.Repository.UserRepository;
import hu.flow.workoutTracker.Repository.WorkoutHistoryRepository;
import hu.flow.workoutTracker.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutHistoryService {


    @Autowired
    private WorkoutHistoryRepository workoutHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    public CompletedWorkout getCompletedWorkoutById(int id){
        return workoutHistoryRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<CompletedWorkout> getAllCompletedWorkouts(){
        return workoutHistoryRepository.findAll();
    }

    public void createWorkout(CompletedWorkout completedWorkout){  //TODO: refactor
        completedWorkout.setCreatedAt(LocalDate.now());
        workoutHistoryRepository.save(completedWorkout);
    }

    public List<CompletedWorkout> getComletedWorkoutsByUser(int userId) {
        if(userRepository.findById(userId).isPresent()){
        return workoutHistoryRepository.getAllWorkoutByUser(userId);
        } else{ throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    }
}
