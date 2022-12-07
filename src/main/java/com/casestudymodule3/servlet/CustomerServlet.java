package com.casestudymodule3.servlet;

import com.casestudymodule3.dao.CustomerDAO;
import com.casestudymodule3.dao.ProductDAO;
import com.casestudymodule3.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    CustomerDAO customerDAO = new CustomerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                showViewProductCus(request, response);
                break;
            default:
                showListProductCus(request, response);
                break;
        }
    }


    private void showViewProductCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.search(id);
        request.setAttribute("products", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showListProductCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sort1 = request.getParameter("sort1");
        String sort2 = request.getParameter("sort2");
        String sort3 = request.getParameter("sort3");
        String search = request.getParameter("search");
        List<Product> productList;
        if (search == null && sort1 == null && sort2 == null && sort3 == null) {
            productList = productDAO.getAllProduct();
        } else if (search != null){
            productList = productDAO.searchByName(search);
        } else if (sort1 != null){
            productList = productDAO.searchByCategoryId(1);
        } else if (sort2 != null) {
            productList = productDAO.searchByCategoryId(2);
        } else {
            productList = productDAO.searchByCategoryId(3);
        }

        HttpSession httpSession = request.getSession();
        String username = (String)httpSession.getAttribute("username");

        request.setAttribute("products", productList);
        request.setAttribute("username", username);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
