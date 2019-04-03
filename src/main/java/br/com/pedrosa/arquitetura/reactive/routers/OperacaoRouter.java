package br.com.pedrosa.arquitetura.reactive.routers;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.pedrosa.arquitetura.reactive.handlers.OperacaoHandler;

@Configuration
public class OperacaoRouter {
	
	@Bean
    public RouterFunction<ServerResponse> routes(OperacaoHandler operacaoHandler) {
        return route(GET("/operacao"), operacaoHandler::all)
            .andRoute(POST("/operacao"), operacaoHandler::save)
            .andRoute(PUT("/operacao/{id}"), operacaoHandler::update)
            .andRoute(GET("/operacao/{id}"), operacaoHandler::get)
            .andRoute(DELETE("/operacao/{id}"), operacaoHandler::delete);
    }
}
