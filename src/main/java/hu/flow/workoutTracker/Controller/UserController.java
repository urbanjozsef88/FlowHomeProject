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
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }

}
