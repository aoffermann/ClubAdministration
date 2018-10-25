package eu.aosoft.club.admin.repository;

import eu.aosoft.club.admin.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     * Find a Memeber by Name and FirstName
     * @param name The name of the member
     * @param firstName The first name of the member
     * @return Returning a Member Object
     */
    public Optional<Member> findByNameAndFirstName(String name, String firstName);

}
