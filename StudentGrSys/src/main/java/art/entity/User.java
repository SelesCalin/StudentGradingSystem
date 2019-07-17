package art.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="iduser")
    private Integer iduser;

    @Column(name="username")
    private String username;


    @Column(name="password")
    private String password;

    @Column(name="user_role")
    private String role;


    @Column(name="name")
    private String nume;

    @Column(name="grupa")
    private Integer grupa;


    public User(String username, String password, String role, String nume, Integer grupa) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.nume = nume;
        this.grupa = grupa;
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


}

