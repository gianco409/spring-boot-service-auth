package pe.com.springboot.domain.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	String username;
	@NotNull
	String password;

}
