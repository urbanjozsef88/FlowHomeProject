package hu.flow.workoutTracker.utils;

import hu.flow.workoutTracker.Model.DTO.WorkoutRequestDTO;
import hu.flow.workoutTracker.Model.Exercise;
import hu.flow.workoutTracker.Model.User;
import hu.flow.workoutTracker.Repository.UserRepository;
import hu.flow.workoutTracker.Service.UserService;
import hu.flow.workoutTracker.Service.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
@AllArgsConstructor
public class initDataLoader {

    //private final BCryptPasswordEncoder bCryptPasswordEncoder;
    //private final UserRepository userRepository;

    private final UserService userService;
    private final WorkoutService workoutService;


    @PostConstruct
    public void init() {
        loadUser();
        loadWorkouts();
    }

    private void loadUser() {
        userService.createUser(User.builder().id(1L).email("jozsi@gmail.com")
                .firstName("Jozsef").lastName("Urban").password("1234").build());
        userService.createUser(User.builder().id(2L).email("johnnysmith@gmail.com")
                .firstName("John").lastName("Smith").password("password").build());
    }

    private void loadWorkouts() {

        List<Exercise> exercises1 = new ArrayList<>();
        exercises1.add(Exercise.builder().name("Bench Press").sets(4).reps(10).weight(100).type(Exercise.MeasurementType.KG).build());
        exercises1.add(Exercise.builder().name("Incline Press with Dumbbells").sets(3).reps(12).weight(30).type(Exercise.MeasurementType.KG).build());
        exercises1.add(Exercise.builder().name("Cable Crossovers").sets(3).reps(20).weight(25).type(Exercise.MeasurementType.KG).build());
        exercises1.add(Exercise.builder().name("Dips").sets(2).reps(15).weight(10).type(Exercise.MeasurementType.KG).build());
        exercises1.add(Exercise.builder().name("Skull Crushers").sets(3).reps(18).weight(30).type(Exercise.MeasurementType.KG).build());
        exercises1.add(Exercise.builder().name("Cable Pushdowns").sets(2).reps(20).weight(40).type(Exercise.MeasurementType.KG).build());
        exercises1.add(Exercise.builder().name("Triceps Extensions").sets(3).reps(12).weight(10).type(Exercise.MeasurementType.KG).build());
        WorkoutRequestDTO workoutDTO = WorkoutRequestDTO.builder().name("Chest & Triceps").exercises(exercises1).build();
        workoutService.createWorkout(1L, workoutDTO);

        List<Exercise> exercises2 = new ArrayList<>();
        exercises2.add(Exercise.builder().name("Barbell Rows").sets(3).reps(12).weight(80).type(Exercise.MeasurementType.KG).build());
        exercises2.add(Exercise.builder().name("Cable Pulldowns").sets(3).reps(15).weight(60).type(Exercise.MeasurementType.KG).build());
        exercises2.add(Exercise.builder().name("Pull Ups").sets(3).reps(10).weight(10).type(Exercise.MeasurementType.KG).build());
        exercises2.add(Exercise.builder().name("Deadlift").sets(4).reps(8).weight(125).type(Exercise.MeasurementType.KG).build());
        exercises2.add(Exercise.builder().name("Curls with Barbell").sets(3).reps(18).weight(30).type(Exercise.MeasurementType.KG).build());
        exercises2.add(Exercise.builder().name("Hammer Curls").sets(2).reps(20).weight(15).type(Exercise.MeasurementType.KG).build());
        exercises2.add(Exercise.builder().name("Concentration Curl").sets(2).reps(12).weight(10).type(Exercise.MeasurementType.KG).build());
        WorkoutRequestDTO workoutDTO2 = WorkoutRequestDTO.builder().name("Back & Biceps").exercises(exercises2).build();
        workoutService.createWorkout(1L, workoutDTO2);

        List<Exercise> exercises3 = new ArrayList<>();
        exercises3.add(Exercise.builder().name("Squats").sets(6).reps(6).weight(140).type(Exercise.MeasurementType.KG).build());
        exercises3.add(Exercise.builder().name("Leg Press").sets(2).reps(15).weight(200).type(Exercise.MeasurementType.KG).build());
        exercises3.add(Exercise.builder().name("Leg Extension").sets(3).reps(15).weight(50).type(Exercise.MeasurementType.KG).build());
        exercises3.add(Exercise.builder().name("Lunges").sets(2).reps(15).weight(15).type(Exercise.MeasurementType.KG).build());
        exercises3.add(Exercise.builder().name("Calf Raises").sets(3).reps(20).weight(30).type(Exercise.MeasurementType.KG).build());
        exercises3.add(Exercise.builder().name("Seated Calf Raises").sets(2).reps(20).weight(40).type(Exercise.MeasurementType.KG).build());
        WorkoutRequestDTO workoutDTO3 = WorkoutRequestDTO.builder().name("Legs").exercises(exercises3).build();
        workoutService.createWorkout(1L, workoutDTO3);

        List<Exercise> exercises4 = new ArrayList<>();
        exercises4.add(Exercise.builder().name("Squats").sets(3).reps(6).weight(140).type(Exercise.MeasurementType.KG).build());
        exercises4.add(Exercise.builder().name("Bench Press").sets(3).reps(12).weight(90).type(Exercise.MeasurementType.KG).build());
        exercises4.add(Exercise.builder().name("Barbell Rows").sets(3).reps(12).weight(80).type(Exercise.MeasurementType.KG).build());
        exercises4.add(Exercise.builder().name("Skull Crushers").sets(2).reps(15).weight(35).type(Exercise.MeasurementType.KG).build());
        exercises4.add(Exercise.builder().name("Hammer Curls").sets(2).reps(20).weight(30).type(Exercise.MeasurementType.KG).build());
        WorkoutRequestDTO workoutDTO4 = WorkoutRequestDTO.builder().name("Full Body 1").exercises(exercises4).build();
        workoutService.createWorkout(1L, workoutDTO4);


        List<Exercise> exercises5 = new ArrayList<>();
        exercises5.add(Exercise.builder().name("Pull Ups").sets(3).reps(12).weight(10).type(Exercise.MeasurementType.KG).build());
        exercises5.add(Exercise.builder().name("Bench Press").sets(3).reps(12).weight(90).type(Exercise.MeasurementType.KG).build());
        exercises5.add(Exercise.builder().name("Deadlift").sets(3).reps(12).weight(120).type(Exercise.MeasurementType.KG).build());
        exercises5.add(Exercise.builder().name("Leg Press").sets(2).reps(20).weight(135).type(Exercise.MeasurementType.KG).build());
        exercises5.add(Exercise.builder().name("Cable Pushdowns").sets(2).reps(20).weight(30).type(Exercise.MeasurementType.KG).build());
        WorkoutRequestDTO workoutDTO5 = WorkoutRequestDTO.builder().name("Full Body 1").exercises(exercises5).build();
        workoutService.createWorkout(2L, workoutDTO5);

        List<Exercise> exercises6 = new ArrayList<>();
        exercises6.add(Exercise.builder().name("Squats").sets(3).reps(6).weight(140).type(Exercise.MeasurementType.KG).build());
        exercises6.add(Exercise.builder().name("Bench Press").sets(3).reps(12).weight(90).type(Exercise.MeasurementType.KG).build());
        exercises6.add(Exercise.builder().name("Barbell Rows").sets(3).reps(12).weight(80).type(Exercise.MeasurementType.KG).build());
        exercises6.add(Exercise.builder().name("Skull Crushers").sets(2).reps(15).weight(35).type(Exercise.MeasurementType.KG).build());
        exercises6.add(Exercise.builder().name("Hammer Curls").sets(2).reps(20).weight(30).type(Exercise.MeasurementType.KG).build());
        WorkoutRequestDTO workoutDTO6 = WorkoutRequestDTO.builder().name("Full Body 2").exercises(exercises6).build();
        workoutService.createWorkout(2L, workoutDTO6);

    }

}
