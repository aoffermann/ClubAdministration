package eu.aosoft.club.admin.service.IF;

import eu.aosoft.club.admin.dto.MemberDto;

/**
 * @author Offermann Alexander
 *
 */
public interface MemberIF {

    public MemberDto getByMemberNameAndFirstName(String name, String firstName) throws IllegalArgumentException;

    public MemberDto saveMember(MemberDto newMember);

}
