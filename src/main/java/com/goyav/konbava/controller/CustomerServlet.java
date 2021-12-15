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
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/customerList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setName(request.getParameter("name"));
		customer.setAddress(request.getParameter("address"));
		customer.setTown(request.getParameter("town"));
		customer.setPostal(request.getParameter("postal"));
		customerdao.insert(customer);
		request.setAttribute("customers", customerdao.getCustomers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/createCsutomerView.jsp").forward(request,response);
	}
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String address = (String) request.getParameter("address");
		String postal = (String) request.getParameter("postal");
		String town = (String) request.getParameter("town");
		Customer customer = new Customer(name, address, postal, town);

		String errorString = null;
		customerdao.update(customer);
		// Enregistrez des informations à l'attribut de la demande avant de transmettre aux vues.
		request.setAttribute("errorString", errorString);
		request.setAttribute("customer", customer);

		// S'il n'y a pas d'erreur, transmettez à la page d'édition.
		if (errorString != null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/ceditCustomerView.jsp").forward(request,response);
		}
		// S'il n'y a aucun problème.
		// Réorientez vers la page de la liste des produits.
		else {
			response.sendRedirect(request.getContextPath() + "/customerList");
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
