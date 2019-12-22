package com.hcl.service;

import com.hcl.dto.TransactionDto;
import com.hcl.dto.TransactiondtoResponse;
import com.hcl.exception.ErrorMessage;

public interface TransactionService {
	public TransactiondtoResponse transaction(TransactionDto transactionDto)throws ErrorMessage;

}
