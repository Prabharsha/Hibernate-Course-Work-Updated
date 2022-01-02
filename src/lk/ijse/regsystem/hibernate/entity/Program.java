package lk.ijse.regsystem.hibernate.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Program implements SuperEntity {
    @Id
    private String Id;
    private String ProgramName;
    private String Duration;
    private Double Fee;
    @ManyToMany(mappedBy = "program")
    private List<Registration> registrationList;

    public Program() {
    }

    public Program(String id, String programName, String duration, Double fee) {
        Id = id;
        ProgramName = programName;
        Duration = duration;
        Fee = fee;
    }

    public Program(String id, String programName, String duration, Double fee, List<Registration> registrationList) {
        Id = id;
        ProgramName = programName;
        Duration = duration;
        Fee = fee;
        this.registrationList = registrationList;
    }

    @Override
    public String toString() {
        return "Program{" +
                "Id='" + getId() + '\'' +
                ", ProgramName='" + getProgramName() + '\'' +
                ", Duration='" + getDuration() + '\'' +
                ", Fee=" + getFee() +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProgramName() {
        return ProgramName;
    }

    public void setProgramName(String programName) {
        ProgramName = programName;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public Double getFee() {
        return Fee;
    }

    public void setFee(Double fee) {
        Fee = fee;
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }
}
