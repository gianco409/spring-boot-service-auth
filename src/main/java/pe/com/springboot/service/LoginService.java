package pe.com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import pe.com.springboot.config.jwt.JwtUtil;
import pe.com.springboot.domain.dto.TokenDto;
import pe.com.springboot.domain.request.LoginRequest;
import pe.com.springboot.domain.response.LoginResponse;

@Component
public class LoginService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsManager userDetails;

	@Autowired
	private JwtUtil jwtUtil;

	public LoginResponse login(LoginRequest request) {
		LoginResponse response = new LoginResponse();
		try {
			UserDetails userDetails = this.userDetails.loadUserByUsername(request.getUsername());

			if (this.passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
				response.setUsername(request.getUsername());
				response.setToken(new TokenDto(this.jwtUtil.encode(userDetails.getUsername())));
				return response;
			} else {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o password incorrecto");
			}

		} catch (UsernameNotFoundException unnfe) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o password incorrecto");
		}
	}

}
