package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Entity.Workout;
import hu.flow.workoutTracker.Repository.ExerciseRepository;
import hu.flow.workoutTracker.Repository.UserRepository;
import hu.flow.workoutTracker.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private ExerciseService exerciseService;

    public Workout getWorkoutById(int id){
         if(workoutRepository.findById(id).isPresent()){
            return workoutRepository.findById(id).get();}
         else{throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}
    }

/*    public Workout getWorkoutByName(String name){
        return workoutRepository.findByName(name);
    }*/

    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    public void createWorkout(Workout workout){
        ; // Save the exercises to exercise repo
        if(workoutRepository.findByName(workout.getName()) != null
           && userRepository.findById(workout.getUser().getId()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        workout.getExercises().forEach(exercise -> exercise.setWorkout(workout));
        workout.setCreatedAt(LocalDate.now());
        workout.setUser(userRepository.findById(workout.getUser().getId()).get());
        workoutRepository.save(workout);
    }

    public void updateWorkout(Workout workout){
        workout.setCreatedAt(LocalDate.now());
        workoutRepository.save(workout);
    }

    public void deleteWorkout(int id){
        if(userRepository.findById(id).isPresent()){
        workoutRepository.deleteById(id);
    } else{throw new ResponseStatusException(HttpStatus.NOT_FOUND);}}


    public List<Workout> getAllWorkoutByUser(int userId) {
        if(userRepository.findById(userId).isPresent()){
        return workoutRepository.getAllWorkoutByWorkout(userId);}
        else{ throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    }
}
