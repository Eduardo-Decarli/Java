package entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_teacher")
public class Teacher extends Pessoa{

    @OneToMany(mappedBy = "teachers")
    private Set<Course> lesionCurses = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Teacher() {
    }

    public Teacher(Long id, String name, LocalDate age, Set<Course> lesionCurses, Department department) {
        super(id, name, age);
        this.lesionCurses = lesionCurses;
        this.department = department;
    }

    public Set<Course> getLesionCurses() {
        return lesionCurses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
