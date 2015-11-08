package br.edu.utfpr.controller.manager;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.Transaction;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.TransactionService;

/**
 * Servlet implementation class RegisterTransactionServlet
 */
@WebServlet("/manager/register-transaction")
public class RegisterTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long customer_id = Integer.parseInt(request.getParameter("customer_id"));
		TransactionService service = new TransactionService();
		CustomerService cs = new CustomerService();
		Customer customer = cs.getById(customer_id);
		BigDecimal value = BigDecimal.valueOf(Double.parseDouble((request.getParameter("value"))));
		boolean operation = Boolean.parseBoolean(request.getParameter("operation"));
				
		Date data = new Date();
		Transaction transaction = new Transaction(data,value, operation, customer);
		
		service.save(transaction);
		String address = "/WEB-INF/views/manager/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}
