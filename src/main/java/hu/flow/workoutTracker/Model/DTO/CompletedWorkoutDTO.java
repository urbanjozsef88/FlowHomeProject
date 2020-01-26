package hu.flow.workoutTracker.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CompletedWorkoutDTO {

    private long userId;
    private long workoutId;

}
