package lk.ijse.regsystem.hibernate.dao.custom.impl;

import lk.ijse.regsystem.hibernate.dao.custom.StudentDAO;
import lk.ijse.regsystem.hibernate.entity.Student;
import lk.ijse.regsystem.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean add(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student tempStudent = session.get(Student.class, s);
        session.delete(tempStudent);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student find(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> studentList = null;
        Query students = session.createQuery("from Student");
        studentList = students.list();
        transaction.commit();
        session.close();
        return studentList;
    }
}
