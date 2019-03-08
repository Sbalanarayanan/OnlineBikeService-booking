package com.chainsys.bikeservice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bikeservice.dao.EmployeeDetailDAO;
import com.chainsys.bikeservice.model.EmployeeDetail;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("employeeName");
		long phone = Long.parseLong(request.getParameter("phone"));
		String address = request.getParameter("employeeAddress");
		EmployeeDetail employeeDetail = new EmployeeDetail();
		employeeDetail.setName(name);
		employeeDetail.setPhone(phone);
		employeeDetail.setAddress(address);
		EmployeeDetailDAO seviceDao = new EmployeeDetailDAO();
		try {
			seviceDao.addEmployee(employeeDetail);
			String msg = "Employee  added";
			request.setAttribute("DETAILS", msg);
			RequestDispatcher rd = request
					.getRequestDispatcher("employeedetails.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
		}
	}
}
