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
    public boolean add(Student student) {
        return studentDAO.add(new Student(
                student.getsId(),
                student.getName(),
                student.getAddress(),
                student.getContact(),
                student.getEmail(),
                student.getDateOfBirth()
        ));
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public List<Student> getAll() {

        List<Student> allStudent = studentDAO.getAll();
        ArrayList<Student> List = new ArrayList<>();

        for (Student student : allStudent) {
            List.add(new Student(
                    student.getsId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getEmail(),
                    student.getDateOfBirth()
            ));
        }
        System.out.println(List.get(0).getsId());
        System.out.println(List.get(1).getsId());
        return List;
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

    @Override
    public String getCount() throws Exception {
        String count = studentDAO.getCount();
        return count;
    }
}
