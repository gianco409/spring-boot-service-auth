package pe.com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import pe.com.springboot.domain.request.LoginRequest;
import pe.com.springboot.domain.response.LoginResponse;
import pe.com.springboot.service.LoginService;

@Tag(name = "Login API", description = "Api de gestion de Autorizacion")
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

		LoginResponse response = loginService.login(request);

		return ResponseEntity.ok().body(response);
	}

}
