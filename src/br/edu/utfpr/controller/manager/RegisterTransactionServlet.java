package br.edu.utfpr.controller.manager;

import java.io.IOException;
import java.math.BigDecimal;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.Transaction;
import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.TransactionService;
import br.edu.utfpr.util.MoneyUtil;

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
		long value = Long.parseLong(request.getParameter("value").replaceAll("[^\\d.-]", ""));
		boolean operation = Boolean.parseBoolean(request.getParameter("operation"));
				
		Date data = new Date();
		Transaction transaction = new Transaction(data,value, operation, customer);
		
		String operacao = operation == true ? "Debito" : "Credito";
		
		HashMap<String, String> messageMap = new HashMap<String, String>();
		
		if(checkBalance(customer, value)){
			try {
				service.save(transaction);
				
				upadateBalance(customer, value, operation);
				
				sendMail(customer.getEmail(), value, operacao);
				
				messageMap.put("success", "Transação realizada com sucesso!");
				request.setAttribute("msg", messageMap);
				
				String address = "/WEB-INF/views/manager/index.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(address);
				dispatcher.forward(request, response);
			} catch (RuntimeException ex){
				ex.printStackTrace();
			}
			
		} else {
			messageMap.put("danger", "Usuário não possue credito sulficiente para essa operação!");
			
			request.setAttribute("msg", messageMap);
			
			request.setAttribute("login", customer.getLogin());
			request.setAttribute("name", customer.getName());
			request.setAttribute("id", customer.getId());
			request.setAttribute("value", MoneyUtil.formatMoney(customer.getValue()));
			request.setAttribute("colleger", customer.getColleger());
		
			String address = "/WEB-INF/views/manager/payment.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
	}
	
	private void sendMail(String email, long valor, String operacao){
		Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               return new PasswordAuthentication("rogeeriomiss@gmail.com", "utfpr-ru");
                         }
                    });

        /** Ativa Debug para sessão */
        session.setDebug(true);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rogeriomiss@alunos.utfpr.edu.br")); //Remetente
		
			Address[] toUser = InternetAddress //Destinatário(s)
		             .parse(email);  
		
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Comprovante Transação RU");//Assunto
			message.setText("-----------Comprovante de "+operacao+"-----------\nFoi realizado um "+operacao+" de "+MoneyUtil.formatMoney(valor)+" reais em sua conta\nEnviado por RU\n-----------Comprovante "+operacao+"-----------");
			/**Método para enviar a mensagem criada*/
			Transport.send(message);
			System.out.println("Feito!!!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
  
	}

	private boolean checkBalance(Customer customer, long value){
		if(customer.getValue() < value){
			return false;
		}
			
		return true;
	}

	private void upadateBalance(Customer customer, long value, boolean operation){
		long balance;
		if (operation == true)
			balance = customer.getValue() - value;
		else
			balance = customer.getValue() + value;
			
		
		customer.setValue(balance);
		CustomerService c = new CustomerService();
		c.update(customer);
	}
}
