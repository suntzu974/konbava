package com.goyav.konbava.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goyav.konbava.dao.CustomerDao;
import com.goyav.konbava.dao.Factory;
import com.goyav.konbava.model.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao customerdao;
	
    public void init() throws ServletException {
    	Factory factory = Factory.getInstance();
    	this.customerdao = factory.getCustomerDao();
    	
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertCustomer(request, response);
					break;
				case "/delete":
					deleteCustomer(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					updateCustomer(request, response);
					break;
				default:
					listCustomer(request, response);
					break;
		}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		request.setAttribute("customers", customerdao.getCustomers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/customerList.jsp").forward(request,response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		request.setAttribute("customers", customerdao.getCustomers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/createCustomerView.jsp").forward(request,response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerdao.getCustomer(id);
		request.setAttribute("customer", existingCustomer);	
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/editCustomerView.jsp").forward(request,response);
	}
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		customer.setTown(request.getParameter("town"));
		customer.setPostal(request.getParameter("postal"));
		customerdao.insert(customer);
		request.setAttribute("customers", customerdao.getCustomers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/customerList.jsp").forward(request,response);
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer customer = new Customer(id);
		customerdao.delete(customer);
		request.setAttribute("customers", customerdao.getCustomers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/customerList.jsp").forward(request,response);
	}
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Customer customer = new Customer();
		customer.setId(Integer.parseInt(request.getParameter("id")));
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		customer.setTown(request.getParameter("town"));
		customer.setPostal(request.getParameter("postal"));

		customerdao.update(customer);
		request.setAttribute("customers", customerdao.getCustomers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/customerList.jsp").forward(request,response);

	}

}
