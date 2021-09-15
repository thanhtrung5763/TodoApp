package com.example.todoapp.dao;

import com.example.todoapp.util.HibernateUtil;
import com.example.todoapp.model.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDAO {
    public void saveUser(UsersEntity usersEntity) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(usersEntity);
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    // Get user by email
    public UsersEntity getUser(String email) {
        Transaction transaction = null;
        UsersEntity usersEntity = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            usersEntity = session.get(UsersEntity.class, email);
            transaction.commit();
        } catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return usersEntity;
    }
    public boolean validate(String Email, String password) {
        Transaction transaction = null;
        UsersEntity usersEntity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            usersEntity = (UsersEntity) session.createQuery("FROM UsersEntity U WHERE U.email = :Email")
                    .setParameter("Email", Email)
                    .uniqueResult();
            if (usersEntity != null && usersEntity.getPassword().equals(password)) {
                return true;
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}
