package bank.cyber.CyberBank.Controller;
//Enzo Ferroni - RA: 10417100
//Leonardo Rodrigues - RA: 10418105
//Rafael Neves - RA: 10418316

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import bank.cyber.CyberBank.Entidades.Cliente;
import bank.cyber.CyberBank.Repositorio.ClienteRepo;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepo clienteR;
	
	@PostMapping("/api/cliente")
	public Cliente create(@RequestBody Cliente newCliente) {
				try {
					return clienteR.save(newCliente);
				} catch(Exception ex) {
					System.out.println(ex);
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao tentar registrar um novo cliente", ex);
				}
	}
	
	@GetMapping("/api/cliente")
	public Iterable<Cliente> readAll() {
		return clienteR.findAll();
	}
	
	@GetMapping("/api/cliente/{cpf}")
	public Cliente readById(@PathVariable long cpf) {
		try {
			Optional<Cliente> op = clienteR.findById(cpf);
			if(op.isPresent()) {
				return op.get();
			}		
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro de busca.", ex);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/api/cliente/{cpf}")
	public Cliente update(@RequestBody Cliente cUpdate, @PathVariable long cpf) {
		try {
			Optional<Cliente> op = clienteR.findById(cpf);
			
			if(op.isPresent()) {
				Cliente c = op.get();
				
				String nome = cUpdate.getNome();
				String cep = cUpdate.getCep();
				String email = cUpdate.getEmail();
				String telefone = cUpdate.getTelefone();
				
				if(nome      !=null) c.setNome(nome);
				if(cep       !=null) c.setCep(cep);
				if(email     !=null) c.setEmail(email);
				if(telefone  !=null) c.setTelefone(telefone);
				
				clienteR.save(c);
				return c;
			}		
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Problema ao tetar buscar", ex);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value="/api/cliente/{cpf}", produces = "application/json")
	public Cliente delete(@PathVariable long cpf) {
		try {
			Optional<Cliente> op = clienteR.findById(cpf);
			
			if(op.isPresent()) {
				clienteR.deleteById(cpf);
				return op.get();
			}		
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao tentar deletar.", ex);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
