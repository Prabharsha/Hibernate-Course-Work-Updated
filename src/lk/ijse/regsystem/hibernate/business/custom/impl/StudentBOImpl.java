package lk.ijse.regsystem.hibernate.business.custom.impl;

import lk.ijse.regsystem.hibernate.business.custom.StudentBO;
import lk.ijse.regsystem.hibernate.dao.DAOFactory;
import lk.ijse.regsystem.hibernate.dao.DAOType;
import lk.ijse.regsystem.hibernate.dao.custom.impl.StudentDAOImpl;
import lk.ijse.regsystem.hibernate.dto.StudentDTO;
import lk.ijse.regsystem.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) {
        return studentDAO.add(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getEmail(),
                studentDTO.getDateOfBirth()
        ));
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(StudentDTO studentDTO) {
        return false;
    }

    @Override
    public List<StudentDTO> getAll() {

        List<Student> allStudent = studentDAO.getAll();
        ArrayList<StudentDTO> dtoList = new ArrayList<>();

        for (Student student : allStudent) {
            dtoList.add(new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getEmail(),
                    student.getDateOfBirth()
            ));
        }
        return dtoList;
    }

    @Override
    public Student find(String id) throws Exception {
        Student student = studentDAO.find(id);
        if (student != null) {
            return student;
        } else {
            return null;
        }
    }
}
