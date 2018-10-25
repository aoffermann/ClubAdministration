package eu.aosoft.club.admin.controller;

import eu.aosoft.club.admin.dto.MemberDto;
import eu.aosoft.club.admin.service.IF.MemberIF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Offermann Alexander
 */
@RestController
@RequestMapping("/member")
@Api(value = "member administration", description = "Operations for the member administration")
public class MemberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberIF memberService;

    @ApiOperation(value = "Get member by name and firstname")
    @RequestMapping(value = "/{name}/{firstName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
            @ApiResponse(code = 204, message = "Member not found")
    })
    public ResponseEntity<?> getMemberByNameAndFirstName(@PathVariable("name") String name, @PathVariable("firstName") String firstName) {
        try {
            MemberDto memberDto = memberService.getByMemberNameAndFirstName(name, firstName);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(memberDto.toString());
            }
            return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(String.format("Member with name %s and firstname %s not found", name, firstName), HttpStatus.NO_CONTENT);
        }


    }
}
