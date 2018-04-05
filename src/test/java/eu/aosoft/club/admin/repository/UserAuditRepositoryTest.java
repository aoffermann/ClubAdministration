/**
 * 
 */
package eu.aosoft.club.admin.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.history.Revision;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eu.aosoft.club.admin.entity.User;
import eu.aosoft.club.admin.repository.UserAuditRepository;
import eu.aosoft.club.admin.repository.UserRepository;

/**
 * @author Offermann Alexander
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserAuditRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserAuditRepository userAuditRepository;

	@Before
	public void setUp() {
		userRepository.deleteAll();
	}

	@Test
	public void testFindLastUserChanges() {

		// given
		User user = new User();
		user.setUserName("test-user");
		user.setPassword("pwd123");

		User savedUser = userRepository.saveAndFlush(user);

		// when
		Optional<Revision<Integer, User>> lastChangeRevision = userAuditRepository
				.findLastChangeRevision(savedUser.getUserId());

		// then
		assertNotNull(lastChangeRevision);
		
	}

}
