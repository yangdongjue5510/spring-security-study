package com.eazybytes.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eazybytes.model.Customer;
import com.eazybytes.model.SecurityCustomer;
import com.eazybytes.repository.CustomerRepository;

@Service
public class EazyBankUserDetails implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		List<Customer> customers = customerRepository.findByEmail(s);
		if (customers.size() == 0) {
			throw new UsernameNotFoundException("username not found : " + s);
		}
		return new SecurityCustomer(customers.get(0));
	}
}
