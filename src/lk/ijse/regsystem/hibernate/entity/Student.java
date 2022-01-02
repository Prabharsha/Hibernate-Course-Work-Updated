package lk.ijse.regsystem.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student implements SuperEntity {
    @Id
    private String sId;
    private String Name;
    private String Address;
    private String Contact;
    private String Email;
    private String DateOfBirth;

    @OneToMany(mappedBy="student")
    private List<Registration> registrationList;
    public Student() {
    }

    public Student(String sId, String name, String address, String contact, String email, String dateOfBirth) {
        this.sId = sId;
        Name = name;
        Address = address;
        Contact = contact;
        Email = email;
        DateOfBirth = dateOfBirth;
    }

    public Student(String sId, String name, String address, String contact, String email, String dateOfBirth, List<Registration> registrationList) {
        this.sId = sId;
        Name = name;
        Address = address;
        Contact = contact;
        Email = email;
        DateOfBirth = dateOfBirth;
        this.registrationList = registrationList;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }
}
