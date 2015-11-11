package br.edu.utfpr.controller.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.Person;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.util.MoneyUtil;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/manager/transaction")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/WEB-INF/views/manager/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ra = request.getParameter("ra");
		System.out.println("ra - > servelet" + ra);
		CustomerService customer = new CustomerService();
		
		Customer result = customer.getByProperty("login", ra);
		
		request.getSession().setAttribute("customerPayment", customer);
		
		request.setAttribute("login", result.getLogin());
		request.setAttribute("name", result.getName());
		request.setAttribute("id", result.getId());
		request.setAttribute("value", MoneyUtil.formatMoney(result.getValue()));
		request.setAttribute("colleger", result.getColleger());
		
		String address = "/WEB-INF/views/manager/payment.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);	
	}

}
