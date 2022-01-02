package lk.ijse.regsystem.hibernate.business.custom;

import lk.ijse.regsystem.hibernate.business.SuperBO;
import lk.ijse.regsystem.hibernate.dto.StudentDTO;
import lk.ijse.regsystem.hibernate.entity.Student;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean add(Student student) throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(Student student) throws Exception;

    public List<Student> getAll() throws Exception;

    public Student find(String id) throws Exception;

    public int getCount() throws Exception;
}
