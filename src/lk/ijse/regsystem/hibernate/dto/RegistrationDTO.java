package lk.ijse.regsystem.hibernate.dto;
import lk.ijse.regsystem.hibernate.entity.Program;
import lk.ijse.regsystem.hibernate.entity.Student;

import java.util.List;

public class RegistrationDTO {
    private String regNo;
    private String RegisteredDate;
    private Student student;
    private List<Program> programs;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String regNo, String registeredDate, Student student, List<Program> programs) {
        this.setRegNo(regNo);
        setRegisteredDate(registeredDate);
        this.setStudent(student);
        this.setPrograms(programs);
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
