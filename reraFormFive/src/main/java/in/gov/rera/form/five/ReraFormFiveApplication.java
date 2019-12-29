package in.gov.rera.form.five;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import in.gov.rera.form.five.security.AuthSecurity;

@SpringBootApplication
public class ReraFormFiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReraFormFiveApplication.class, args);
		System.out.println("Form Five Started");
	}	
	
	@Bean
	public FilterRegistrationBean<AuthSecurity> dawsonApiFilter() {
		FilterRegistrationBean<AuthSecurity> registration = new FilterRegistrationBean<AuthSecurity>();
		registration.setFilter(new AuthSecurity());
		registration.addUrlPatterns("/form_five/secure/*");
		return registration;
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
