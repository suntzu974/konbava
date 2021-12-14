package com.goyav.konbava.controller;

import java.io.IOException;
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
@WebServlet("/customers")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("customers", customerdao.getCustomers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setAccount(Double.valueOf(request.getParameter("account")));
		customerdao.insert(customer);
		request.setAttribute("customers", customerdao.getCustomers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request,response);

	}

}
