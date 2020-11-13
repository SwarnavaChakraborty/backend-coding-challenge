package de.mobile.dto.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@Entity
@Table(name = "MobileCustomer")
public class MobileCustomer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8528193203120515657L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mobile_customer_id", unique = true, nullable = false)
	private Long mobileCustomerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "email")
	private String email;

	@OneToMany(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.DELETE})
	@JoinColumn(name = "customer_id")
	private Set<MobileAd> mobileAds;

	public MobileCustomer() {
		super();
	}

	public Long getMobileCustomerId() {
		return mobileCustomerId;
	}

	public void setMobileCustomerId(Long mobileCustomerId) {
		this.mobileCustomerId = mobileCustomerId;
	}

	public MobileCustomer(Long mobileCustomerId) {
		super();
		this.mobileCustomerId = mobileCustomerId;
	}

	public MobileCustomer(Long mobileCustomerId, String firstName, String lastName, String companyName, String email) {
		super();
		this.mobileCustomerId = mobileCustomerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.email = email;
	}

	public Long getCustomerId() {
		return mobileCustomerId;
	}

	public void setCustomerId(Long customerId) {
		this.mobileCustomerId = customerId;
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

	public Set<MobileAd> getMobileAds() {
		return mobileAds;
	}

	public void setMobileAds(Set<MobileAd> mobileAds) {
		this.mobileAds = mobileAds;
	}

	@Override
	public String toString() {
		return "MobileCustomer [mobileCustomerId=" + mobileCustomerId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", companyName=" + companyName + ", email=" + email + ", mobileAds=" + mobileAds + "]";
	}
}
