package br.com.pedrosa.arquitetura.reactive;

import br.com.pedrosa.arquitetura.reactive.domain.Operation;
import br.com.pedrosa.arquitetura.reactive.repository.OperationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;


@WebFluxTest
@RunWith(SpringRunner.class)
public class OperationHttpTest {

    @MockBean
    private OperationRepository operacaoRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getlAllOperations(){

        Mockito.when(this.operacaoRepository.findAll())
            .thenReturn(Flux.just(new Operation(null,"Reactive")));

        this.webTestClient
            .get()
            .uri("/operation")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
            .expectBody().jsonPath("@.[0].name").isEqualTo("Reactive");

    }
}