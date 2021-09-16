package com.example.todoapp.util;
import java.util.Properties;

import com.example.todoapp.model.TasksEntity;
import com.example.todoapp.model.TasksEntityPK;
import com.example.todoapp.model.UsersEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        System.out.println(sessionFactory);
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://ec2-3-219-111-26.compute-1.amazonaws.com:5432/dfqcj18ekuov9u");
                settings.put(Environment.USER, "ftqpwqulptsary");
                settings.put(Environment.PASS, "cf66381b26848a6607b89d1005aff7e0558c75a86818ec76f1e3ea8d7fa9d090");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(TasksEntity.class);
                configuration.addAnnotatedClass(UsersEntity.class);
                configuration.addAnnotatedClass(TasksEntityPK.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                System.out.println("Hibernate Java Config serviceRegistry created");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    /*static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();

    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/
}
