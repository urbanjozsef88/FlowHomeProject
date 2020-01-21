package hu.flow.workoutTracker.Entity.DTO;

import hu.flow.workoutTracker.Entity.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class WorkoutRequestDTO {

    private String name;
    private List<Exercise> exercises;

}
