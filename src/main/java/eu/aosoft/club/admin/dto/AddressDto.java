package eu.aosoft.club.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Offermann Alexander
 *
 */
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class AddressDto {

    @ApiModelProperty(notes = "The database generated address ID")
    private Long addressId;

    @ApiModelProperty(notes = "The Street and number of the Address")
    private String street;

    @ApiModelProperty(notes = "The postcode of the Address")
    private String postcode;

    @ApiModelProperty(notes = "The location of the Address")
    private String location;

    @ApiModelProperty(notes = "The country of the Address")
    private String country;

}
