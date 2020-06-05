package com.myapp.servlet;

import dao.LoginDAO;
import model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private LoginDAO loginDAO = new LoginDAO();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get email and password
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //Check if they exist
        Login login = loginDAO.findLogin(email);
        if(login != null ){
            if(login.getPassword().equals(password)) {
                //Create session
                HttpSession session = request.getSession();
                session.setAttribute("login", login);
                response.sendRedirect(request.getContextPath() + "/user?action=list");
            }
        }else if("add".equals(request.getParameter("action"))){
                //Add login
                Login newLogin = new Login(email, password);
                loginDAO.addLogin(newLogin);
                request.removeAttribute("create");
                request.getRequestDispatcher("/WEB-INF/pages/header.jsp").forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath() + "/error");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            request.setAttribute("create", true);
            request.getRequestDispatcher("/WEB-INF/pages/login-add.jsp").forward(request,response);

        }else if("login".equals(action)){
            request.getRequestDispatcher("/WEB-INF/pages/header.jsp").forward(request, response);

        }else if("remove".equals(action)){
            loginDAO.removeLogin((Login) request.getSession().getAttribute("login"));
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login?action=login");

        }else if("list".equals(action)){
            List<Login> loginList = loginDAO.getLogins();
            request.setAttribute("loginList", loginList);
            request.getRequestDispatcher("/WEB-INF/pages/login-list.jsp").forward(request, response);

        }else if("logout".equals(action)){
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login?action=login");

        }else{
            //Error
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }
}
