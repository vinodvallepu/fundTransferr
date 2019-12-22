package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.TransactionDto;
import com.hcl.dto.TransactiondtoResponse;
import com.hcl.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public ResponseEntity<TransactiondtoResponse> transaction(TransactionDto transactionDto){
		TransactiondtoResponse transactiondtoResponse=transactionService.transaction(transactionDto);
		return new ResponseEntity<>(transactiondtoResponse,HttpStatus.CREATED);
		
	}

}
