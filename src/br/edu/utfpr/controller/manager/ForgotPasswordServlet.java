package br.edu.utfpr.controller.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.UserService;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {

	public ForgotPasswordServlet() {
		super();
	}

	/**
	 * Requisições GET apenas renderizamos a visão <forgot_password>
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("error_message", "");
		request.getRequestDispatcher("/views/manager/forgot_password.jsp").forward(request, response);
	}

	/**
	 * Requisições POST enviamos email para alterar senha.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Verificando se o usuário informou o email.
		String email = request.getParameter("email");
		if (email.equals("")) {
			request.setAttribute("error_message", "Você não preencheu o e-mail.");
			request.getRequestDispatcher("/views/manager/forgot_password.jsp").forward(request, response);
		}

		// Verificando se o usuário referente ao email existe.
		UserService userService = new UserService();
		User user = (User) userService.getByProperty("email", email);
		if (user == null) {
			request.setAttribute("error_message", "O email informado não pertence a nenhum usuário.");
			request.getRequestDispatcher("/views/manager/forgot_password.jsp").forward(request, response);
		}
		
//		if (user.get)
		

		response.getWriter().println("ForgotPasswordServlet.doPost");
	}

}
