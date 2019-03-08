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
 * Servlet implementation class ServiceNameServlet
 */
@WebServlet("/ServiceNameServlet")
public class ServiceNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServiceTypeDAO typeDao = new ServiceTypeDAO();
		List<ServiceType> typeList = typeDao.findAll();
		request.setAttribute("TYPENAME", typeList);
		RequestDispatcher rd = request
				.getRequestDispatcher("viewallservice.jsp");
		rd.forward(request, response);
	}
}
