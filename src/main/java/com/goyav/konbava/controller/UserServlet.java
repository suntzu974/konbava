package com.goyav.konbava.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goyav.konbava.dao.Factory;
import com.goyav.konbava.dao.UserDao;
import com.goyav.konbava.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userdao;
	
    public void init() throws ServletException {
    	Factory factory = Factory.getInstance();
    	this.userdao = factory.getUserDao();
    	
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("users", userdao.getUsers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName(request.getParameter("name"));
		userdao.insert(user);
		request.setAttribute("users", userdao.getUsers());
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/users.jsp").forward(request,response);

	}

}
