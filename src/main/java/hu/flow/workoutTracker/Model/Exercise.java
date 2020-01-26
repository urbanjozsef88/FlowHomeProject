package hu.flow.workoutTracker.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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


    @Override
    public String toString() {
        return  "Exercise:'" + name + '\'' +
                ", type:" + type +
                ", sets:" + sets +
                ", reps:" + reps +
                ", weight:" + weight + "; ";
    }
}
