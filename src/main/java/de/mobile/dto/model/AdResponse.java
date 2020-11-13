package de.mobile.dto.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import de.mobile.common.Category;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class AdResponse {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("make")
	private String make;

	@JsonProperty("model")
	private String model;

	@JsonProperty("description")
	private String description;

	@JsonProperty("category")
	private Category category;

	@JsonProperty("price")
	private BigDecimal price;

	@JsonProperty("customerId")
	private Long customerId;

	public AdResponse() {
		super();
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

	@Override
	public String toString() {
		return "AdResponse [id=" + id + ", make=" + make + ", model=" + model + ", description=" + description
				+ ", category=" + category + ", price=" + price + ", customerId=" + customerId + "]";
	}
}
