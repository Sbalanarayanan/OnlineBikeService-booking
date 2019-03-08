package com.chainsys.bikeservice.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bikeservice.dao.AdminDAO;
import com.chainsys.bikeservice.dao.CustomerDetailDAO;
import com.chainsys.bikeservice.model.AdminLogin;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long phone = Long.parseLong(request.getParameter("phone"));
		String password = request.getParameter("password");
		AdminLogin login = new AdminLogin();
		login.setPhone(phone);
		login.setPassword(password);
		AdminDAO adminDAO = new AdminDAO();
		if (adminDAO.checkLogin(login)) {
			RequestDispatcher req = request.getRequestDispatcher("admin.html");
			req.forward(request, response);
		} else {
			RequestDispatcher req = request.getRequestDispatcher("login.html");
			req.forward(request, response);
		}
		LocalDate date = LocalDate.now().minusDays(1);
		CustomerDetailDAO cust = new CustomerDetailDAO();
		try {
			cust.deleteCustomer(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
