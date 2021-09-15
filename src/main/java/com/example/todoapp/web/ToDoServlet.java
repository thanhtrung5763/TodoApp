package com.example.todoapp.web;

import com.example.todoapp.dao.TaskDAO;
import com.example.todoapp.model.TasksEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="ToDoApp", urlPatterns = {"/ToDoApp", "/ToDoApp/Add", "/ToDoApp/Delete"})
public class ToDoServlet extends HttpServlet {
    private TaskDAO taskDAO;

    public void init() {
        taskDAO = new TaskDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String email= (String)req.getSession().getAttribute("email");
        req.getSession().setAttribute("email", email);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/ToDoApp.jsp");
        dispatcher.forward(req, resp);*/
        String email= (String)req.getSession().getAttribute("email");
        req.getSession().setAttribute("email", email);
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/ToDoApp/Add":
                    insertTask(req, resp);
                    break;
                case "/ToDoApp/Delete":
                    deleteTask(req, resp);
                    break;
                default:
                    showTask(req, resp);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    private void showTask(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String email= (String)req.getSession().getAttribute("email");
        System.out.println(email);
        List<TasksEntity> listTask = taskDAO.getAllTask(email);
        for(TasksEntity task : listTask) {
            System.out.println(task.getTaskName());
            System.out.println(task.getPriority());
        }
        req.setAttribute("listTask", listTask);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/ToDoApp.jsp");
        dispatcher.forward(req, resp);
    }
    public void insertTask(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String email = req.getParameter("email");
        try {
            if(email == null) {
                resp.sendRedirect("/login.jsp");
            }
            else {
                int priority =  Integer.parseInt(req.getParameter("priority"));
                String task_name = req.getParameter("task_name");
                TasksEntity tasksEntity = new TasksEntity(email, task_name, priority);
                taskDAO.saveTask(tasksEntity);
                resp.sendRedirect("/ToDoApp");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    private void deleteTask(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {
        String email = req.getParameter("email");
        if(email == null) {
            resp.sendRedirect("/login.jsp");
        }
        else {
            int taskId = Integer.parseInt(req.getParameter("taskId"));
            taskDAO.deleteTask(email, taskId);
            resp.sendRedirect("/ToDoApp");
        }
    }
}
