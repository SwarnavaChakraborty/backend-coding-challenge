package de.mobile.service.impl;

import static org.springframework.beans.BeanUtils.copyProperties;
import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mobile.dto.entity.MobileAd;
import de.mobile.dto.model.AdRequest;
import de.mobile.dto.model.AdResponse;
import de.mobile.repository.AdRepository;
import de.mobile.service.IAdService;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */
@Service
public class AdServiceImpl implements IAdService {

	private static final Logger log = Logger.getLogger(AdServiceImpl.class.getName());

	@Autowired
	private AdRepository adRepository;

	@Override
	public void create(AdRequest adData) {

		MobileAd ad = new MobileAd();
		copyProperties(adData, ad);
		log.info("Object to save " + ad.toString());
		adRepository.save(ad);
	}

	@Override
	public AdResponse get(Long adId) {

		AdResponse adData = new AdResponse();
		MobileAd ad = adRepository.findByID(adId);
		if (!isEmpty(ad)) {
			log.info("The requested ad detail " + ad.toString());
			copyProperties(ad, adData);
		}
		return adData;
	}

	@Override
	public List<AdResponse> listAds() {

		List<AdResponse> ads = new ArrayList<>();
		adRepository.findAll().forEach(mad -> {
			AdResponse ad = new AdResponse();
			copyProperties(mad, ad);
			ads.add(ad);
		});
		log.info("The requested ads details " + ads.toString());
		return ads;
	}

	@Override
	public void remove(Long adId) {
		adRepository.deleteById(adId);
		log.info("Successfully Deleted id-" + adId);
	}

}
