package lk.ijse.regsystem.hibernate.view.tm;

public class ProgramDetailsTM {
    private String programID;
    private String programName;
    private String programDuration;
    private String programFee;

    public ProgramDetailsTM() {
    }

    public ProgramDetailsTM(String programID, String programName, String programDuration, String programFee) {
        this.setProgramID(programID);
        this.setProgramName(programName);
        this.setProgramDuration(programDuration);
        this.setProgramFee(programFee);
    }


    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(String programDuration) {
        this.programDuration = programDuration;
    }

    public String getProgramFee() {
        return programFee;
    }

    public void setProgramFee(String programFee) {
        this.programFee = programFee;
    }
}
