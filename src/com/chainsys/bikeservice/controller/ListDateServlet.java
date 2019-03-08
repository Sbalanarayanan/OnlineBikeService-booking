package com.chainsys.bikeservice.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bikeservice.dao.CustomerDetailDAO;
import com.chainsys.bikeservice.model.CustomerDetail;

/**
 * Servlet implementation class ListDateServlet
 */
@WebServlet("/ListDateServlet")
public class ListDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalDate lDate = LocalDate.parse(request.getParameter("dateview"));
		CustomerDetail cust = new CustomerDetail();
		cust.setExpectedDate(lDate);
		CustomerDetailDAO custDao = new CustomerDetailDAO();
		try {
			List<CustomerDetail> dateList = custDao.findByDate(cust
					.getExpectedDate());
			request.setAttribute("CUSTOMERDETAILS", dateList);
			RequestDispatcher rd = request.getRequestDispatcher("dateview.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
