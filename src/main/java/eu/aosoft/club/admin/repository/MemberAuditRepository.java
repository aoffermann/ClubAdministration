package eu.aosoft.club.admin.repository;

import eu.aosoft.club.admin.entity.Member;
import org.springframework.data.repository.history.RevisionRepository;

public interface MemberAuditRepository extends RevisionRepository<Member, Long, Integer> {
}
