package br.com.klila.crud;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import br.com.klila.crud.domain.Client;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerIntegrationTest {

    @org.springframework.boot.test.web.server.LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private Client generateClient(String cpf) {
        Client client = new Client();        
        client.setName("Teste Nome" + cpf);
        client.setEmail(cpf + "test@mail.com");
        client.setCpf(cpf);
        return client;
        }

    private HttpEntity<Client> generateRequest(Client client) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Client> request = new HttpEntity<>(client, headers);
        return request;
    }

    @AfterEach
    void cleanUp() {
        ResponseEntity<Client[]> responseAll = testRestTemplate.getForEntity(
            "http://localhost:" + port + "/clients",
            Client[].class
        );
        List<Client> clients = new ArrayList<>(List.of(responseAll.getBody()));
        for (Client client : clients) {
            testRestTemplate.exchange(
                "http://localhost:" + port + "/clients/"+ client.getId(),
                HttpMethod.DELETE,
                null,
                Void.class
            );
        }
    }

    @Test
    void createTest() {
        Client clientA = generateClient("test1");
        ResponseEntity<Client> responseTest = testRestTemplate.postForEntity(
                "http://localhost:" + port + "/clients",
                generateRequest(generateClient("test1")),
                Client.class
        );
        Client clientCreated = responseTest.getBody();
        assertThat(responseTest.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(clientCreated).isNotNull();
        assertThat(clientCreated.getId()).isNotNull();
    }

    @Test
    void readTest() {
        Client clientB = generateClient("test2");
        ResponseEntity<Client> responseTest = testRestTemplate.postForEntity(
            "http://localhost:" + port + "/clients",
            generateRequest(clientB),
            Client.class);
        assertThat(responseTest.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        ResponseEntity<Client> responseGetTest = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/clients/"+ responseTest.getBody().getId(),
                Client.class
        );
        assertThat(responseGetTest.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseGetTest.getBody()).isNotNull();
        assertThat(responseGetTest.getBody().getCpf()).isEqualTo("test2");
    }

    @Test
    void findByCpfTest() {
        String cpf = "procurando";
        ResponseEntity<Client> clientTestResponse = testRestTemplate.postForEntity(
            "http://localhost:" + port + "/clients",
            generateRequest(generateClient(cpf)),
            Client.class
        );
        assertThat(clientTestResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        ResponseEntity<Client> clientByCPF = testRestTemplate.getForEntity(
            "http://localhost:" + port + "/clients/cpf/" + clientTestResponse.getBody().getCpf(),
            Client.class
        );
        assertThat(clientByCPF.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(clientByCPF.getBody()).isNotNull();
        assertThat(clientByCPF.getBody().getCpf()).isEqualTo(cpf);
    }

    @Test
    void updateTest() {
        Client clientC = generateClient("test3");
        ResponseEntity<Client> responseTest = testRestTemplate.postForEntity(
            "http://localhost:" + port + "/clients",
            generateRequest(clientC),
            Client.class);
        assertThat(responseTest.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Client clientToUpdate = responseTest.getBody();
        clientToUpdate.setName("Modificado");
        ResponseEntity<Client> updateResponseTest = testRestTemplate.exchange(
            "http://localhost:" + port + "/clients/" + clientToUpdate.getId(),
            HttpMethod.PUT,
            generateRequest(clientToUpdate),
            Client.class
        );
        assertThat(updateResponseTest.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(updateResponseTest.getBody().getName()).isEqualTo("Modificado");
    }

    @Test
    void deleteTest() {
        Client clientD = generateClient("test4");
        ResponseEntity<Client> responseTest = testRestTemplate.postForEntity(
            "http://localhost:" + port + "/clients",
            generateRequest(clientD),
            Client.class);
        assertThat(responseTest.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        ResponseEntity<Void> responseDeleteTest = testRestTemplate.exchange(
                "http://localhost:" + port + "/clients/"+ responseTest.getBody().getId(),
                HttpMethod.DELETE,
                null,
                Void.class
        );
        assertThat(responseDeleteTest.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    void allTest() {
        for (int i = 0; i < 5; i++) {
            testRestTemplate.postForEntity(
                "http://localhost:" + port + "/clients",
                generateRequest(generateClient(String.format("teste" + String.valueOf(i), i))),
                Client.class);
        }
        ResponseEntity<Client[]> responseTestAll = testRestTemplate.getForEntity(
            "http://localhost:" + port + "/clients",
            Client[].class
        );
        assertThat(responseTestAll.getStatusCode()).isEqualTo(HttpStatus.OK);
        Client[] clients = responseTestAll.getBody();
        assertThat(clients).isNotNull();
        assertThat(clients.length).isGreaterThanOrEqualTo(5);
    }
}