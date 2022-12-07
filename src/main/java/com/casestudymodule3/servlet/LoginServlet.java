package com.casestudymodule3.servlet;

import com.casestudymodule3.dao.CustomerDAO;
import com.casestudymodule3.dao.ProductDAO;
import com.casestudymodule3.model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    CustomerDAO customerDAO = new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        Customer customer = customerDAO.checkLogin(user, pass);

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("username", user);

        if (customer == null) {
            response.sendRedirect("/login");
        } else if (user.equals("admin") && pass.equals("admin")) {
            response.sendRedirect("/products");
        } else if (user.equals(customer.getUsername()) && pass.equals(customer.getPassword())) {
            response.sendRedirect("/customers");
        }
    }
}
