package com.chainsys.bikeservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.bikeservice.dao.SlotDAO;
import com.chainsys.bikeservice.model.Slot;

/**
 * Servlet implementation class SlotViewServlet
 */
@WebServlet("/SlotViewServlet")
public class SlotViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SlotDAO slotDao = new SlotDAO();
		try {
			List<Slot> slotList = slotDao.findAll();
			request.setAttribute("SLOT", slotList);
			RequestDispatcher rd = request.getRequestDispatcher("slotview.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
		}
	}
}
