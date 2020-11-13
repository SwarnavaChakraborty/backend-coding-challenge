package de.mobile.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.mobile.dto.entity.MobileAd;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@Repository
@Transactional
public interface AdRepository extends BaseRepository<MobileAd> {

	@Query("select f from MobileAd f where f.id = :id")
	MobileAd findByID(@Param("id") Long id);

	@Modifying
	@Transactional
	@Query("delete from MobileAd f where f.id = :id")
	void deleteById(@Param("id") Long id);

}
