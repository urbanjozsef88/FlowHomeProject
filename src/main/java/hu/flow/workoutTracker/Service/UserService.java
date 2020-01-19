package hu.flow.workoutTracker.Service;

import hu.flow.workoutTracker.Entity.User;
import hu.flow.workoutTracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUser(String email, String password){
        if(userRepository.findByEmail(email) != null){
        User u = userRepository.findByEmail(email);
        if(BCrypt.checkpw(password, u.getPassword())){
            return u;
        } else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void createUser(User user){
       String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
       if(user.getEmail().matches(regex) && user.getPassword() != null && !"".equals(user.getPassword()) ){
            String psw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(psw);
            userRepository.save(user);}
       else{
           throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    public void updateUser(User user){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(user.getEmail().matches(regex) && user.getPassword() != null && !"".equals(user.getPassword()) ){
            String psw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(psw);
            userRepository.save(user);}
        else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

}
