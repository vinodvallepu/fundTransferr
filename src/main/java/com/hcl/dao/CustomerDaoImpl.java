package com.hcl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.hcl.dto.CustomerDto;
import com.hcl.dto.CustomerDtoResponse;
import com.hcl.entity.Accounts;
import com.hcl.entity.Customers;
import com.hcl.exception.CustomerException;
import com.hcl.utils.PinGenerate;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@Override
	public CustomerDtoResponse customerRegistration(CustomerDto customerDto) {

		Customers customer = new Customers();
		BeanUtils.copyProperties(customerDto, customer);

		getSession().save(customer);
		
		int accountNum=PinGenerate.generatePin(9999, 99999);
		Accounts accounts=new Accounts();
		accounts.setAccountNum(accountNum);
		accounts.setCustomers(customer);
		accounts.setBalance(customerDto.getBalance());
		getSession().save(accounts);
		

		CustomerDtoResponse customerResponse = new CustomerDtoResponse();
		customerResponse.setMessage("user registered successfully");
		customerResponse.setStatusCode(HttpStatus.CREATED.value());

		return customerResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Accounts findByAccountNum(Integer accountNum) throws CustomerException {
		Session session=this.sessionFactory.getCurrentSession();
		
		Criteria criteria=session.createCriteria(Accounts.class);
		criteria.add(Restrictions.eqOrIsNull("accountNum", accountNum));
		List<Accounts> accounts=criteria.list();
		
		if(accounts.isEmpty())
			throw new CustomerException("invalid User");
		
		return accounts.get(0);
	}

}
