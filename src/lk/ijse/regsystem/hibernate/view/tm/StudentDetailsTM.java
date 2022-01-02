package lk.ijse.regsystem.hibernate.view.tm;

public class StudentDetailsTM {
    private String studentID;
    private String studentName;
    private String studentAddress;
    private String studentContact;
    private String studentEmail;
    private String studentDOB;

    public StudentDetailsTM() {
    }

    public StudentDetailsTM(String studentID, String studentName, String studentAddress, String studentContact, String studentEmail, String studentDOB) {
        this.setStudentID(studentID);
        this.setStudentName(studentName);
        this.setStudentAddress(studentAddress);
        this.setStudentContact(studentContact);
        this.setStudentEmail(studentEmail);
        this.setStudentDOB(studentDOB);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }
}
