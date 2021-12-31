package lk.ijse.regsystem.hibernate.entity;


import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Program implements SuperEntity {
    @Id
    private String Id;
    private String ProgramName;
    private String Duration;
    private Double Fee;

    public Program() {
    }

    public Program(String id, String programName, String duration, Double fee) {
        setId(id);
        setProgramName(programName);
        setDuration(duration);
        setFee(fee);
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
}
