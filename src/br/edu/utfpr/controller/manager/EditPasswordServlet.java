package br.edu.utfpr.controller.manager;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.User;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Crypto;
import br.edu.utfpr.util.Email;
import br.edu.utfpr.util.Route;

@WebServlet("/EditPasswordServlet")
public class EditPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Verificando se foi passado uma hash.
		String hash = request.getParameter("hash");
		if (hash == null || hash.equals("")) {
			response.sendRedirect(Route.getProjectUrl(request) + "views/manager/login.jsp");
		} else {

			// Verificando se o usuário referente a hash existe.
			UserService userService = new UserService();
			User user = userService.getByProperty("passwordForgotHash", hash);
			if (user == null) {
				response.sendRedirect(Route.getProjectUrl(request) + "views/manager/login.jsp");
			} else {

				// Renderizando a visão para o usuário alterar a senha.
				request.setAttribute("user", user);
				request.getRequestDispatcher("/views/manager/edit_password.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Verificando se o usuário referente a hash existe.
		UserService userService = new UserService();
		User user = userService.getByProperty("passwordForgotHash", request.getParameter("passwordForgotHash"));
		if (user == null) {
			response.sendRedirect(Route.getProjectUrl(request) + "views/manager/login.jsp");
		}

		user.setPasswordForgotHash("");
		user.setPassword(Crypto.encrypt(request.getParameter("password")));
		userService.update(user);
		request.getRequestDispatcher("/views/manager/message_password_edited.jsp").forward(request, response);
	}

}
