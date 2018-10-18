package eu.aosoft.club.admin.entity;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

/**
 * @author Offermann Alexander
 *
 */
@Entity
@Table(name = "MEMBER")
@Data
@Audited
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_generator")
    @SequenceGenerator(name = "member_generator", sequenceName = "member_seq", allocationSize = 1)
    @Column(name = "MEMBER_ID")
    private Long memberId;
}
