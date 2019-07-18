package art.entity;




import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    public User(String username, String password, String role, String nume, Integer grupa,String email, String adresa) {
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
}

