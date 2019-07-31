package com.student.gradingSystem.entity.course.material;



import com.student.gradingSystem.entity.course.Course;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name="material")
public class Material {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_material")
    private Integer idMaterial;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_course")
    private Course course;

    @Column(name="name")
    private String name;

    @Column(name="content")
    private Blob content;


    public Material(Course course, String name, Blob content) {
        this.course = course;
        this.name = name;
        this.content = content;
    }

    public Material() {
    }


    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material )) return false;
        return idMaterial != null && idMaterial.equals(((Material) o).getIdMaterial());
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(idMaterial);
    }
}
