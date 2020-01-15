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
    private String type;


    //private Wo_Ex woEx;




}
