package eu.aosoft.club.admin.repository;

import eu.aosoft.club.admin.entity.Address;
import org.springframework.data.repository.history.RevisionRepository;

public interface AddressAuditRepository extends RevisionRepository<Address, Long, Integer> {
}
