package com.myapp.servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {

    public  UserDAO userDao = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User newUser = new User(request.getParameter("firstname"), request.getParameter("lastname"), Integer.parseInt(request.getParameter("salary")));
        userDao.addUser(newUser);
        response.sendRedirect(request.getContextPath() + "/user?action=list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println("<h1 style=\"color:red\">Hi there</h1>");

        //UserDAO userDao = new UserDAO();
        String action = request.getParameter("action");

        if("detail".equals(action)){
            User user = userDao.findUser(request.getParameter("id"));
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/pages/user-detail.jsp").forward(request,response);
        }else if("list".equals(action)) {
            List<User> usersList = userDao.getUsers();
            request.setAttribute("usersList", usersList);
            request.getRequestDispatcher("/WEB-INF/pages/user-list.jsp").forward(request, response);
        }else if("add".equals(action)){
            request.getRequestDispatcher("/WEB-INF/pages/user-add.jsp").forward(request,response);
        }else{
            //Error
            response.sendRedirect(request.getContextPath() + "/error");
        }





    }
}
