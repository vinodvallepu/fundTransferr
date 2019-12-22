package com.hcl.service;

import com.hcl.dto.CustomerDto;
import com.hcl.dto.CustomerDtoResponse;

public interface CustomerService {
	
	public CustomerDtoResponse customerRegistration(CustomerDto customerDto);

}
