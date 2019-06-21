package br.com.pedrosa.arquitetura.reactive.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorResponse {
	private String fieldName;
	private String errorMessage;
}
