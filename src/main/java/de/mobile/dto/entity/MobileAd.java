package de.mobile.dto.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import de.mobile.common.Category;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@Entity
@Table(name = "MobileAd")
public class MobileAd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7043083472332376709L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "customer_id", unique = true, nullable = false)
	private Long customerId;

	@Column(name = "make")
	private String make;

	@Column(name = "model")
	private String model;

	@Column(name = "description")
	private String description;

	@Column(name = "category")
	private Category category;

	@Column(name = "price")
	private BigDecimal price;

	public MobileAd() {
		super();
	}

	public MobileAd(Long id, String make, String model, String description, Category category, BigDecimal price) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.description = description;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MobileAd [id=" + id + ", customerId=" + customerId + ", make=" + make + ", model=" + model
				+ ", description=" + description + ", category=" + category + ", price=" + price + "]";
	}


}
