package hu.flow.workoutTracker.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class WorkoutResponseDTO {

    private String name;
    private LocalDate createdAt;
    private int totalSets;
    private int totalReps;
    private double totalWeightMoved;
}
