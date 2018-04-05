package eu.aosoft.club.admin.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import eu.aosoft.club.admin.entity.User;
import eu.aosoft.club.admin.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Before
	public void setUp() {
		userRepository.deleteAll();
	}
	
	@Test
	public void testFindByUserName() {
		
		// given
		User uD = new User();
		uD.setUserName("test-user");
		uD.setPassword("pwd123");
		entityManager.persist(uD);
		entityManager.flush();
		
		// when
		User found = userRepository.findByUserName(uD.getUserName());
	 
	    // then
	    assertThat(found.getUserName()).isEqualTo(uD.getUserName());		
	    assertThat(found.getPassword()).isEqualTo(uD.getPassword());
	    
	}

}
