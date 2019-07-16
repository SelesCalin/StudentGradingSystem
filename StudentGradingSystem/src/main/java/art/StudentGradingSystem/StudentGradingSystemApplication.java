package art.StudentGradingSystem;

import art.StudentGradingSystem.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudentGradingSystemApplication {

	public static void main(String[] args) {
	  ApplicationContext applicationContext = SpringApplication.run(StudentGradingSystemApplication.class,args);
	  UserRepository repository = applicationContext.getBean(UserRepository.class);
	  System.out.println(repository.findById(1).get().getGrupa());

	}

}
