package com.hcl.dao;

import com.hcl.dto.TransactionDto;
import com.hcl.dto.TransactiondtoResponse;
import com.hcl.exception.ErrorMessage;

public interface TransactionDao {
	
	public TransactiondtoResponse transaction(TransactionDto transactionDto)throws ErrorMessage;

}
