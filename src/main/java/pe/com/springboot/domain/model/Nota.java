package pe.com.springboot.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Schema(name = "titulo", example = "El Titulo de la nota")
	private String titulo;

	@Schema(name = "mensaje", example = "Esto es el cuerpo del mensaje")
	private String mensaje;

	@JsonIgnore
	@Schema(name = "usuario", example = "usuario@ejemplo.com")
	private String usuario;

	@CreatedDate
	private LocalDateTime createdAt;

}
