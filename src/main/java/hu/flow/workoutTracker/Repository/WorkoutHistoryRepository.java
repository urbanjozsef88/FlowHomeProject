package hu.flow.workoutTracker.Repository;

import hu.flow.workoutTracker.Entity.CompletedWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutHistoryRepository extends JpaRepository<CompletedWorkout, Integer> {


}
