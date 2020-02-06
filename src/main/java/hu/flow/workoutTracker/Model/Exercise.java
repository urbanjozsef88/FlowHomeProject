package hu.flow.workoutTracker.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private MeasurementType type;
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


    public enum MeasurementType{
        KG, LB
    }


    @Override
    public String toString() {
        return  name  +
                ": " + sets +
                " X " + reps +
                " X " + weight + " " + type +";  ";
    }
}
