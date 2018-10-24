package eu.aosoft.club.admin.service;

import eu.aosoft.club.admin.dto.MemberDto;

/**
 * @author Offermann Alexander
 *
 */
public interface MemberIF {

    public MemberDto getByMemberNameAndFirstName(String name, String firstName);

    public MemberDto saveMember(MemberDto newMember);

}
