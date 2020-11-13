package de.mobile.dto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CustomerResponse {

	@JsonProperty("mobileCustomerId")
	private Long mobileCustomerId;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("companyName")
	private String companyName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("ads")
	private List<AdResponse> ads;

	public CustomerResponse() {
	}

	public Long getMobileCustomerId() {
		return mobileCustomerId;
	}

	public void setMobileCustomerId(Long mobileCustomerId) {
		this.mobileCustomerId = mobileCustomerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AdResponse> getAds() {
		return ads;
	}

	public void setAds(List<AdResponse> ads) {
		this.ads = ads;
	}

	@Override
	public String toString() {
		return "CustomerResponse [mobileCustomerId=" + mobileCustomerId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", companyName=" + companyName + ", email=" + email + ", ads=" + ads + "]";
	}

}
