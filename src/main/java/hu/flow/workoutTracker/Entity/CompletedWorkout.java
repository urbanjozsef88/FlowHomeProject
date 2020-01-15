package hu.flow.workoutTracker.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class CompletedWorkout{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private LocalDate createdAt;


    //private List<Workout> workoutHistory;

}
