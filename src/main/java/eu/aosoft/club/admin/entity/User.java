/**
 * 
 */
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
 */
@Entity
@Table(name = "USER_DATA")
@Data
@Audited
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_data_generator")
	@SequenceGenerator(name = "user_data_generator", sequenceName = "user_data_seq", allocationSize = 1)
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "USER_NAME", nullable = false, length = 512)
	@NotNull
	private String userName;

	@Column(name = "PASSWORD", nullable = false, length = 512)
	@NotNull
	private String password;
	
}
