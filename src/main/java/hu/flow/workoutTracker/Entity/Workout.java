package hu.flow.workoutTracker.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private LocalDate createdAt;

    @Column
    private int totalSets;
    @Column
    private int totalReps;
    @Column
    private double totalWeightMoved;


    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private User user;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workout")
    @JsonManagedReference
    private List<Exercise> exercises;



}
