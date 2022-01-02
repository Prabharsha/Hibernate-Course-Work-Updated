package lk.ijse.regsystem.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Registration implements SuperEntity {
    @Id
    private String regNo;
    private String RegisteredDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Program> programs;


    public Registration() {
    }

    public Registration(String regNo, String registeredDate, Student student) {
        this.regNo = regNo;
        RegisteredDate = registeredDate;
        this.student = student;
    }

    public Registration(String regNo, String registeredDate, Student student, List<Program> programs) {
        this.regNo = regNo;
        RegisteredDate = registeredDate;
        this.student = student;
        this.programs = programs;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getRegisteredDate() {
        return RegisteredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        RegisteredDate = registeredDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }
}
