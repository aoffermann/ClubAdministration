/**
 * 
 */
package eu.aosoft.club.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.aosoft.club.admin.entity.User;

/**
 * @author Offermann Alexander
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find a User by userName 
	 * @param userName
	 * @return UserData
	 */
	public User findByUserName(String userName);
	
}
