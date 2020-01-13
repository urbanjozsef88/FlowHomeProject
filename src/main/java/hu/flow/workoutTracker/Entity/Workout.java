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

    @ManyToMany
    private List<Exercise> exercises;



}
