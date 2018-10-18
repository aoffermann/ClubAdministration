package eu.aosoft.club.admin.entity;

import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Offermann Alexander
 *
 */
@Entity
@Table(name = "MEMBER")
@Data
@Audited
public class Member {
}
