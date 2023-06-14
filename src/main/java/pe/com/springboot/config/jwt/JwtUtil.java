package pe.com.springboot.config.jwt;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtil {

	@Autowired
	private RSAPrivateKey privateKey;

	@Autowired
	private RSAPublicKey publicKey;

	public String encode(String subject) {
		return JWT.create()
				.withSubject(subject)
				.withIssuedAt(new Date(System.currentTimeMillis()))
				.withExpiresAt(new Date(System.currentTimeMillis() + 600000))
				.sign(Algorithm.RSA256(publicKey, privateKey));
	}

}
