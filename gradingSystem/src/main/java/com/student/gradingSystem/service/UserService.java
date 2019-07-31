package com.student.gradingSystem.service;


import com.student.gradingSystem.dto.LoginDTO;
import com.student.gradingSystem.entity.User;
import com.student.gradingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){

        this.userRepository=userRepository;

    }


    public String login(LoginDTO loginDTO){
        String username=loginDTO.getUsername();
        String password=loginDTO.getPassword();


        User user = userRepository.findByUsername(username);
        if(user==null) {
            return "Username or password are incorrect!";
        }

        if(!password.equals(user.getPassword())){
            return "Username or password are incorrect!";

        }

        return user.getRole().toString();
    }

}
