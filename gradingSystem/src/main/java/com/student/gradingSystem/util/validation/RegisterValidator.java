package com.student.gradingSystem.util.validation;


import com.student.gradingSystem.dto.RegisterInfoDTO;
import com.student.gradingSystem.util.exception.UserRegistrationException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class RegisterValidator   {



    public void validate(RegisterInfoDTO registerInfoDTO) throws UserRegistrationException {
        if(registerInfoDTO.getUsername().equals("") || registerInfoDTO.getUsername().length()<4) {
            throw new UserRegistrationException("Username must have at least 4 characters");
        }
        Pattern pattern =Pattern.compile("^[a-zA-Z0-9]+$");

        if(!pattern.matcher(registerInfoDTO.getUsername()).matches()){
            throw new UserRegistrationException("Username can only contain characters and numbers");
            }

        if(registerInfoDTO.getPassword().equals("") || registerInfoDTO.getPassword().length()<6) {
            throw new UserRegistrationException("Password must be at least 6 characters long");

        }

        if(!registerInfoDTO.getPassword().equals(registerInfoDTO.getConfirmPassword())){
            throw  new UserRegistrationException("Confirm Password does not match");}

        Pattern emailPattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

        if(!emailPattern.matcher(registerInfoDTO.getEmail()).matches()) {
            throw new UserRegistrationException("Invalid Email");
        }





    }
}
