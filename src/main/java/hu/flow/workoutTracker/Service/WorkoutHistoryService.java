package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Entity.CompletedWorkout;
import hu.flow.workoutTracker.Entity.Workout;
import hu.flow.workoutTracker.Repository.WorkoutHistoryRepository;
import hu.flow.workoutTracker.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutHistoryService {


    @Autowired
    private WorkoutHistoryRepository workoutHistoryRepository;

    public CompletedWorkout getWorkoutById(int id){
        return workoutHistoryRepository.findById(id).get();
    }

    public List<CompletedWorkout> getAllWorkouts(){
        return workoutHistoryRepository.findAll();
    }

    public void createWorkout(CompletedWorkout completedWorkout){
        completedWorkout.setCreatedAt(LocalDate.now());
        workoutHistoryRepository.save(completedWorkout);
    }
}
