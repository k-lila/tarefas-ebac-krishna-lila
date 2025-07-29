package br.com.klila.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.klila.crud.domain.Client;
import br.com.klila.crud.repository.IClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final IClientRepository repository;

    public ClientController(IClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        Client clientToSave = repository.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientToSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> read(@PathVariable Long id) {
        Optional<Client> client = repository.findById(id);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(client.get());
        }
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Client> findByCpf(@PathVariable String cpf) {
        Optional<Client> client = repository.findByCpf(cpf);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(client.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client updated) {
        Optional<Client> client = repository.findById(id);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            client.get().setName(updated.getName());
            client.get().setCpf(updated.getCpf());
            client.get().setEmail(updated.getEmail());
            return ResponseEntity.ok(repository.save(client.get()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Client> toDelete = repository.findById(id);
        if (toDelete.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            repository.delete(toDelete.get());
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Client>> all() {
        List<Client> clients = repository.findAll();
        return ResponseEntity.ok(clients);
    }
}
