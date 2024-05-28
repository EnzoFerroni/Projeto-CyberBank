package bank.cyber.CyberBank.Repositorio;
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import bank.cyber.CyberBank.Entidades.Cartao;

public interface CartaoRepo extends CrudRepository<Cartao, Long> {
	
	Iterable<Cartao> findByTipoCartao(Optional<String> tipoCartao);
}
