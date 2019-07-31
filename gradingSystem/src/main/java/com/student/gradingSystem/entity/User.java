package com.student.gradingSystem.entity;



import com.student.gradingSystem.entity.course.Course;
import com.student.gradingSystem.entity.course.quiz.Quiz;
import com.student.gradingSystem.entity.course.quiz.QuizGrade;
import com.student.gradingSystem.entity.enumeration.RoleType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


 @Entity(name="user")
 @Table(name="user")
public class User implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     @Column(name="id_user")
     private Integer iduser;

     @Column(name="username",unique = true)

     private String username;


     @Column(name="password")
     private String password;

     @Enumerated(EnumType.ORDINAL)
     @Column(name="user_role")
     private RoleType role;



     @Column(name="nume")
     private String nume;

     @Column(name="grupa")
     private Integer grupa;


     @Column(name="email")
     private String email;

     @Column(name="adresa")
     private String adresa;


     @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
     @JoinTable(name = "student_course",
             joinColumns = @JoinColumn(name = "id_student"),
             inverseJoinColumns = @JoinColumn(name = "id_course")
     )
     private Set<Course> courses = new HashSet<Course>();

     @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL,orphanRemoval = true)
     private Set<Course> teachedCourses =new HashSet<Course>();




     @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
     private List<QuizGrade> quizGrades = new ArrayList<>();


     public User(String username, String password, RoleType role, String nume, Integer grupa,String email, String adresa) {
         this.username = username;
         this.password = password;
         this.role = role;
         this.nume = nume;
         this.grupa = grupa;
         this.email=email ;
         this.adresa=adresa;

     }

     public User() {
     }

     public Integer getIduser() {
         return iduser;
     }

     public void setIduser(Integer iduser) {
         this.iduser = iduser;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public RoleType getRole() {
         return role;
     }

     public void setRole(RoleType role) {
         this.role = role;
     }

     public String getNume() {
         return nume;
     }

     public void setNume(String nume) {
         this.nume = nume;
     }

     public Integer getGrupa() {
         return grupa;
     }

     public void setGrupa(Integer grupa) {
         this.grupa = grupa;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getAdresa() {
         return adresa;
     }

     public void setAdresa(String adresa) {
         this.adresa = adresa;
     }


     public Set<Course> getCourses() {
         return courses;
     }

     public void setCourses(Set<Course> courses) {
         this.courses = courses;
     }


     public Set<Course> getTeachedCourses() {
         return teachedCourses;
     }

     public void setTeachedCourses(Set<Course> teachedCourses) {
         this.teachedCourses = teachedCourses;
     }


     public void addTeachedCourse(Course course){
         teachedCourses.add(course);
         course.setTeacher(this);
     }

     public void removeTeachedCourse(Course course){
         teachedCourses.remove(course);
         course.setTeacher(null);
     }



     public void addCourse(Course course) {
         courses.add(course);
         course.getStudents().add(this);
     }

     public void removeCourse(Course course) {
         courses.remove(course);
         course.getStudents().remove(this);
     }



     public List<QuizGrade> getQuizGrades() {
         return quizGrades;
     }

     public void setQuizGrades(List<QuizGrade> quizGrades) {
         this.quizGrades = quizGrades;
     }


     public void addQuizGrade(Quiz quiz, Double grade){
         QuizGrade quizGrade = new QuizGrade(this,quiz,grade);
         quizGrades.add(quizGrade);
         quiz.getQuizGrades().add(quizGrade);
     }

     public void removeQuizGrade(Quiz quiz){

         for(Iterator<QuizGrade> iterator = quizGrades.iterator();iterator.hasNext();){
             QuizGrade quizGrade= iterator.next();
             if(quizGrade.getUser().equals(this) && quizGrade.getQuiz().equals(quiz)) {
                 quizGrade.getQuiz().getQuizGrades().remove(quizGrade);
                 quizGrade.setUser(null);
                 quizGrade.setQuiz(null);
             }

         }
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof User)) return false;
         return iduser != null && iduser.equals(((User) o).getIduser());
     }

     @Override
     public int hashCode() {
         return Objects.hashCode(iduser);
     }
    }


