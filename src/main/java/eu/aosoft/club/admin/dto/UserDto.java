/**
 * 
 */
package eu.aosoft.club.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class UserDto {

	@ApiModelProperty(notes = "The database generated user ID")
	private Long userId;
	@ApiModelProperty(notes = "The user name of the user")
	private String userName;
	@ApiModelProperty(notes = "The password of the user")
	private String password;
	
}
