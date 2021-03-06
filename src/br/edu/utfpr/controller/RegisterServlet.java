package br.edu.utfpr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.util.Crypto;
import br.edu.utfpr.util.StringUtil;


/**
 * 
 * Registrar no sistema
 * 
 * @author gomesandre
 *
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = "/views/register.jsp";		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> mapParams = new HashMap<String, String>();
		HashMap<String, String> result;
		
		mapParams.put("name", StringUtil.formalizeName(request.getParameter("name").trim()));
		mapParams.put("login", request.getParameter("login").trim());
		mapParams.put("type", request.getParameter("type"));
		mapParams.put("password", Crypto.encrypt(request.getParameter("password")));
		mapParams.put("colleger", request.getParameter("colleger"));
		mapParams.put("balance", request.getParameter("balance"));
		mapParams.put("email",request.getParameter("email"));
		
		result = verifyParameters(mapParams);		
		CustomerService customerService = new CustomerService();
		
		try {
			if(result.size() > 0){
				request.setAttribute("flashMessage", result);
				request.setAttribute("flashType", "warning");
			}else{
				Long value = (long) 0;
				
				Customer customer = new Customer(
						mapParams.get("name"),
						mapParams.get("login"),
						mapParams.get("type"),
						value,
						mapParams.get("password"),
						mapParams.get("colleger"),
						mapParams.get("email")
					);
				if(!customer.isUnique()){
					result.put("Erro", "Cliente já existe");
					request.setAttribute("flashMessage", result);
					request.setAttribute("flashType", "warning");					
				}else{
					customerService.save(customer);
					result.put("Sucesso", "Cliente foi salvo.");
					request.setAttribute("flashMessage", result);
					request.setAttribute("flashType", "success");						
				}				
			}			
		} 
		catch (Exception e) {
			result.put("Erro", "Erro ao salvar cliente");
			request.setAttribute("flashMessage", result);
			request.setAttribute("flashType", "danger");
		}
		finally{
			
			result.put("Sucesso", "Cliente foi salvo.");
			request.setAttribute("flashMessage", result);
			request.setAttribute("flashType", "success");
			
			String address = "/views/login.jsp";			
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
	}
	
	/**
	 * 
	 * @param parameters
	 * @return
	 */
	private HashMap<String, String> verifyParameters(HashMap<String, String> parameters){

		HashMap<String, String> result = new HashMap<String, String>();
		
		for (Entry<String, String> entry : parameters.entrySet()) {			
			switch (entry.getKey().toString()) {
				case "name":
					String[] splitname = entry.getValue().split(" ");
					if(splitname.length < 2)
						result.put("Nome", "É necessário nome e sobrenome.");
				break;
				case "login":
					if(entry.getValue().length() == 0)
						result.put("Login", "Valor está em branco.");
				break;
				case "type":
					if(entry.getValue().length() == 0)
						result.put("Tipo de Pessoa", "Valor está em branco.");
				break;
				case "value":
					if(entry.getValue().length() == 0)
						result.put("Valor", "Valor está em branco.");
				break;
				case "colleger":
					if(entry.getValue().length() == 0)
						result.put("Bolsista", "Valor está em branco.");
				break;
				case "password":
					if(entry.getValue().length() == 0)
						result.put("Password", "Valor está em branco.");
				break;
				case "email":
					if(entry.getValue().length() == 0)
						result.put("Email", "Valor está em branco.");
				break;
			}
		}		
				
		return result;
	}
}
