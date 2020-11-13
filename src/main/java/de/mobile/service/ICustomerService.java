package de.mobile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.mobile.dto.model.CustomerRequest;
import de.mobile.dto.model.CustomerResponse;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@Service
public interface ICustomerService {


	void create(CustomerRequest customer);
	
	void remove(Long id);

	List<CustomerResponse> listCustomers();

	CustomerResponse get(Long id);
}
