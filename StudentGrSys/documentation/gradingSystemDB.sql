CREATE SCHEMA IF NOT EXISTS gradingsysTest; 
use gradingsysTest;

CREATE TABLE user (
  id_user INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  user_role INT,
  nume VARCHAR(45),
  grupa INT,
  email VARCHAR(45) NOT NULL,
  adresa VARCHAR(45),
  PRIMARY KEY (id_user),
  UNIQUE(username),
  UNIQUE(email)
 );
  
  
CREATE TABLE course (
  id_course INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45),
  description VARCHAR(100),
  id_teacher INT,
  enrollkey VARCHAR(10) ,
  PRIMARY KEY (id_course),
  CONSTRAINT `FK_CourseTeacher`  FOREIGN KEY (id_teacher)
  REFERENCES user(id_user)
 );
 
 
CREATE TABLE quiz (
  id_quiz INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45),
  description VARCHAR(100) ,
  id_course INT,
  question_nr INT,
  difficulty INT(4),
  time INT,
  PRIMARY KEY (id_quiz),
  CONSTRAINT `FK_QuizCourse` FOREIGN KEY (id_course)
  REFERENCES course(id_course)
);


CREATE TABLE quiz_question (
  id_quiz_question INT NOT NULL AUTO_INCREMENT,
  id_quiz INT,
  answer_no INT,
  question_text VARCHAR(100),
  PRIMARY KEY (id_quiz_question),
  CONSTRAINT `FK_QuestionQuiz` FOREIGN KEY (id_quiz)
  REFERENCES quiz(id_quiz)
);


CREATE TABLE answer(
  id_answer INT NOT NULL AUTO_INCREMENT,
  id_question INT,
  good INT(4),
  text VARCHAR(450),
  PRIMARY KEY (id_answer),
  CONSTRAINT `FK_AnswerQuestion` FOREIGN KEY (id_question)
  REFERENCES quiz_question(id_quiz_question)
);

CREATE TABLE assignment (
  id_assignment INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45),
  id_course INT,
  deadline DATETIME,
  PRIMARY KEY (id_assignment),
  CONSTRAINT `FK_AssignmentCourse` FOREIGN KEY (id_course)
  REFERENCES course(id_course)
);

CREATE TABLE chat(
  id_chat INT NOT NULL,
  sender_user INT,
  reciver_user INT,
  text VARCHAR(200),
  timestamp TIMESTAMP(6),
  `read` INT,
  PRIMARY KEY (id_chat),
  CONSTRAINT `FK_ChatReciver` FOREIGN KEY (reciver_user) REFERENCES user(id_user),
  CONSTRAINT `FK_ChatSender` FOREIGN KEY (sender_user) REFERENCES user(id_user)
);


CREATE TABLE material(
  id_material INT NOT NULL AUTO_INCREMENT,
  id_course INT,
  name VARCHAR(45),
  content BLOB,
  PRIMARY KEY (id_material),
  CONSTRAINT `FK_MaterialCourse` FOREIGN KEY (id_course)
  REFERENCES course(id_course)
);

CREATE TABLE student_course(
  id_student INT,
  id_course INT,
  PRIMARY KEY (id_student, id_course),
  CONSTRAINT `FK_StudentCourse_student` FOREIGN KEY (id_student) REFERENCES user(id_user),
  CONSTRAINT `FK_StudentCourse_course` FOREIGN KEY (id_course) REFERENCES course(id_course)
  
);

CREATE TABLE student_grade(
  student_id INT NOT NULL,
  assignment_id INT NOT NULL,
  grade DOUBLE,
  observations VARCHAR(100),
  PRIMARY KEY (student_id, assignment_id),
  CONSTRAINT `FK_Assignment_grade` FOREIGN KEY (assignment_id) REFERENCES assignment(id_assignment),
  CONSTRAINT `FK_Student_grade` FOREIGN KEY (student_id) REFERENCES user(id_user)

);

CREATE TABLE quiz_grade(
 id_user INT NOT NULL,
 id_quiz INT NOT NULL,
 grade DOUBLE,
 PRIMARY KEY(id_user,id_quiz),
 CONSTRAINT `FK_StudentQuiz_grade` FOREIGn KEY (id_user) REFERENCES user(id_user),
 CONSTRAINT `FK_Quiz_grade` FOREIGN KEY (id_quiz) REFERENCES quiz(id_quiz)
 );

 
 