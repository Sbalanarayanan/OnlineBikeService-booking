package com.chainsys.bikeservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bikeservice.dao.EmployeeDetailDAO;
import com.chainsys.bikeservice.model.EmployeeDetail;

/**
 * Servlet implementation class ViewEmployeeServlet
 */
@WebServlet("/ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EmployeeDetailDAO employeeDao = new EmployeeDetailDAO();
		try {
			List<EmployeeDetail> employeeLists = employeeDao.findAll();
			request.setAttribute("EMPLOYEELIST", employeeLists);
			RequestDispatcher rd = request
					.getRequestDispatcher("viewemployee.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
		}
	}
}
