package hu.flow.workoutTracker.Repository;

import hu.flow.workoutTracker.Entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}
