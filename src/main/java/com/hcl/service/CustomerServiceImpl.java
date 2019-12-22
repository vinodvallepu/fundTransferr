package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.CustomerDao;
import com.hcl.dto.CustomerDto;
import com.hcl.dto.CustomerDtoResponse;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public CustomerDtoResponse customerRegistration(CustomerDto customerDto) {
		return customerDao.customerRegistration(customerDto);
	}

}
