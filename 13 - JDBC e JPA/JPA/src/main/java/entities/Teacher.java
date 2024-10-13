package entities;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tb_teacher")
public class Teacher extends Pessoa{

    @ManyToMany
    @JoinTable(name = "professor_curso",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Set<Course> lesionCurses;

    @ManyToOne
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
