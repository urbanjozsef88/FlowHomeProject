package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Model.Exercise;
import hu.flow.workoutTracker.Model.Workout;
import hu.flow.workoutTracker.Repository.ExerciseRepository;
import hu.flow.workoutTracker.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutService workoutService;


    public List<Exercise> getAllExercise() {
    return exerciseRepository.findAll();

    }

    public Exercise getExerciseById(int id) {
        if(exerciseRepository.findById(id).isPresent()){
        return exerciseRepository.findById(id).get();}
        else {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    }


    public List<Exercise> getAllExerciseByWorkout(int id) {
        if(workoutRepository.findById(id).isPresent()) {
            return exerciseRepository.getAllExerciseByWorkout(id);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> addExercise(Exercise exercise) {
        if(workoutRepository.findById(exercise.getWorkout().getId()).isPresent()){
            exercise.setWorkout(workoutRepository.findById(exercise.getWorkout().getId()).get());
        exerciseRepository.save(exercise);
        return new ResponseEntity(HttpStatus.CREATED);}
        else{throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<Void> updateExercise(int id, Exercise exercise) {
        exerciseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Exercise exer = exerciseRepository.findById(id).get();
        exer.setName(exercise.getName());
        exer.setReps(exercise.getReps());
        exer.setSets(exercise.getSets());
        exer.setType(exercise.getType());
        exer.setWeight(exercise.getWeight());

        Workout toUpdate = workoutRepository.findById(exer.getWorkout().getId()).get();
        WorkoutService.updateTotalDetails(toUpdate);
        workoutRepository.save(toUpdate);

        exerciseRepository.save(exer);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteExercise(int id){
        if(exerciseRepository.findById(id).isPresent()){
            int tmpId = exerciseRepository
                    .findById(id)
                    .get().getWorkout()
                    .getId();
            exerciseRepository.deleteById(id);

            Workout toUpdate = workoutRepository.findById(tmpId).get();
            WorkoutService.updateTotalDetails(toUpdate);
            workoutRepository.save(toUpdate);

            return ResponseEntity.ok().build(); }
        else{ return ResponseEntity.notFound().build();}
    }


}
