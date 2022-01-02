package lk.ijse.regsystem.hibernate.dao.custom.impl;

import lk.ijse.regsystem.hibernate.dao.SuperDAO;
import lk.ijse.regsystem.hibernate.dao.custom.RegistrationDAO;
import lk.ijse.regsystem.hibernate.entity.Registration;
import lk.ijse.regsystem.hibernate.entity.SuperEntity;
import lk.ijse.regsystem.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean add(Registration registration) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(registration);
        transaction.commit();
        session.close();
        return true;
    }
}
