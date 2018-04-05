/**
 * 
 */
package eu.aosoft.club.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Offermann Alexander
 * 
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class ClubAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubAdminApplication.class, args);
	}
}
