package br.com.klila.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.klila.crud.domain.Client;

public interface IClientRepository extends JpaRepository<Client, Long>{
    public Optional<Client> findByCpf(String cpf);
}
