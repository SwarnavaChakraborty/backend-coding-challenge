package de.mobile.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.mobile.dto.entity.MobileCustomer;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@Repository
@Transactional
public interface CustomerRepository extends BaseRepository<MobileCustomer> {

	@Query("select f from MobileCustomer f where f.mobileCustomerId = :mobileCustomerId")
	MobileCustomer findById(@Param("mobileCustomerId") Long mobileCustomerId);

	@Modifying
	@Transactional
	@Query("delete from MobileCustomer f where f.mobileCustomerId = :mobileCustomerId")
	void delete(@Param("mobileCustomerId") Long mobileCustomerId);

}
