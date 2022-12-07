package com.casestudymodule3.servlet;

import com.casestudymodule3.dao.CustomerDAO;
import com.casestudymodule3.dao.ProductDAO;
import com.casestudymodule3.model.Customer;
import com.casestudymodule3.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    public static final String CATEGORY_1 = "1";
    public static final String CATEGORY_2 = "2";
    public static final String CATEGORY_3 = "3";
    ProductDAO productDAO = new ProductDAO();
    public static final int TOTAL_PER_PAGE = 6;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProduct(request, response);
                break;
            case "edit":
                showEditProduct(request, response);
                break;
            case "delete":
                showDeleteProduct(request, response);
                break;
            case "view-ad":
                showViewProduct(request, response);
                break;
            default:
                showListProduct(request, response);
                break;
        }
    }

    private void showViewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.search(id);
        request.setAttribute("products", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/viewAd.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.search(id);
        request.setAttribute("products", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/deleteAd.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.search(id);
        request.setAttribute("products", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/editAd.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/createAd.jsp");
        dispatcher.forward(request, response);
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Product> productList;
        if (search == null) {
            productList = productDAO.getAllProduct();
        } else {
            productList = productDAO.searchByName(search);
        }

        String pageIds = request.getParameter("page");
        List<Product> productList1 = getProductPagination(productList, pageIds);

        request.setAttribute("products", productList1);
        request.setAttribute("totalPage", productList.size() / TOTAL_PER_PAGE + 1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/listAd.jsp");
        dispatcher.forward(request, response);
    }
    private static List<Product> getProductPagination(List<Product> productList, String pageIds) {
        int pageId;
        if (pageIds == null) {
            pageId = 1;
        } else {
            pageId = Integer.parseInt(pageIds);
        }

        List<Product> productList1 = new ArrayList<>();

        for (int i = ((pageId - 1) * TOTAL_PER_PAGE); (i < pageId * TOTAL_PER_PAGE) && (i < productList.size()); i++) {
            productList1.add(productList.get(i));
        }
        return productList1;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                CreateProduct(request, response);
                break;
            case "edit":
                EditProduct(request, response);
                break;
            case "delete":
                DeleteProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.delete(id);
        response.sendRedirect("/products");
    }

    private void EditProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
//        String image = "/image/" + request.getParameter("file");
        String image = request.getParameter("image");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));


        Product product = new Product(id, name, image, price, title, description, categoryId);
        productDAO.update(id, product);

        response.sendRedirect("/products");
    }

    private void CreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product product = new Product(id, name, image, price, title, description, categoryId);
        productDAO.create(product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/createAd.jsp");
        dispatcher.forward(request, response);
    }
}
