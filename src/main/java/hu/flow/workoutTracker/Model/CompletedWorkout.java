package hu.flow.workoutTracker.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
public class CompletedWorkout{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private LocalDate createdAt;

    @Column
    private String workoutDetails;

    @Column
    private String workoutContent;

/*    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Workout workout;*/

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;


}
