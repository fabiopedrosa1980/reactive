package br.com.pedrosa.arquitetura.reactive;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.function.server.RouterFunction;

import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveApplicationConfiguration  {
	
	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplicationConfiguration.class, args);
	}
	
	@Bean
    public RouterFunction<ServerResponse> routes(OperacaoHandler operacaoHandler) {
        return route(GET("/operacoes"), operacaoHandler::all)
            .andRoute(POST("/operacoes"), operacaoHandler::create)
            .andRoute(GET("/operacoes/{id}"), operacaoHandler::get)
            .andRoute(DELETE("/operacoes/{id}"), operacaoHandler::delete);
    }

	
}