package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Model.DTO.UserRequestDTO;
import hu.flow.workoutTracker.Model.DTO.UserResponseDTO;
import hu.flow.workoutTracker.Model.User;
import hu.flow.workoutTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public UserResponseDTO getUser(@RequestBody UserRequestDTO userREquestDTO){
        return userService.getUser(userREquestDTO);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}
