package bank.cyber.CyberBank.Repositorio;
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

import org.springframework.data.repository.CrudRepository;

import bank.cyber.CyberBank.Entidades.Transacao;

public interface TransacaoRepo extends CrudRepository<Transacao, Long> {

}
