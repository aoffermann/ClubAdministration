/**
 * 
 */
package eu.aosoft.club.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Offermann Alexander
 *
 */
@Configuration
@EnableSwagger2
public class ClubAdminSwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("eu.aosoft.club.admin.controller"))
				.paths(paths()).build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("CLM")
				.description("Created by Offermann Alexander")
				.version("1.0")
				.termsOfServiceUrl("http://aosoft.be/")
				.build();
	}
	
	@SuppressWarnings("unchecked")
	private Predicate paths() {
		return or(
				regex("/user.*"));
	}
}
