package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Entity.Exercise;
import hu.flow.workoutTracker.Entity.Workout;
import hu.flow.workoutTracker.Repository.ExerciseRepository;
import hu.flow.workoutTracker.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;


    public List<Exercise> getAllExercise() {
    return exerciseRepository.findAll();

    }

    public Exercise getExerciseById(int id) {
        if(exerciseRepository.findById(id).isPresent()){
        return exerciseRepository.findById(id).get();}
        else {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
    }


    public List<Exercise> getAllExerciseByWorkout(int id) {
        return exerciseRepository.getAllExerciseByWorkout(id);

    }

    public void addExercise(Exercise exercise) {
        if(workoutRepository.findById(exercise.getWorkout().getId()).isPresent()){
            exercise.setWorkout(workoutRepository.findById(exercise.getWorkout().getId()).get());
        exerciseRepository.save(exercise);}
        else{throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    public void updateExercise(Exercise exercise) {
        exerciseRepository.save(exercise);

    }




}
