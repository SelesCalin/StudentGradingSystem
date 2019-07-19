package art.entity;




import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_user")
    private Integer iduser;

    @Column(name="username")
    private String username;


    @Column(name="password")
    private String password;

    @Column(name="user_role")
    private String role;


    @Column(name="nume")
    private String nume;

    @Column(name="grupa")
    private Integer grupa;


    @Column(name="email")
    private String email;

    @Column(name="adresa")
    private String adresa;

    @OneToMany(mappedBy = "sender",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Chat> senders=new HashSet<Chat>();

    @OneToMany(mappedBy = "reciver",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Chat> recivers=new HashSet<Chat>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_course")
    )
    private Set<Course> courses = new HashSet<Course>();


    public User(String username, String password, String role, String nume, Integer grupa,String email, String adresa,Set<Chat> senders,Set<Chat> recivers) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.nume = nume;
        this.grupa = grupa;
        this.email=email ;
        this.adresa=adresa;
        this.senders=senders;
        this.recivers=recivers;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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

    public Set<Chat> getSenders() {
        return senders;
    }

    public void setSenders(Set<Chat> senders) {
        this.senders = senders;
    }

    public Set<Chat> getRecivers() {
        return recivers;
    }

    public void setRecivers(Set<Chat> recivers) {
        this.recivers = recivers;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addSender(Chat chat){
        senders.add(chat);
        chat.setSender(this);
    }


    public void removeSenders(Chat chat)
    {
       senders.remove(chat);
        chat.setSender(null);
    }

    public void addReciver(Chat chat){
        recivers.add(chat);
        chat.setReciver(this);
    }

    public void removeReciver(Chat chat){
        recivers.remove(chat);
        chat.setReciver(null);
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.getStudents().remove(this);
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

