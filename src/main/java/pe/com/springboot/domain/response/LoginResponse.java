package pe.com.springboot.domain.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import pe.com.springboot.domain.dto.TokenDto;

@Getter
@Setter
public class LoginResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	String username;
	TokenDto token;
}
