package de.mobile.controller;

import static de.mobile.common.validation.RequestValidator.isValidAdRequest;
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

import de.mobile.dto.model.AdRequest;
import de.mobile.dto.model.AdResponse;
import de.mobile.service.IAdService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */
@RestController
@RequestMapping("/ads")
public class AdResource {

	private static final Logger log = Logger.getLogger(AdResource.class.getName());
	
	@Autowired
	private IAdService adService;

	@ApiOperation(value = "Ad detail", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully get the ad detail"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<AdResponse> get(@Valid @NotNull @PathVariable("id") Long adId) {
		
		try {
			log.info("Received GET request for id {}" + adId);
			return new ResponseEntity<>(adService.get(adId), OK);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "All Ad details", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully get all ad details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<AdResponse>> getAll() {
		
		try {
			return new ResponseEntity<>(adService.listAds(), OK);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Create an Ad details", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created an ad details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> create(@Valid @NotNull @RequestBody AdRequest adData) {

		try {
			if (!isValidAdRequest(adData)) {
				return new ResponseEntity<>(BAD_REQUEST);
			}
			adService.create(adData);
			return new ResponseEntity<>(CREATED);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Removed an Ad details", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully removed an ad details"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<?> remove(@Valid @NotNull @PathVariable("id") Long adId) {
		
		try {
			log.info("Received DELETE request for id {}" + adId);
			adService.remove(adId);
			return new ResponseEntity<>(NO_CONTENT);
		} catch (Exception e) {
			e.getMessage();
			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
	}

}
