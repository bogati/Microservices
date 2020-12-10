package com.jump;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class JumpJetAutoApiGatewayApplication {
	
	 @Bean
	 public FilterRegistrationBean corsFilter() {
	     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	     CorsConfiguration config = new CorsConfiguration();
	     config.setAllowCredentials(true);
	     config.addAllowedOrigin("*");
	     config.addAllowedHeader("*");
	     config.addAllowedMethod("*");
	     source.registerCorsConfiguration("/**", config);
	     FilterRegistrationBean bean = new FilterRegistrationBean(new org.springframework.web.filter.CorsFilter(source));
	     bean.setOrder(0);
	     return bean;
	 }

	public static void main(String[] args) {
		SpringApplication.run(JumpJetAutoApiGatewayApplication.class, args);
	}

}
//reference for the code
//https://stackoverflow.com/questions/35745938/netflix-zuul-cors
//after adding the code mentioned above from stackoverflow , add 
//zuul.ignored-headers: Access-Control-Allow-Credentials, Access-Control-Allow-Origin in yml file 