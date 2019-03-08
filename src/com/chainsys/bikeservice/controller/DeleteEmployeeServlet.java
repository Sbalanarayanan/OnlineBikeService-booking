package com.chainsys.bikeservice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bikeservice.dao.EmployeeDetailDAO;
import com.chainsys.bikeservice.model.EmployeeDetail;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/DeleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeDetail employeeDelete = new EmployeeDetail();
		employeeDelete.setId(id);
		EmployeeDetailDAO employeeDao = new EmployeeDetailDAO();
		try {
			employeeDao.deleteService(employeeDelete);
			ArrayList<EmployeeDetail> employeeLists = new ArrayList<>();
			employeeLists.addAll(employeeDao.findAll());
			request.setAttribute("DELETEEMPLOYEE", employeeLists);
			RequestDispatcher rd = request
					.getRequestDispatcher("viewdeleteEmployee.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
		}
	}
}
