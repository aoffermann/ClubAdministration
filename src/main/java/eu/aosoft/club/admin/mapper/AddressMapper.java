package eu.aosoft.club.admin.mapper;

import eu.aosoft.club.admin.dto.AddressDto;
import eu.aosoft.club.admin.entity.Address;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * @author Offermann Alexander
 *
 */
@Component
public class AddressMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {

        factory.classMap(Address.class, AddressDto.class)
                .field("addressId", "addressId")
                .field("street", "street")
                .field("postcode", "postcode")
                .field("location", "location")
                .field("country", "country")
                .byDefault()
                .register();

    }

}
