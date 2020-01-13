package hu.flow.workoutTracker.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;
    @Column
    private int sets;
    @Column
    private int reps;
    @Column
    private int weight;



}
