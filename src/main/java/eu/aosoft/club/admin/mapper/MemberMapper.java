package eu.aosoft.club.admin.mapper;

import eu.aosoft.club.admin.dto.MemberDto;
import eu.aosoft.club.admin.entity.Member;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * @author Offermann Alexander
 *
 */
@Component
public class MemberMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {

        factory.classMap(Member.class, MemberDto.class)
                .field("memberId", "memberId")
                .field("name", "name")
                .field("firstName", "firstName")
                .field("nationality", "nationality")
                .field("birthday", "birthday")
                .field("phone", "phone")
                .field("mobilePhone", "mobilePhone")
                .field("mail", "mail")
                .field("address", "addressDto")
                .byDefault()
                .register();

    }
}
