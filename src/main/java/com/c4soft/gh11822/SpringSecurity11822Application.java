package com.c4soft.gh11822;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringSecurity11822Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity11822Application.class, args);
	}

	public static class DemoAuthentication extends AbstractAuthenticationToken {
		private static final long serialVersionUID = 4329451423650715468L;

		@SuppressWarnings("unchecked")
		public DemoAuthentication(Map<String, Object> claims) {
			super(((Collection<String>) claims.getOrDefault("groups", List.of())).stream().map(SimpleGrantedAuthority::new).toList());
			super.setDetails(claims);
		}

		@Override
		public void setDetails(Object details) {
			throw new RuntimeException("DemoAuthentication details are immutable");
		}

		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> getDetails() {
			// Safe because of constructor and disabled setter
			return (Map<String, Object>) super.getDetails();
		}

		@Override
		public Map<String, Object> getCredentials() {
			return getDetails();
		}

		@Override
		public Map<String, Object> getPrincipal() {
			return getDetails();
		}
	}

	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	public static class WebSecurityConfig {

		public interface Jwt2AuthenticationConverter extends Converter<Jwt, DemoAuthentication> {
		}

		@Bean
		public Jwt2AuthenticationConverter authenticationConverter() {
			return jwt -> new DemoAuthentication(jwt.getClaims());
		}

		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http, Converter<Jwt, ? extends AbstractAuthenticationToken> authenticationConverter)
				throws Exception {

			http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(authenticationConverter);

			return http.build();
		}
	}

	@RestController
	public static class DemoController {
		@GetMapping("/demo/gh-11822")
		@PreAuthorize("isAuthenticated()")
		public String demoGh11822() {
			return "success";
		}
	}
}
