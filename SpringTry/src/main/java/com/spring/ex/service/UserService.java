package com.spring.ex.service;

import com.spring.ex.entity.User;
import com.spring.ex.form.LoginForm;
import com.spring.ex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserRepository userRepository;
    @Autowired
    public UserService (UserRepository userRepository){

        this.userRepository=userRepository;

    }


    public String login(LoginForm loginForm){
        String username=loginForm.getUsername();
        String password=loginForm.getPassword();


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
