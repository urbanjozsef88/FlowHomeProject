package hu.flow.workoutTracker.Repository;

import hu.flow.workoutTracker.Entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {


    @Query("from Exercise e where e.workout.id = ?1")
    List<Exercise> getAllExerciseByWorkout(int id);
}
