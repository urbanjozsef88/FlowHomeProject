package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Entity.Exercise;
import hu.flow.workoutTracker.Repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;


    public List<Exercise> getAllExercise() {
    return exerciseRepository.findAll();

    }

    public Exercise getExerciseById(int id) {
        return exerciseRepository.findById(id).get();
    }


    public List<Exercise> getAllExerciseByWorkout(int id) {
        return exerciseRepository.getAllExerciseByWorkout(id);

    }
}
