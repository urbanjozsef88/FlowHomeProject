package hu.flow.workoutTracker.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private int id;
    private String email;
    private String firstName;
    private String lastName;


}
