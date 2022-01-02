package lk.ijse.regsystem.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student implements SuperEntity {
    @Id
    private String Id;
    private String Name;
    private String Address;
    private String Contact;
    private String Email;
    private String DateOfBirth;

    @OneToMany(mappedBy="student")
    private List<Registration> registrationList;
    public Student() {
    }

    public Student(String id, String name, String address, String contact, String email, String dateOfBirth) {
        setId(id);
        setName(name);
        setAddress(address);
        setContact(contact);
        setEmail(email);
        setDateOfBirth(dateOfBirth);
    }

    public Student(String id, String name, String address, String contact, String email, String dateOfBirth, List<Registration> registrationList) {
        setId(id);
        setName(name);
        setAddress(address);
        setContact(contact);
        setEmail(email);
        setDateOfBirth(dateOfBirth);
        this.setRegistrationList(registrationList);
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
