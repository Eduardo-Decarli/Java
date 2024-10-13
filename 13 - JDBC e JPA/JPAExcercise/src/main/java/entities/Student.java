package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_student")
public class Student extends Pessoa{

    private Long ra;

    @OneToMany(mappedBy = "students")
    Set<Course> courses = new HashSet<>();

    public Student(){
        super();
    }

    public Student(Long id, String name, LocalDate age, Long ra, Set<Course> courses) {
        super(id, name, age);
        this.ra = ra;
        this.courses = courses;
    }

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}
