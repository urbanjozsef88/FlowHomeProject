package hu.flow.workoutTracker.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.lang.reflect.Type;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
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


    public enum Type{
        CORE, ISOLATION, CARDIO
    }






}
