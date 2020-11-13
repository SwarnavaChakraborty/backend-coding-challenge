package de.mobile.common.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;

import de.mobile.common.Category;
import de.mobile.dto.model.AdRequest;
import de.mobile.dto.model.CustomerRequest;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RequestValidator.class })
class RequestValidatorTest {

	@Test
	void testIsValidAdRequest() {
		try {
			RequestValidator spy = PowerMockito.spy(new RequestValidator());
			assertTrue(WhiteboxImpl.invokeMethod(spy, "isValidAdRequest", getValidAdRequest()));
			assertFalse(WhiteboxImpl.invokeMethod(spy, "isValidAdRequest", getInValidAdRequest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testIsValidCustomerRequest() {
		try {
			RequestValidator spy = PowerMockito.spy(new RequestValidator());
			assertTrue(WhiteboxImpl.invokeMethod(spy, "isValidCustomerRequest", getValidCustomerRequest()));
			assertFalse(WhiteboxImpl.invokeMethod(spy, "isValidCustomerRequest", getInValidCustomerRequest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AdRequest getValidAdRequest() {
		AdRequest adRequest = new AdRequest();
		adRequest.setCategory(Category.Car);
		adRequest.setCustomerId(1l);
		adRequest.setDescription("Test");
		adRequest.setMake("BMW");
		adRequest.setModel("S200");
		return adRequest;
	}

	private AdRequest getInValidAdRequest() {
		AdRequest adRequest = new AdRequest();
		adRequest.setCategory(null);
		adRequest.setCustomerId(1l);
		adRequest.setDescription("Test");
		adRequest.setMake("BMW");
		adRequest.setModel("S200");
		return adRequest;
	}

	private CustomerRequest getValidCustomerRequest() {
		CustomerRequest request = new CustomerRequest();
		request.setCompanyName("BMW");
		request.setEmail("test@bmv.co.de");
		request.setFirstName("Abc");
		request.setLastName("Xyz");
		return request;
	}

	private CustomerRequest getInValidCustomerRequest() {
		CustomerRequest request = new CustomerRequest();
		request.setCompanyName("BMW");
		request.setEmail("test@co@bmv.co.de");
		request.setFirstName("Abc");
		request.setLastName("Xyz");
		return request;
	}

}
