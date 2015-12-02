package br.edu.utfpr.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.utfpr.model.Customer;
import br.edu.utfpr.model.Transaction;
import br.edu.utfpr.model.dao.CustomerDAO;
import br.edu.utfpr.model.dao.TransactionDAO;
import br.edu.utfpr.util.JPAUtil;
import java.sql.Date;

public class TransactionService extends AbstractService<Long, Transaction>{
	
	protected EntityManager entityManager;
	public TransactionService(){
		dao = new TransactionDAO();
		this.entityManager = JPAUtil.getEntityManager();
	}	

	
	public List<Transaction> filterDates (Date beginDate, Date endDate){
		this.entityManager = JPAUtil.getEntityManager();
		
		return (List<Transaction>) entityManager.createQuery("FROM Transaction WHERE date BETWEEN " 
		+ beginDate + " AND " + endDate + " order by id desc").setFirstResult(0)  
				 .setMaxResults(30).getResultList();
	}
}
