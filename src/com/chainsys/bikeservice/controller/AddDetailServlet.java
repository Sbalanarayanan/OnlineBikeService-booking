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

import com.chainsys.bikeservice.dao.CustomerDetailDAO;
import com.chainsys.bikeservice.dao.ServiceTypeDAO;
import com.chainsys.bikeservice.dao.SlotDAO;
import com.chainsys.bikeservice.model.CustomerDetail;
import com.chainsys.bikeservice.model.ServiceType;
import com.chainsys.bikeservice.model.Slot;

/**
 * Servlet implementation class AddDetailServlet
 */
@WebServlet("/AddDetailServlet")
public class AddDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String customerName = request.getParameter("customerName");
		long phone = Long.parseLong(request.getParameter("customerPhone"));
		String customerAddress = request.getParameter("customerAddress");
		String companyName = request.getParameter("companyName");
		String bikeName = request.getParameter("bikeName");
		String bikeModel = request.getParameter("bikeModel");
		String bikeNumber = request.getParameter("bikeNumber");
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setName(customerName);
		customerDetail.setPhone(phone);
		customerDetail.setAddress(customerAddress);
		customerDetail.setCompanyName(companyName);
		customerDetail.setBikeName(bikeName);
		customerDetail.setBikeModel(bikeModel);
		customerDetail.setBikeNumber(bikeNumber);
		SlotDAO slotDao = new SlotDAO();
		Slot slot = new Slot();
		LocalDate curt = LocalDate.now();
		Date dates = Date.valueOf(curt);
		slot = slotDao.findByDate(dates);
		int id = Integer.parseInt(request.getParameter("serviceType"));
		ServiceTypeDAO serviceTypeDAO = new ServiceTypeDAO();
		ServiceType service = serviceTypeDAO.findById(id);
		customerDetail.setCustomerIssue(service);
		CustomerDetailDAO serviceDao = new CustomerDetailDAO();
		try {
			if (slot.getCount() > 0) {
				slot.setCount(slot.getCount() - 1);
				slot.setId(slot.getId());
				slotDao.upDate(slot);
				serviceDao.addCustomer(customerDetail);
				List<CustomerDetail> custDetails = serviceDao.findAll();
				request.setAttribute("CUSTOMERDETAILS", custDetails);
				String msg = "Detail is recived";
				request.setAttribute("DETAILS", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("viewdetail.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("customerdetails.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request
					.getRequestDispatcher("customerdetails.jsp");
			rd.forward(request, response);
		}
	}
}
