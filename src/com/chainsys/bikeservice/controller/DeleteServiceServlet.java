package com.chainsys.bikeservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bikeservice.dao.ServiceTypeDAO;
import com.chainsys.bikeservice.model.ServiceType;

/**
 * Servlet implementation class DeleteServiceServlet
 */
@WebServlet("/DeleteServiceServlet")
public class DeleteServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		ServiceType sType = new ServiceType();
		sType.setId(id);
		ServiceTypeDAO serviceDao = new ServiceTypeDAO();
		try {
			serviceDao.deleteService(sType);
			List<ServiceType> typeList = serviceDao.findAll();
			request.setAttribute("SERVICETYPE", typeList);
			RequestDispatcher rd = request
					.getRequestDispatcher("deleteservice.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
