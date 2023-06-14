//package pe.com.springboot;
//
//import java.util.List;
//
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//import pe.com.springboot.entities.Usuario;
//import pe.com.springboot.service.UsuarioService;
//
//@Component
//public class DatabaseInitializer implements ApplicationListener<ApplicationReadyEvent> {
//
//	private final List<String> usernames = List.of("gian@test.com", "marcos@test.com");
//	private final List<String> roles = List.of("admin", "admin");
//	private final String password = "12345678";
//
//	private final UsuarioService usuarioService;
//
//	public DatabaseInitializer(UsuarioService usuarioService) {
//		this.usuarioService = usuarioService;
//	}
//
//	@Override
//	public void onApplicationEvent(ApplicationReadyEvent event) {
//		for (var i = 0; i < usernames.size(); ++i) {
//			var request = new Usuario(usernames.get(i), password);
//
//			usuarioService.save(request);
//		}
//	}
//
//}
