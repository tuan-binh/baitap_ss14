package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
	private ProductService productService;
	
	public void init() {
		productService = new ProductService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
			case "getList":
				break;
			case "addProduct":
				request.getRequestDispatcher("/WEB-INF/view/addProduct.jsp").forward(request, response);
				break;
			case "delete":
				productService.delete(Integer.parseInt(request.getParameter("id")));
				break;
			case "edit":
				System.out.println(Integer.parseInt(request.getParameter("id")));
				Product product = productService.findById(Integer.parseInt(request.getParameter("id")));
				System.out.println(product.getName());
				request.setAttribute("data", product);
				request.getRequestDispatcher("/WEB-INF/view/editProduct.jsp").forward(request, response);
				break;
			case "details":
				Product details = productService.findById(Integer.parseInt(request.getParameter("id")));
				HttpSession session = request.getSession();
				session.setAttribute("detail",details);
//				request.setAttribute("data", details);
				request.getRequestDispatcher("/WEB-INF/view/viewDetails.jsp").forward(request, response);
				break;
			default:
				break;
		}
		showListProduct(productService.getList(), request, response);
	}
	
	public void showListProduct(List<Product> list, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
//		session.setAttribute("data",list);
		request.setAttribute("data", list);
		request.getRequestDispatcher("/WEB-INF/view/products.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		switch (action) {
			case "add":
				String name = request.getParameter("name");
				String desc = request.getParameter("desc");
				double price = Double.parseDouble(request.getParameter("price"));
				String url = request.getParameter("urlImage");
				productService.save(new Product(0, name, desc, price, url));
				response.sendRedirect(request.getContextPath() + "/");
//				request.getRequestDispatcher("/ProductServlet?action=getList").forward(request,response);
				break;
			case "update":
				int id = Integer.parseInt(request.getParameter("id"));
				String newName = request.getParameter("name");
				String newDesc = request.getParameter("desc");
				double newPrice = Double.parseDouble(request.getParameter("price"));
				String newUrl = request.getParameter("urlImage");
				productService.save(new Product(id, newName, newDesc, newPrice, newUrl));
				response.sendRedirect(request.getContextPath() + "/");
				break;
			case "search":
				List<Product> products = new ArrayList<>();
				String text = request.getParameter("search");
				for (Product p : productService.getList()) {
					if (p.getName().toLowerCase().contains(text.toLowerCase())) {
						products.add(p);
					}
				}
				showListProduct(products,request,response);
				break;
			default:
				break;
		}
	}
	
	@Override
	public void destroy() {
	
	}
}