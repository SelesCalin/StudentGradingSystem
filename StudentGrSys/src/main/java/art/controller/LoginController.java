package art.controller;


import art.form.LoginForm;
import art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {


    private UserService userService;

    @Autowired
    public  LoginController(UserService userService){
        this.userService=userService;
    }

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody LoginForm loginForm){


        return  userService.login(loginForm);

    }
}
