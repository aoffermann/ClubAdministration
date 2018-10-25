package eu.aosoft.club.admin.service;

import eu.aosoft.club.admin.dto.MemberDto;
import eu.aosoft.club.admin.entity.Member;
import eu.aosoft.club.admin.mapper.MemberMapper;
import eu.aosoft.club.admin.repository.MemberRepository;
import eu.aosoft.club.admin.service.IF.MemberIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public MemberDto getByMemberNameAndFirstName(String name, String firstName) throws IllegalArgumentException {
        Member member = memberRepository.findByNameAndFirstName(name, firstName).orElseThrow(() -> new IllegalArgumentException("Not found"));
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
