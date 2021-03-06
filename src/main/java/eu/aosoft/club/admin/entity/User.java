package eu.aosoft.club.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import lombok.Data;

/**
 * @author Offermann Alexander
 *
 * CREATE TABLE USER (
 * 	   USER_ID 				BIGINT 				NOT NULL,
 *     USER_NAME 			VARCHAR2(255) 		NOT NULL,
 *     PASSWORD				VARCHAR2(255)		NOT NULL,
 *     PRIMARY KEY (USER_ID)
 * );
 *
 */
@Entity
@Table(name = "USER")
@Data
@Audited
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	@SequenceGenerator(name = "user_generator", sequenceName = "user_seq", allocationSize = 1)
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "USER_NAME", nullable = false, length = 512)
	@NotNull
	private String userName;

	@Column(name = "PASSWORD", nullable = false, length = 512)
	@NotNull
	private String password;
	
}
