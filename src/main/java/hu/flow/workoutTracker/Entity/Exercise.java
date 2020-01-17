package hu.flow.workoutTracker.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@Entity
@Table
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private int sets;
    @Column
    private int reps;
    @Column
    private int weight;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Workout workout;









}
