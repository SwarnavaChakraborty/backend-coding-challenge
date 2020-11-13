package de.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Integer> {

}
