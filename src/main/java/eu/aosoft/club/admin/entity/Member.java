package eu.aosoft.club.admin.entity;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author Offermann Alexander
 *
 * CREATE TABLE MEMBER (
 * 	   MEMBER_ID 		   BIGINT 				NOT NULL,
 *     NAME    			   VARCHAR2(255) 		NOT NULL,
 *     FIRST_NAME          VARCHAR2(255) 		NOT NULL,
 *     NATIONALITY         VARCHAR2(3)          NOT NULL,
 *     BIRTHDAY            DATE                 NOT NULL,
 *     PHONE               VARCHAR2(20)         ,
 *     MOBILE_PHONE        VARCHAR2(20)         ,
 *     MAIL                VARCHAR2(255) 		,
 *     ADDRESS_ID 		   BIGINT 				NOT NULL,
 *     PRIMARY KEY (MEMBER_ID)
 * );
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

    @Column(name = "NAME", nullable = false, length = 512)
    @NotNull
    private String name;

    @Column(name = "FIRST_NAME", nullable = false, length = 512)
    @NotNull
    private String firstName;

    @Column(name = "NATIONALITY", nullable = false, length = 3)
    @NotNull
    private String nationality;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "MOBILE_PHONE", length = 20)
    private String mobilePhone;

    @Column(name = "MAIL", length = 255)
    private String mail;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;
}
