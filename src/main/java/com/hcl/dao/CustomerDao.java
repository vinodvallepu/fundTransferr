package com.hcl.dao;

import com.hcl.dto.CustomerDto;
import com.hcl.dto.CustomerDtoResponse;
import com.hcl.entity.Accounts;
import com.hcl.exception.CustomerException;
import com.hcl.exception.ErrorResponse;

public interface CustomerDao {
	
	public CustomerDtoResponse customerRegistration(CustomerDto customerDto);
	
	public Accounts findByAccountNum(Integer accountNum) throws CustomerException;


}
