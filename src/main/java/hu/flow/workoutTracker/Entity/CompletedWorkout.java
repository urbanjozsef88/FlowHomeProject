package hu.flow.workoutTracker.Entity;

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
    private int id;

    @Column
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Workout workout;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;

}
