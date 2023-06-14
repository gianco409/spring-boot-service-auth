package pe.com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http
	    		//.cors()
	    		//.and()
	            .csrf(csrf -> csrf.disable())
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .authorizeHttpRequests()
	            //.requestMatchers("/login")
	            .requestMatchers("/login", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html")
	            .anonymous()
	            //.permitAll()
	            .anyRequest()
	            .authenticated()
	            .and()
	            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
	            .build();
		
//		http.csrf()
//        .disable()
//        .authorizeHttpRequests()
//        .requestMatchers("/login", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html")
//        .permitAll()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        //.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//        .and()
//        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//        //.authenticationProvider(authenticationProvider)
//        //.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//        //.logout()
//        //.logoutUrl("/api/v1/auth/logout")
//        //.addLogoutHandler(logoutHandler)
//        //.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
//
//		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetails() {
		return new InMemoryUserDetailsManager(
				User.withUsername("usergian")
					.passwordEncoder(passwordEncoder::encode)
					.password("password")
					.authorities("read")
					.build(),
				User.withUsername("usermarco")
					.passwordEncoder(passwordEncoder::encode)
					.password("password")
					.authorities("read")
					.build());
	}

}
