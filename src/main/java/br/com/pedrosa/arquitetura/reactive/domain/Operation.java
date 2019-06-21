package br.com.pedrosa.arquitetura.reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
	private String id;
	private String name;
}
