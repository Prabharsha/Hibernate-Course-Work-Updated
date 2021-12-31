package lk.ijse.regsystem.hibernate.dto;

public class ProgramDTO {
    private String Id;
    private String ProgramName;
    private String Duration;
    private Double Fee;

    public ProgramDTO() {
    }

    public ProgramDTO(String id, String programName, String duration, Double fee) {
        Id = id;
        ProgramName = programName;
        Duration = duration;
        Fee = fee;
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
