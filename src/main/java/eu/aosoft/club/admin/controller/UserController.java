/**
 * 
 */
package eu.aosoft.club.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.aosoft.club.admin.dto.UserDto;
import eu.aosoft.club.admin.service.UserIF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Offermann Alexander
 *
 */
@RestController
@RequestMapping("/user")
@Api(value="user administration", description="Operations for the user administration")
public class UserController {

		
		private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

		@Autowired
		private UserIF userService;
		
		@ApiOperation(value="Get user by username")
		@RequestMapping(value = "/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
				@ApiResponse(code = 204, message = "User not found")
		})
		public ResponseEntity<?> getUserByUserName(@PathVariable("userName") String userName) {
			UserDto userDto = userService.getByUserName(userName);
			if(userDto != null) {
				if(LOGGER.isDebugEnabled()) {
					LOGGER.debug(userDto.toString());
				}
				return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("User not found", HttpStatus.NO_CONTENT);
			}
		}

		@ApiOperation(value="Add a new user")
		@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Success", response = UserDto.class)
		})
		public ResponseEntity<?> saveUser(@RequestBody UserDto newUser){
			UserDto saveUser = userService.saveUser(newUser);
			return new ResponseEntity<UserDto>(saveUser, HttpStatus.OK);
		}

}
