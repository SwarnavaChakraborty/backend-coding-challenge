package de.mobile.common.validation;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.HashSet;

import de.mobile.common.Category;
import de.mobile.dto.model.AdRequest;
import de.mobile.dto.model.CustomerRequest;

public class RequestValidator {

	private final static String alphabetPattern = "^[a-zA-Z]*$";

	public static boolean isValidAdRequest(AdRequest request) {
		return (null != request.getCustomerId() && isNotEmpty(request.getMake()) && isNotEmpty(request.getModel())
				&& isValidCategory(request.getCategory())) ? true : false;
	}

	public static boolean isValidCustomerRequest(CustomerRequest request) {
		return (isNotEmpty(request.getFirstName()) && request.getFirstName().matches(alphabetPattern)
				&& isNotEmpty(request.getLastName()) && request.getLastName().matches(alphabetPattern)
				&& isNotEmpty(request.getEmail()) && isValidEmailAddress(request.getEmail())) ? true : false;
	}

	private static boolean isValidCategory(Category category) {

		HashSet<Category> values = new HashSet<>();
		for (Category c : Category.values()) {
			values.add(c);
		}
		return values.contains(category);
	}

	private static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

}
