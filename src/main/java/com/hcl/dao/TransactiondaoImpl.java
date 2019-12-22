package com.hcl.dao;

import java.time.LocalDateTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.hcl.dto.TransactionDto;
import com.hcl.dto.TransactiondtoResponse;
import com.hcl.entity.Accounts;
import com.hcl.entity.Transaction;
import com.hcl.exception.ErrorMessage;
import com.hcl.utils.TransactionType;

public class TransactiondaoImpl implements TransactionDao{

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public Session getSession() {
		Session session=null;
		try {
			session=sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session=sessionFactory.openSession();
		}
		return session;
	}
	
	@Override
	public TransactiondtoResponse transaction(TransactionDto transactionDto) throws ErrorMessage{
		
		Accounts fromAccount=customerDao.findByAccountNum(transactionDto.getFromAccount());
		Accounts toAccount=customerDao.findByAccountNum(transactionDto.getToAccount());
		
		
		if(fromAccount.getBalance() < transactionDto.getAmount())
			throw new ErrorMessage("Insufficent balance..");
		
		fromAccount.setBalance(fromAccount.getBalance()-transactionDto.getAmount());
		toAccount.setBalance(toAccount.getBalance()+transactionDto.getAmount());
		
		
		//transaction table Updating
		Session session=this.sessionFactory.getCurrentSession();
		Transaction transaction=new Transaction();
		BeanUtils.copyProperties(transactionDto, transaction);
		transaction.setTransactionType(TransactionType.credit);
		transaction.setTransactionDate(LocalDateTime.now());
		session.save(transaction);
		
		
		//account table Updating
		session.save(toAccount);
		session.save(fromAccount);
		
		
		TransactiondtoResponse transactiondtoResponse=new TransactiondtoResponse();
		transactiondtoResponse.setMessage("transaction successfully");
		transactiondtoResponse.setStatusCode(HttpStatus.OK.value());
		return transactiondtoResponse;
	}

}
