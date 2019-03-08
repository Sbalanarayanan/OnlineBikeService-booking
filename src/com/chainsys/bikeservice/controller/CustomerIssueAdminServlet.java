package com.chainsys.bikeservice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bikeservice.dao.CustomerDetailDAO;
import com.chainsys.bikeservice.model.CustomerDetail;

/**
 * Servlet implementation class CustomerIssueAdminServlet
 */
@WebServlet("/CustomerIssueAdminServlet")
public class CustomerIssueAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CustomerDetailDAO serviceDao = new CustomerDetailDAO();
		try {
			ArrayList<CustomerDetail> custDetails = new ArrayList<>();
			custDetails.addAll(serviceDao.findAll());
			request.setAttribute("CUSTOMERDETAILS", custDetails);
			RequestDispatcher rd = request
					.getRequestDispatcher("customerissueadmin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
