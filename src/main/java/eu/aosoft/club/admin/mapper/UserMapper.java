/**
 * 
 */
package eu.aosoft.club.admin.mapper;

import org.springframework.stereotype.Component;

import eu.aosoft.club.admin.dto.UserDto;
import eu.aosoft.club.admin.entity.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * @author Offermann Alexander
 *
 */
@Component
public class UserMapper extends ConfigurableMapper {

	protected void configure(MapperFactory factory) {
		
		factory.classMap(User.class, UserDto.class)
			.field("userId", "userId")
			.field("userName", "userName")
			.field("password", "password")
			.register();
		
	}
}