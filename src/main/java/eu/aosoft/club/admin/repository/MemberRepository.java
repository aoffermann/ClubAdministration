package eu.aosoft.club.admin.repository;

import eu.aosoft.club.admin.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * Find a Memeber by Name and FirstName
     * @param name
     * @param firstName
     * @return
     */
    public Member findByNameAndFirstName(String name, String firstName);

}
