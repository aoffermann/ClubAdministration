/**
 * The UserService implementation
 */
package eu.aosoft.club.admin.service;

import eu.aosoft.club.admin.service.IF.UserIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.aosoft.club.admin.dto.UserDto;
import eu.aosoft.club.admin.entity.User;
import eu.aosoft.club.admin.mapper.UserMapper;
import eu.aosoft.club.admin.repository.UserRepository;

/**
 * @author Offermann Alexander
 *
 */
@Service
@Transactional
public class UserService implements UserIF {

	
	@Autowired
	private UserRepository userDataRepo;
	
	@Autowired
	private UserMapper userMapper;

	/* (non-Javadoc)
	 * @see eu.aosoft.club.admin.service.IF.UserIF#getByUserName(java.lang.String)
	 */
	@Override
	public UserDto getByUserName(String userName) {
		User userData = userDataRepo.findByUserName(userName);
		return userMapper.map(userData, UserDto.class);
	}

	/* (non-Javadoc)
	 * @see eu.aosoft.club.admin.service.IF.UserIF#saveUser(eu.aosoft.club.admin.dto.UserDto)
	 */
	@Override
	public UserDto saveUser(UserDto newUser) {
		User user = userMapper.map(newUser, User.class);
		User saveUser = userDataRepo.save(user);
		return userMapper.map(saveUser, UserDto.class);
	}

}
