package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Entity.Workout;
import hu.flow.workoutTracker.Repository.ExerciseRepository;
import hu.flow.workoutTracker.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public Workout getWorkoutById(int id){
        return workoutRepository.findById(id).get();
    }

    public Workout getWorkoutByName(String name){
        return workoutRepository.findByName(name);
    }

    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    public void createWorkout(Workout workout){
        //workout.getExercises().forEach(exerciseRepository::save); // Save the exercises to exercise repo
        workout.setCreatedAt(LocalDate.now());
        workoutRepository.save(workout);
    }

    public void updateWorkout(Workout workout){
        workout.setCreatedAt(LocalDate.now());
        workoutRepository.save(workout);
    }

    public void deleteWorkout(int id){
        workoutRepository.deleteById(id);
    }


}
