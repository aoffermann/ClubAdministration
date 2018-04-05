/**
 * 
 */
package eu.aosoft.club.admin.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import eu.aosoft.club.admin.dto.UserDto;
import eu.aosoft.club.admin.entity.User;
import eu.aosoft.club.admin.mapper.UserMapper;
import eu.aosoft.club.admin.repository.UserRepository;
import eu.aosoft.club.admin.service.UserService;

/**
 * @author Offermann Alexander
 *
 */
@RunWith(SpringRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository userDataRepoMock;

	@Mock
	private UserMapper userMapperMock;

	@InjectMocks
	private UserService userServiceMock;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getByUserNameSuccessfuly() throws Exception {

		User user = new User();
		user.setUserName("aoffermann");
		user.setPassword("pwd123");

		UserDto userDto = UserDto.builder().userName("aoffermann").password("pwd123").build();

		when(userDataRepoMock.findByUserName("aoffermann")).thenReturn(user);
		when(userMapperMock.map(user, UserDto.class)).thenReturn(userDto);

		UserDto newUserDto = userServiceMock.getByUserName("aoffermann");
		assertEquals(user.getUserName(), newUserDto.getUserName());
		assertEquals(user.getPassword(), newUserDto.getPassword());

		verify(userDataRepoMock, times(1)).findByUserName("aoffermann");
		verify(userMapperMock, times(1)).map(user, UserDto.class);

	}

	@Test
	public void saveUserTest() throws Exception {

		UserDto userDto = UserDto.builder().userName("aoffermann").password("pwd123").build();

		User user = new User();
		user.setUserName("aoffermann");
		user.setPassword("pwd123");

		when(userMapperMock.map(userDto, User.class)).thenReturn(user);
		when(userDataRepoMock.save(user)).thenReturn(user);

		userServiceMock.saveUser(userDto);

		verify(userDataRepoMock, times(1)).save(user);
		verify(userMapperMock, times(1)).map(userDto, User.class);
	}
}
