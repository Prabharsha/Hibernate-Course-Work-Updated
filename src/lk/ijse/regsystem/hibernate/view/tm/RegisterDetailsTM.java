package lk.ijse.regsystem.hibernate.view.tm;

public class RegisterDetailsTM {
    private String studentID;
    private String ProgramName;
    private String registeredDate;

    public RegisterDetailsTM() {
    }

    public RegisterDetailsTM(String studentID, String programName, String registeredDate) {
        this.setStudentID(studentID);
        setProgramName(programName);
        this.setRegisteredDate(registeredDate);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getProgramName() {
        return ProgramName;
    }

    public void setProgramName(String programName) {
        ProgramName = programName;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
