package de.mobile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.mobile.dto.model.AdRequest;
import de.mobile.dto.model.AdResponse;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */
@Service
public interface IAdService {

	void create(AdRequest adData);

	AdResponse get(Long adId);

	List<AdResponse> listAds();

	void remove(Long adId);

}