package hu.flow.workoutTracker.Repository;

import hu.flow.workoutTracker.Entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

    public Workout findByName(String name);


}
