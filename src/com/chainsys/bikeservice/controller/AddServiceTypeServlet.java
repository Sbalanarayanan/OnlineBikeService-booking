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
 * Servlet implementation class AddServiceTypeServlet
 */
@WebServlet("/AddServiceTypeServlet")
public class AddServiceTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String typename = request.getParameter("typename");
		int days = Integer.parseInt(request.getParameter("days"));
		ServiceType service = new ServiceType();
		service.setName(typename);
		service.setDays(days);
		ServiceTypeDAO serviceDao = new ServiceTypeDAO();
		try {
			serviceDao.addType(service);
			List<ServiceType> typeList = serviceDao.findAll();
			request.setAttribute("SERVICETYPE", typeList);
			RequestDispatcher rd = request
					.getRequestDispatcher("viewaddedservice.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
