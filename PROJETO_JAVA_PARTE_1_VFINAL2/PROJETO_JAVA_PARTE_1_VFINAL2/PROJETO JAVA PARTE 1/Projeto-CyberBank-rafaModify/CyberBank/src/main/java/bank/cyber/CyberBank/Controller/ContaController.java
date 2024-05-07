package bank.cyber.CyberBank.Controller;

//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import bank.cyber.CyberBank.Entidades.Conta;
import bank.cyber.CyberBank.Repositorio.ContaRepo;

@RestController
public class ContaController {
	
	@Autowired
	private ContaRepo contas;
	
	
	@PostMapping("/api/conta")
	public Conta create(@RequestBody Conta newConta) {
		try{
			return contas.save(newConta);
			
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro na criação da conta", e);
		}
	}

	@GetMapping("/api/conta")
	public Iterable<Conta> readAll(@RequestParam Optional<Integer> agencia) {
		if(agencia.isEmpty()) {
			return contas.findAll();
		} 
		
		return contas.findByAgencia(agencia);
	}

	
	@GetMapping("/api/conta/{id}")
	public Conta readById(@PathVariable long id) {
		try {
			Optional<Conta> op = contas.findById(id);
			
			if(op.isPresent()) {
				return op.get();
			}		
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Problema ao encontrar conta", e);
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/api/conta/{id}")
	public Conta update(@RequestBody Conta contaUpdate, @PathVariable long id) {
		try {
			Optional<Conta> op = contas.findById(id);
			
			if(op.isPresent()) {
				Conta p = op.get();
				int senha = contaUpdate.getSenha();
				p.setSenha(senha);
				
				
				contas.save(p);
				return p;
			}		
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Problema ao encontrar conta", e);
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value="/api/conta/{id}", produces = "application/json")
	public Conta delete(@PathVariable long id) {
		try {
			Optional<Conta> op = contas.findById(id);
			
			if(op.isPresent()) {
				contas.deleteById(id);
				return op.get();
			}		
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao encontrar", ex);
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
