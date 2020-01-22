package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Model.DTO.WorkoutRequestDTO;
import hu.flow.workoutTracker.Model.Exercise;
import hu.flow.workoutTracker.Model.Workout;
import hu.flow.workoutTracker.Repository.ExerciseRepository;
import hu.flow.workoutTracker.Repository.UserRepository;
import hu.flow.workoutTracker.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
         else{throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    }

/*    public Workout getWorkoutByName(String name){
        return workoutRepository.findByName(name);
    }*/

    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    public List<Workout> getAllWorkoutByUser(int userId) {
        if(userRepository.findById(userId).isPresent()){
            return workoutRepository.getAllWorkoutByUser(userId);}
        else{ throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    }

    public ResponseEntity<Void> createWorkout(int userId, WorkoutRequestDTO workoutRequestDTO){
        if(!userRepository.findById(userId).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else{
            // If the user already uses the workout name, it throws bad_request status
            if(workoutRepository.getAllWorkoutByUser(userId)
                    .stream().anyMatch(w -> w.getName().equals(workoutRequestDTO.getName())))
            {throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}
            else{
            Workout workout = Workout.builder()
                    .name(workoutRequestDTO.getName())
                    .user(userRepository.findById(userId).get())
                    .exercises(workoutRequestDTO.getExercises())
                    .build();
        workout.getExercises().forEach(exercise -> exercise.setWorkout(workout));
        workout.setCreatedAt(LocalDate.now());

        updateTotalDetails(workout);

        workoutRepository.save(workout);
            return new ResponseEntity(HttpStatus.CREATED);}}

    }

    public void updateWorkout(Workout workout){
        if(workoutRepository.findById(workout.getId()).isPresent()){
            Workout wo = workoutRepository.findById(workout.getId()).get();
            wo.setCreatedAt(LocalDate.now());
            wo.setName(workout.getName());
            workoutRepository.save(wo);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteWorkout(int id){
        if(workoutRepository.findById(id).isPresent()){
           workoutRepository.deleteById(id);
    } else{throw new ResponseStatusException(HttpStatus.NOT_FOUND);}}


    public static Workout updateTotalDetails(Workout workout){

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
                .map(exercise -> exercise.getReps()*exercise.getSets()*exercise.getWeight())
                .mapToInt(n -> (int)n).sum()));

        return workout;
    }


}
