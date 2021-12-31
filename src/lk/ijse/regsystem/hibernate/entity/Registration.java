package lk.ijse.regsystem.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Registration implements SuperEntity{
    @Id
    private String StudentID;
    private String ProgramID;
    private String RegisteredDate;

    public Registration() {
    }

    public Registration(String studentID, String programID, String registeredDate) {
        StudentID = studentID;
        ProgramID = programID;
        RegisteredDate = registeredDate;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getProgramID() {
        return ProgramID;
    }

    public void setProgramID(String programID) {
        ProgramID = programID;
    }

    public String getRegisteredDate() {
        return RegisteredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        RegisteredDate = registeredDate;
    }
}
