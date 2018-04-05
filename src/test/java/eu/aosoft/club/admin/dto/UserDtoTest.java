/**
 * 
 */
package eu.aosoft.club.admin.dto;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import eu.aosoft.club.admin.dto.UserDto;

/**
 * @author Offermann Alexander
 *
 */
public class UserDtoTest {

	@Test
	public void testUserDto() {
		assertThat(UserDto.class, allOf(
				hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
	}

	// Individual, well named tests
    @Test
    public void shouldHaveANoArgsConstructor() {
        assertThat(UserDto.class, hasValidBeanConstructor());
    }

    @Test
    public void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(UserDto.class, hasValidGettersAndSetters());
    }

    @Test
    public void allPropertiesShouldInfluenceHashCode() {
        assertThat(UserDto.class, hasValidBeanHashCode());
    }

    @Test
    public void allPropertiesShouldBeComparedDuringEquals() {
        assertThat(UserDto.class, hasValidBeanEquals());
    }

    @Test
    public void allPropertiesShouldBeRepresentedInToStringOutput() {
    	assertThat(UserDto.class, hasValidBeanToString());
    }
}
