package hu.flow.workoutTracker.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CompletedWorkoutDTO {

    private int userId;
    private int workoutId;

}
