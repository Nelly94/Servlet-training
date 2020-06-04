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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println("<h1 style=\"color:red\">Hi there</h1>");

        UserDAO userDao = new UserDAO();
        String action = request.getParameter("action");

        if("detail".equals(action)){
            User user = userDao.findUser(request.getParameter("id"));
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/pages/userDetail.jsp").forward(request,response);
        }else if("list".equals(action)){
            List<String> usersList = userDao.getUsers();
            request.setAttribute("usersList", usersList);
            request.getRequestDispatcher("/WEB-INF/pages/userList.jsp").forward(request,response);
        }else{
            //Error
            response.sendRedirect(request.getContextPath() + "/error");
        }





    }
}
