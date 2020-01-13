package hu.flow.workoutTracker.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String dob;

    @OneToMany
    private List<Workout> workouts;

    @OneToMany
    private List<CompletedWorkout> completedWorkouts;



}
