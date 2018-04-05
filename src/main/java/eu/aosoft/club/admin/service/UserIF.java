/**
 * 
 */
package eu.aosoft.club.admin.service;

import eu.aosoft.club.admin.dto.UserDto;

/**
 * @author Offermann Alexander
 *
 */
public interface UserIF {

	public UserDto getByUserName(String userName);
	
	public UserDto saveUser(UserDto newUser);
	
}
