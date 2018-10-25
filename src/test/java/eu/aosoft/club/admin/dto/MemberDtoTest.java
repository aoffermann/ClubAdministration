package eu.aosoft.club.admin.dto;

import org.junit.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertThat;

/**
 * @author Offermann Alexander
 *
 */
public class MemberDtoTest {

    @Test
    public void testMemberDto() {
        assertThat(MemberDto.class, allOf(
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
        assertThat(MemberDto.class, hasValidBeanConstructor());
    }

    @Test
    public void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(MemberDto.class, hasValidGettersAndSetters());
    }

    @Test
    public void allPropertiesShouldInfluenceHashCode() {
        assertThat(MemberDto.class, hasValidBeanHashCode());
    }

    @Test
    public void allPropertiesShouldBeComparedDuringEquals() {
        assertThat(MemberDto.class, hasValidBeanEquals());
    }

    @Test
    public void allPropertiesShouldBeRepresentedInToStringOutput() {
        assertThat(MemberDto.class, hasValidBeanToString());
    }
}
