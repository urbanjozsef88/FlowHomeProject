package hu.flow.workoutTracker.Repository;

import hu.flow.workoutTracker.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    public User findByEmail(String email);


}
