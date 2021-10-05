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
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/TodoApp");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "57632919");
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
