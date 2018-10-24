package eu.aosoft.club.admin.service;

import eu.aosoft.club.admin.dto.MemberDto;
import eu.aosoft.club.admin.entity.Member;
import eu.aosoft.club.admin.mapper.MemberMapper;
import eu.aosoft.club.admin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Offermann Alexander
 *
 */
@Service
@Transactional
public class MemberService implements MemberIF {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    /**
     *
     * @param name
     * @param firstName
     * @return
     */
    @Override
    public MemberDto getByMemberNameAndFirstName(String name, String firstName) {
        Member member = memberRepository.findByNameAndFirstName(name, firstName);
        return memberMapper.map(member, MemberDto.class);
    }

    /**
     *
     * @param newMember
     * @return
     */
    @Override
    public MemberDto saveMember(MemberDto newMember) {
        return null;
    }
}
