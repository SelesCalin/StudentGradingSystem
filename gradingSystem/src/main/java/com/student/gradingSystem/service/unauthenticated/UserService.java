package com.student.gradingSystem.service.unauthenticated;


import com.student.gradingSystem.dto.LoginDTO;
import com.student.gradingSystem.dto.RegisterInfoDTO;
import com.student.gradingSystem.domain.entity.User;
import com.student.gradingSystem.domain.entity.enumeration.RoleType;
import com.student.gradingSystem.dto.TokenDTO;
import com.student.gradingSystem.util.exception.UserRegistrationException;
import com.student.gradingSystem.repository.UserRepository;
import com.student.gradingSystem.util.SessionUtil;
import com.student.gradingSystem.util.validation.RegisterValidator;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;
    private RegisterValidator validator;

    @Autowired
    public UserService(UserRepository userRepository,RegisterValidator validator){
        this.userRepository=userRepository;
        this.validator=validator;
    }

    public TokenDTO login(LoginDTO loginDTO){
        String username=loginDTO.getUsername();
        String password=loginDTO.getPassword();
        User user = userRepository.findByUsername(username);
        if(user==null) {
           return null;
        }
        if(!password.equals(user.getPassword())){
            return null;
        }
        String token= HexUtils.toHexString(UUID.randomUUID().toString().getBytes());
        SessionUtil.createSession(token,user.getIduser(),user.getRole());
        TokenDTO tokenDTO= new TokenDTO(token,user.getRole().ordinal());

        return  tokenDTO;
    }

    public Integer register(RegisterInfoDTO registerInfoDTO) throws UserRegistrationException{
        User userWithUsername= userRepository.findByUsername(registerInfoDTO.getUsername());
        if(userWithUsername!=null) {
            return -1;
        }
        User userWithEmail = userRepository.findByEmail(registerInfoDTO.getEmail());
        if(userWithEmail!= null) {
            return -2;
        }
        validator.validate(registerInfoDTO);
        User user = new User();
        user.setAdresa(registerInfoDTO.getAdresa());
        user.setEmail(registerInfoDTO.getEmail());
        user.setGrupa(registerInfoDTO.getGrupa());
        user.setUsername(registerInfoDTO.getUsername());
        user.setPassword(registerInfoDTO.getPassword());
        user.setNume(registerInfoDTO.getName());
        user.setRole(RoleType.values()[registerInfoDTO.getRole()]);
        userRepository.save(user);
        return 1;
    }
}
