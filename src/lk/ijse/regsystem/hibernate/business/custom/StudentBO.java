package lk.ijse.regsystem.hibernate.business.custom;

import lk.ijse.regsystem.hibernate.business.SuperBO;
import lk.ijse.regsystem.hibernate.dto.StudentDTO;
import lk.ijse.regsystem.hibernate.entity.Student;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean add(StudentDTO studentDTO) throws Exception;

    public boolean delete(String id) throws Exception;

    public boolean update(StudentDTO studentDTO) throws Exception;

    public List<StudentDTO> getAll() throws Exception;

    public Student find(String id) throws Exception;
}
