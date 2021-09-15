package com.example.todoapp.dao;

import com.example.todoapp.util.HibernateUtil;
import com.example.todoapp.model.TasksEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TaskDAO {
    public void saveTask(TasksEntity tasksEntity) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tasksEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteTask(String email, int id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hbm = "DELETE FROM TasksEntity WHERE email=:email AND taskId=:id";
            Query query = session.createQuery(hbm);
            query.setParameter("email", email);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    public List<TasksEntity> getAllTask(String email) {

        Transaction transaction = null;
        List <TasksEntity> listOfTask = null;
        // start a transaction
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            // get an user object

            listOfTask = session.createQuery("from TasksEntity where email=:email")
                    .setParameter("email", email)
                    .getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfTask;
    }
}
