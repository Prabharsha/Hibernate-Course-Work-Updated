package lk.ijse.regsystem.hibernate.dao.custom.impl;

import lk.ijse.regsystem.hibernate.dao.custom.ProgramDAO;
import lk.ijse.regsystem.hibernate.entity.Program;
import lk.ijse.regsystem.hibernate.util.FactoryConfiguration;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {


    @Override
    public boolean add(Program entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Program entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Program find(String name) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Program WHERE ProgramName=:name");
        query.setParameter("name", name);
        List<Program> list = query.list();
        for (Program program : list) {
            transaction.commit();
            session.close();
            return program;
        }
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public List<Program> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Program ");
        List list = query.list();
        transaction.commit();
        System.out.println("2");
        session.close();
        return list;
    }

    @Override
    public int getCount() throws Exception {
        return 0;
    }


}
