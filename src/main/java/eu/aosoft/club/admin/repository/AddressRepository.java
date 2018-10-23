package eu.aosoft.club.admin.repository;

import eu.aosoft.club.admin.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Offermann Alexander
 *
 */
public interface AddressRepository  extends JpaRepository<Address, Long> {
}
