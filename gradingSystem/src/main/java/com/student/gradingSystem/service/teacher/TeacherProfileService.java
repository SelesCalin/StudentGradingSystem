package com.student.gradingSystem.service.teacher;

import com.student.gradingSystem.dto.user.TeacherProfileDTO;
import com.student.gradingSystem.domain.entity.User;
import com.student.gradingSystem.repository.UserRepository;
import com.student.gradingSystem.util.exception.CustomException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.regex.Pattern;


@Service
public class TeacherProfileService {
    private UserRepository userRepository;

    public TeacherProfileService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public TeacherProfileDTO getTeacherProfile(Integer id) throws CustomException {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new CustomException("User not found. Something went wrong");
        } else {
           return new TeacherProfileDTO(user.get());
        }
    }

    @Transactional
    public void updateUsername(Integer id, String newUsername)throws CustomException{
        if(newUsername.length()<4) {
            throw new CustomException("Username must have at least 4 characters");
        }
        if(!newUsername.matches("[a-zA-Z0-9]+")) {
            throw new CustomException("Username must contain only alphanumeric characters");
        }
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new CustomException("User not found.Something went wrong");
        }
        User userWithUsername = userRepository.findByUsername(newUsername);
        if(userWithUsername!= null) {
            throw new CustomException("This username is already taken");
        }
        user.get().setUsername(newUsername);
    }


    @Transactional
    public void updateEmail(Integer id, String newMail) throws CustomException{
        Pattern emailPattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        if(!emailPattern.matcher(newMail).find()) {
            throw new CustomException("Invalid Email");
        }
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new CustomException("User not found.Something went wrong");
        }
        user.get().setEmail(newMail);
    }

    @Transactional
    public void updateName(Integer id,String newName) throws CustomException {
        if (newName.length() < 2) {
            throw new CustomException("Name must contain at least 2 characters");
        }
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new CustomException("User not found.Something went wrong");
        }
        user.get().setNume(newName);
    }


    @Transactional
    public void updateAdress(Integer id,String newAdress) throws  CustomException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new CustomException("User not found.Something went wrong");
        }
        user.get().setAdresa(newAdress);
    }
}
