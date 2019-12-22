package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.dao.TransactionDao;
import com.hcl.dto.TransactionDto;
import com.hcl.dto.TransactiondtoResponse;
import com.hcl.exception.ErrorMessage;

public class TransactionServiceImpl  implements TransactionDao{

	@Autowired
	TransactionDao transactionDao;
	
	@Override
	public TransactiondtoResponse transaction(TransactionDto transactionDto) throws ErrorMessage {
		return transactionDao.transaction(transactionDto);
		
	}
	
	

}
