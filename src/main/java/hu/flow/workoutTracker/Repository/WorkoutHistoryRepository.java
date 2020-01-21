package hu.flow.workoutTracker.Repository;

import hu.flow.workoutTracker.Model.CompletedWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutHistoryRepository extends JpaRepository<CompletedWorkout, Integer> {

    @Query("from CompletedWorkout w where w.user.id = ?1")
    List<CompletedWorkout> getAllWorkoutByUser(int userId);
}
