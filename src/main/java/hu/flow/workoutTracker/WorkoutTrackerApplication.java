package hu.flow.workoutTracker;

import net.minidev.json.JSONUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class WorkoutTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutTrackerApplication.class, args);
	}



}
