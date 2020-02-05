package hu.flow.workoutTracker.Repository;

import hu.flow.workoutTracker.Model.CompletedWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WorkoutHistoryRepository extends JpaRepository<CompletedWorkout, Long> {

    @Query("from CompletedWorkout w where w.user.id = ?1")
    List<CompletedWorkout> getAllWorkoutByUser(long userId);

    @Transactional
    @Modifying
    @Query("delete from CompletedWorkout w where w.user.id = ?1")
    void deleteAllByUser(long userId);

}
