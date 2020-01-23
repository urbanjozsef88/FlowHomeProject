package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Model.DTO.UserRequestDTO;
import hu.flow.workoutTracker.Model.DTO.UserResponseDTO;
import hu.flow.workoutTracker.Model.User;
import hu.flow.workoutTracker.Repository.UserRepository;
import hu.flow.workoutTracker.Repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutRepository workoutRepository;


    public UserResponseDTO getUser(UserRequestDTO userRequestDTO){
        if(userRepository.findByEmail(userRequestDTO.getEmail()) != null){
        User u = userRepository.findByEmail(userRequestDTO.getEmail());
        if(BCrypt.checkpw(userRequestDTO.getPassword(), u.getPassword())){
            UserResponseDTO uDTO = new UserResponseDTO();
            uDTO.setEmail(u.getEmail());
            uDTO.setFirstName(u.getFirstName());
            uDTO.setLastName(u.getLastName());
            uDTO.setId(u.getId());
            return uDTO;
        } else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> createUser(User user){
       String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
       if(userRepository.findByEmail(user.getEmail()) != null)
       { return ResponseEntity.badRequest().build();}
       if(user.getEmail().matches(regex) && user.getPassword() != null && !"".equals(user.getPassword()) ){
            String psw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(psw);
            userRepository.save(user);
           return new ResponseEntity(HttpStatus.CREATED);}
       else{
           throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    public ResponseEntity<Void> updateUser(User user){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(userRepository.findByEmail(user.getEmail()) != null)
        { return ResponseEntity.badRequest().build();}
        if(user.getEmail().matches(regex) && user.getPassword() != null && !"".equals(user.getPassword()) ){
            String psw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(psw);
            userRepository.save(user);}
        else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteUser(int id){

        workoutRepository.getAllWorkoutByUser(id)
                .forEach(wo -> workoutRepository.deleteById(wo.getId()));
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
