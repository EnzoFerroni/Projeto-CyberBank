package bank.cyber.CyberBank.Controller;
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.server.ResponseStatusException;

import bank.cyber.CyberBank.Entidades.Conta;
import bank.cyber.CyberBank.Entidades.Transacao;
import bank.cyber.CyberBank.Repositorio.ContaRepo;
import bank.cyber.CyberBank.Repositorio.TransacaoRepo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController {
	
	@Autowired
	private TransacaoRepo transacaoR;
	@Autowired
	private ContaRepo contaR;
	
	@PostMapping("/api/transacao")
	public Transacao create(@RequestBody Transacao newTransacao) {

				try {
					System.out.println("contat: " + newTransacao.getContaAtual());
					Optional<Conta> contAtual = contaR.findById(newTransacao.getContaAtual());
					System.out.println(contAtual.isPresent());
					System.out.println("CATUAL: " + contAtual.get().getSaldo());
					contAtual.get().setSaldo(contAtual.get().getSaldo() - newTransacao.getValor());
					Optional<Conta> contEnv = contaR.findById(newTransacao.getConta());
					contEnv.get().setSaldo(contEnv.get().getSaldo() + newTransacao.getValor());
					System.out.println("CAENV: " + contEnv.get().getSaldo());
					contaR.save(contAtual.get());
					contaR.save(contEnv.get());
					return transacaoR.save(newTransacao);
				} catch(Exception ex) {
					System.out.println(ex);
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao tentar registrar uma nova transação.", ex);
				}
	}
	
	@GetMapping("/api/transacao")
	public Iterable<Transacao> readAll() {
		return transacaoR.findAll();
	}
	
	@GetMapping("/api/transacao/{id}")
	public Transacao readById(@PathVariable long id) {
		try {
			Optional<Transacao> op = transacaoR.findById(id);
			if(op.isPresent()) {
				return op.get();
			}		
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro de busca.", ex);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
