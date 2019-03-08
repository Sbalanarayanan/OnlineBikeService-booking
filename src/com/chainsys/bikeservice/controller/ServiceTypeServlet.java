package com.chainsys.bikeservice.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bikeservice.dao.ServiceTypeDAO;
import com.chainsys.bikeservice.dao.SlotDAO;
import com.chainsys.bikeservice.model.ServiceType;
import com.chainsys.bikeservice.model.Slot;

/**
 * Servlet implementation class ServiceTypeServlet
 */
@WebServlet("/ServiceTypeServlet")
public class ServiceTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SlotDAO slotDao = new SlotDAO();
		Slot slot = new Slot();
		LocalDate curt = LocalDate.now();
		Date dates = Date.valueOf(curt);
		slot = slotDao.findByDate(dates);
		if (slot.getCount() == 0) {
			String msg = "Today Slot is over";
			request.setAttribute("DISPLAY", msg);
		} else {
			String slt = "Slots is Avilable";
			int count = slot.getCount();
			request.setAttribute("COUNT", count);
			request.setAttribute("SLOT", slt);
		}
		ServiceTypeDAO typeDao = new ServiceTypeDAO();
		List<ServiceType> typeList = typeDao.findAll();
		// System.out.println(typeList.size());
		request.setAttribute("SERVICETYPE", typeList);
		RequestDispatcher rd = request
				.getRequestDispatcher("customerdetails.jsp");
		rd.forward(request, response);
	}
}
