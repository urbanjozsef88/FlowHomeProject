package hu.flow.workoutTracker.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private LocalDate createdAt;

    @ManyToOne
    private User user;

 /*   @Column
    private int userId;*/


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Exercise> exercises;



    public void addExercise(Exercise exerciseToAdd){
        this.exercises.add(exerciseToAdd);
    }





}
