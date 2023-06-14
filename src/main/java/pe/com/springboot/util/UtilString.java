package pe.com.springboot.util;

import java.util.Base64;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Component;

@Component
public class UtilString {

	public String getUsernameFromToken(String header) {
		String token = header.substring(8);
		String[] chunks = token.split("\\.");

		Base64.Decoder decoder = Base64.getUrlDecoder();
		String payload = new String(decoder.decode(chunks[1]));

		Object obj = JSONValue.parse(payload);
		JSONObject jsonObject = (JSONObject) obj;

		String username = (String) jsonObject.get("sub");

		return username;
	}

}
