package hu.flow.workoutTracker.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private Workout workout;

}
