package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_student")
public class Student extends Pessoa{

    private Long ra;

    @ManyToMany
    @JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "couser_id"))
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
