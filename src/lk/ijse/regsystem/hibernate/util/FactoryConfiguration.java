package lk.ijse.regsystem.hibernate.util;


import lk.ijse.regsystem.hibernate.entity.Registration;
import lk.ijse.regsystem.hibernate.entity.Student;
import lk.ijse.regsystem.hibernate.entity.Program;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;


public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Configuration configure = new Configuration().mergeProperties(properties).addAnnotatedClass(Program.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Registration.class);
        sessionFactory = configure.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}

