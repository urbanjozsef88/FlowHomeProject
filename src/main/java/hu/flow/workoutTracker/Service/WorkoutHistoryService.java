package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Entity.CompletedWorkout;
import hu.flow.workoutTracker.Entity.DTO.CompletedWorkoutDTO;
import hu.flow.workoutTracker.Entity.Workout;
import hu.flow.workoutTracker.Repository.UserRepository;
import hu.flow.workoutTracker.Repository.WorkoutHistoryRepository;
import hu.flow.workoutTracker.Repository.WorkoutRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private WorkoutRepository workoutRepository;

    public CompletedWorkout getCompletedWorkoutById(int id){
        return workoutHistoryRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<CompletedWorkout> getAllCompletedWorkouts(){
        return workoutHistoryRepository.findAll();
    }

    public ResponseEntity<Void> createCompletedWorkout(int userId, int workoutId){
        if(userRepository.findById(userId).isPresent()
           && workoutRepository.findById(workoutId).isPresent()){
        CompletedWorkout fromDTO = new CompletedWorkout();
        fromDTO.setCreatedAt(LocalDate.now());
        fromDTO.setUser(userRepository.findById(userId).get());
        fromDTO.setWorkout(workoutRepository.findById(workoutId).get());
        workoutHistoryRepository.save(fromDTO);
            return new ResponseEntity(HttpStatus.CREATED);}
        else{throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}
    }

    public List<CompletedWorkout> getCompletedWorkoutsByUser(int userId) {
        if(userRepository.findById(userId).isPresent()){
        return workoutHistoryRepository.getAllWorkoutByUser(userId);
        } else{ throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    }
}
