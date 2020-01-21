package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Entity.DTO.WorkoutRequestDTO;
import hu.flow.workoutTracker.Entity.Exercise;
import hu.flow.workoutTracker.Entity.Workout;
import hu.flow.workoutTracker.Repository.ExerciseRepository;
import hu.flow.workoutTracker.Repository.UserRepository;
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

    public ResponseEntity<Void> createWorkout(int userId, WorkoutRequestDTO workoutRequestDTO){

        if(workoutRepository.findByName(workoutRequestDTO.getName()) != null
           && !userRepository.findById(userId).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else{
            Workout workout = Workout.builder()
                    .name(workoutRequestDTO.getName())
                    .user(userRepository.findById(userId).get())
                    .exercises(workoutRequestDTO.getExercises())
                    .build();

  //     workout.getExercises().forEach(exercise -> exercise.setWorkout(workout));
        workout.setCreatedAt(LocalDate.now());
  //      workout.setUser(userRepository.findById(workout.getUser().getId()).get());
        int countreps = workout.getExercises().stream()
                .filter(e -> e != null && e.getReps() != 0)
                .mapToInt(Exercise::getReps)
                .sum();
        workout.setTotalReps(countreps);
        int countsets = workout.getExercises().stream()
                .filter(e -> e != null && e.getReps() != 0)
                .mapToInt(Exercise::getSets)
                .sum();
        workout.setTotalSets(countsets);

        workout.setTotalWeightMoved((workout.getExercises().stream()
                .filter(e -> e != null && e.getWeight() != 0)
                .mapToDouble(Exercise::getWeight)
                .sum()) * countsets * countreps);

        workoutRepository.save(workout);
            return new ResponseEntity(HttpStatus.CREATED);}

    }

    public void updateWorkout(Workout workout){
        workout.setCreatedAt(LocalDate.now());
        workoutRepository.save(workout);
    }

    public void deleteWorkout(int id){
        if(workoutRepository.findById(id).isPresent()){
        workoutRepository.deleteById(id);
    } else{throw new ResponseStatusException(HttpStatus.NOT_FOUND);}}


    public List<Workout> getAllWorkoutByUser(int userId) {
        if(userRepository.findById(userId).isPresent()){
        return workoutRepository.getAllWorkoutByWorkout(userId);}
        else{ throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    }
}
