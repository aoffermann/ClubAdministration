package eu.aosoft.club.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;

/**
 * @author Offermann Alexander
 */
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class MemberDto {

    @ApiModelProperty(notes = "The database generated member ID")
    private Long memberId;

    @ApiModelProperty(notes = "The name of the Member")
    private String name;

    @ApiModelProperty(notes = "The firstname of the Member")
    private String firstName;

    @ApiModelProperty(notes = "The nationality of the Member")
    private String nationality;

    @ApiModelProperty(notes = "The birthday of the Member")
    private LocalDate birthday;

    @ApiModelProperty(notes = "The phone of the Member")
    private String phone;

    @ApiModelProperty(notes = "The mobilePhone of the Member")
    private String mobilePhone;

    @ApiModelProperty(notes = "The mail of the Member")
    private String mail;

    @ApiModelProperty(notes = "The address of the Member")
    private AddressDto addressDto;
}
