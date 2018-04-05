/**
 * 
 */
package eu.aosoft.club.admin.repository;

import org.springframework.data.repository.history.RevisionRepository;

import eu.aosoft.club.admin.entity.User;

/**
 * @author Offermann Alexander
 *
 */
public interface UserAuditRepository extends RevisionRepository<User, Long, Integer> {

}
