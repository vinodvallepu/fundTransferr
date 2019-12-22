package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.CustomerDto;
import com.hcl.dto.CustomerDtoResponse;
import com.hcl.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<CustomerDtoResponse> customerRegistration(@RequestBody CustomerDto customerDto) {
		CustomerDtoResponse customerDtoResponse= customerService.customerRegistration(customerDto);
	return new ResponseEntity<>(customerDtoResponse,HttpStatus.CREATED);
		
		
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String CustomerControler1() {
		System.out.println("hi");
		return "i am controller";
	}

	@RequestMapping(value = "/reterive", method = RequestMethod.GET)
	public String CustomerControler2() {
		System.out.println("hi");
		return "i am controller";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.DELETE)
	public String CustomerControler3() {
		System.out.println("hi");
		return "i am controller";
	}


}
