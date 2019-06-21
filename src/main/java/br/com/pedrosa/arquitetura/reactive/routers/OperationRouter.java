package br.com.pedrosa.arquitetura.reactive.routers;

import br.com.pedrosa.arquitetura.reactive.handlers.OperationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class OperationRouter {

	@Bean
    public RouterFunction<ServerResponse> routes(OperationHandler operationHandler) {
        return route(GET("/operation"), operationHandler::all)
            .andRoute(POST("/operation"), operationHandler::save)
            .andRoute(PUT("/operation/{id}"), operationHandler::update)
            .andRoute(GET("/operation/{id}"), operationHandler::get)
            .andRoute(DELETE("/operation/{id}"), operationHandler::delete);
    }

}
