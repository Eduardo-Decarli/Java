package entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Department department;

    @OneToMany(mappedBy = "courses")
    List<Student> students = new ArrayList();

    @OneToMany(mappedBy = "lesionCurses")
    List<Teacher> teachers = new ArrayList<>();

    public Course() {
    }

    public Course(Department department, List<Student> students, List<Teacher> teachers) {
        this.department = department;
        this.students = students;
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
