package br.edu.utfpr.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static void send(String emailDestiny, String subject, String msg) {

		/** Parâmetros de conexão com servidor Gmail */
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("rogeeriomiss@gmail.com", "utfpr-ru");
			}
		});

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rogeriomiss@alunos.utfpr.edu.br")); // Remetente

			Address[] toUser = InternetAddress.parse(emailDestiny); // Destinatário(s)

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(subject);// Assunto
			message.setText(msg);

			/** Método para enviar a mensagem criada */
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
