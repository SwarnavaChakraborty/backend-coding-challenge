package de.mobile.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static de.mobile.common.validation.RequestValidator.*;
import de.mobile.dto.model.CustomerRequest;
import de.mobile.dto.model.CustomerResponse;
import de.mobile.service.ICustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerResource {

	private static final Logger log = Logger.getLogger(CustomerResource.class.getName());

	@Autowired
	private ICustomerService customerService;

	@ApiOperation(value = "Customer detail", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully get the Customer detail"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> get(@Valid @NotNull @PathVariable("id") Long id) {

		try {
			log.info("Received GET request for id {}" + id);
			return new ResponseEntity<>(customerService.get(id), OK);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "All Customer details", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully get all Customer details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<CustomerResponse>> getAll() {

		try {
			return new ResponseEntity<>(customerService.listCustomers(), OK);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Create a Customer details", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created a Customer details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> create(@Valid @NotNull @RequestBody CustomerRequest customer) {

		try {
			if (!isValidCustomerRequest(customer)) {
				return new ResponseEntity<>(BAD_REQUEST);
			}
			customerService.create(customer);
			return new ResponseEntity<>(CREATED);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Removed an Customer details", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully removed an Customer details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> remove(@Valid @NotNull @PathVariable("id") Long id) {

		try {
			log.info("Received DELETE request for id {}" + id);
			customerService.remove(id);
			return new ResponseEntity<>(NO_CONTENT);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
	}
}
