package de.mobile.service.impl;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import de.mobile.dto.entity.MobileCustomer;
import de.mobile.dto.model.AdResponse;
import de.mobile.dto.model.CustomerRequest;
import de.mobile.dto.model.CustomerResponse;
import de.mobile.repository.AdRepository;
import de.mobile.repository.CustomerRepository;
import de.mobile.service.ICustomerService;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	private static final Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AdRepository adRepository;

	@Override
	public void create(CustomerRequest customer) {

		MobileCustomer mc = new MobileCustomer();
		copyProperties(customer, mc);
		log.info("Object to save " + mc.toString());
		customerRepository.save(mc);
		log.info("Successfully saved!!");
	}

	@Override
	public void remove(Long id) {
		
		MobileCustomer mc = customerRepository.findById(id);
		if (!ObjectUtils.isEmpty(mc)) {
			if(!CollectionUtils.isEmpty(mc.getMobileAds())) {
				mc.getMobileAds().stream().forEach(ma -> {
					adRepository.delete(ma);
				});
			}
			customerRepository.delete(id);
			log.info("Successfully Deleted id-" + id);
		}
	}

	@Override
	public List<CustomerResponse> listCustomers() {

		List<CustomerResponse> customers = new ArrayList<>();

		customerRepository.findAll().forEach(cus -> {
			CustomerResponse customerResponse = new CustomerResponse();
			copyProperties(cus, customerResponse);
			List<AdResponse> ads = new ArrayList<>();
			if (!CollectionUtils.isEmpty(cus.getMobileAds())) {
				cus.getMobileAds().forEach(ad -> {
					AdResponse ad1 = new AdResponse();
					copyProperties(ad, ad1);
					ads.add(ad1);
				});
				customerResponse.setAds(ads);
			}
			customers.add(customerResponse);
		});
		log.info("The requested customer details " + customers.toString());
		return customers;
	}

	@Override
	public CustomerResponse get(Long id) {

		CustomerResponse customer = new CustomerResponse();
		MobileCustomer mc = customerRepository.findById(id);

		if (!ObjectUtils.isEmpty(mc)) {
			log.info("The requested customer detail " + mc.toString());
			List<AdResponse> ads = new ArrayList<>();
			copyProperties(mc, customer);
			if (!CollectionUtils.isEmpty(mc.getMobileAds())) {
				mc.getMobileAds().forEach(m -> {
					AdResponse ad = new AdResponse();
					copyProperties(m, ad);
					ads.add(ad);
				});
				customer.setAds(ads);
			}
		}
		return customer;
	}

}
