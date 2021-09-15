package com.example.todoapp.web;

import com.example.todoapp.dao.UserDAO;
import com.example.todoapp.model.UsersEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="login", urlPatterns = {"", "/register"})
public class UserServlet extends HttpServlet {

    private UserDAO userDAO;
    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/register":
                    register(req, resp);
                    break;
                case "":
                    authenticate(req, resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("error");
        }

    }
    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(userDAO.validate(email, password)) {
            request.getSession().setAttribute("email", email);
            response.sendRedirect("/ToDoApp");
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
    }
    private void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int error;
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(userDAO.getUser(email) != null) {
            error = 0;
        }
        else {
            error = 1;
            UsersEntity usersEntity = new UsersEntity(email, username, password);
            userDAO.saveUser(usersEntity);
        }
        request.getSession().setAttribute("error", error);
        response.sendRedirect("/");
    }
}
