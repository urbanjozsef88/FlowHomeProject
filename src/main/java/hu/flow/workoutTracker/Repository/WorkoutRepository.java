package hu.flow.workoutTracker.Repository;

import hu.flow.workoutTracker.Model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

    public Workout findByName(String name);

    @Query("from Workout w where w.user.id = ?1")
    List<Workout> getAllWorkoutByWorkout(int id);


}
