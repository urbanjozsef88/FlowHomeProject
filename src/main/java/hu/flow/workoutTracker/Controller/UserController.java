package hu.flow.workoutTracker.Controller;

import hu.flow.workoutTracker.Model.DTO.UserRequestDTO;
import hu.flow.workoutTracker.Model.DTO.UserResponseDTO;
import hu.flow.workoutTracker.Model.User;
import hu.flow.workoutTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserResponseDTO getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/{username}")
    public UserResponseDTO getUserByUserName(@PathVariable String username){
        return userService.getUserByUserName(username);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }

}
