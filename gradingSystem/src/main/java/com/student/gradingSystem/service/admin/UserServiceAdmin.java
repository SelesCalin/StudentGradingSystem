package com.student.gradingSystem.service.admin;

import com.student.gradingSystem.domain.entity.enumeration.RoleType;
import com.student.gradingSystem.dto.user.UpdateUserDTO;
import com.student.gradingSystem.dto.user.UserDTO;
import com.student.gradingSystem.domain.entity.User;
import com.student.gradingSystem.repository.UserRepository;
import com.student.gradingSystem.util.exception.CustomException;
import com.student.gradingSystem.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceAdmin {
    private UserRepository userRepository;

    @Autowired
    public UserServiceAdmin(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers()
    {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        users.forEach(user -> userDTOList.add(new UserDTO(user)));
        return userDTOList;
    }
    public int delete(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return -1;
        } else
            userRepository.delete(user);
        return 1;
    }

    public UserDTO getUser(Integer id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        UserDTO userDTO;
        if (user.isPresent()) {
            User user1 = user.get();
            userDTO = new UserDTO(user1);
        } else {
            throw new UserNotFoundException("User not found");
        }
        return userDTO;
    }


    public UpdateUserDTO getUserUpdate(Integer id) throws UserNotFoundException{
        Optional<User> user = userRepository.findById(id);
        UpdateUserDTO userDTO;
        if (user.isPresent()) {
            User user1 = user.get();
            userDTO = new UpdateUserDTO(user1);
        } else {
            throw new UserNotFoundException("User not found");
        }
        return userDTO;
    }

    @Transactional
    public void updateUser(Integer id, UpdateUserDTO updateUserDTO) throws UserNotFoundException, CustomException {
        Optional<User> userOptional=userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found");
        }
        User user= userOptional.get();
        if(updateUserDTO.getUsername()==null || updateUserDTO.getUsername().length()<4) {
            throw new CustomException("username invalid");
        }
        User userNewUsername= userRepository.findByUsername(updateUserDTO.getUsername());
        if(userNewUsername!=null && userNewUsername.getIduser()!=id) {
            throw new CustomException("Username already exists");
        }

        user.setUsername(updateUserDTO.getUsername());

        User userWithEmail = userRepository.findByEmail(updateUserDTO.getEmail());
        if(userWithEmail!= null && userWithEmail.getIduser()!=id) {
            throw new CustomException("Email already exists");
        }
        Pattern emailPattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

        if(!emailPattern.matcher(updateUserDTO.getEmail()).matches()) {
            throw new CustomException("Invalid Email");
        }

        user.setEmail(updateUserDTO.getEmail());
        //fara verificari in rest
        user.setGrupa(updateUserDTO.getGrupa());
        user.setAdresa(updateUserDTO.getAdresa());
        user.setNume(updateUserDTO.getNume());
        user.setRole(RoleType.values()[updateUserDTO.getRole()]);
    }
}
