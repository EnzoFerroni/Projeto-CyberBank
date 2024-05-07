package bank.cyber.CyberBank.Repositorio;
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import bank.cyber.CyberBank.Entidades.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, Long> {
	
	Iterable<Cliente> findByNome(Optional<String> nome);
}
