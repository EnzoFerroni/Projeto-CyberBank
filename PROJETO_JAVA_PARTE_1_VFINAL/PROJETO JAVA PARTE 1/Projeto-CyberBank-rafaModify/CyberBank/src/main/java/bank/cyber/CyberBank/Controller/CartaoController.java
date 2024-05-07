package bank.cyber.CyberBank.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import bank.cyber.CyberBank.Entidades.Cartao;
import bank.cyber.CyberBank.Repositorio.CartaoRepo;

import java.util.Optional;

@RestController
public class CartaoController {

    @Autowired
    private CartaoRepo cartaoRepo;

    @PostMapping("/api/cartao")
    public Cartao createCartao(@RequestBody Cartao cartao) {
        if(cartao.getNumCartao() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Número do Cartão é obrigatório.");
        }
        return cartaoRepo.save(cartao);
    }

    @GetMapping("/api/cartao")
    public Iterable<Cartao> readAll() {
        return cartaoRepo.findAll();
    }

    @GetMapping("/api/cartao/{id}")
    public Cartao readById(@PathVariable long id) {
        Optional<Cartao> cartaoOptional = cartaoRepo.findById(id);
        if(cartaoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartao não encontrado.");
        }
        return cartaoOptional.get();
    }

    @PutMapping("/api/cartao/{id}")
    public Cartao update(@RequestBody Cartao updatedCartao, @PathVariable long id) {
        Optional<Cartao> cartaoOptional = cartaoRepo.findById(id);
        if(cartaoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartao não encontrado.");
        }

        Cartao cartao = cartaoOptional.get();
        cartao.setPin(updatedCartao.getPin());
        cartao.setDataValidade(updatedCartao.getDataValidade());
        cartao.setBandeira(updatedCartao.getBandeira());
        cartao.setTipoCartao(updatedCartao.getTipoCartao());

        return cartaoRepo.save(cartao);
    }

    @DeleteMapping("/api/cartao/{id}")
    public void delete(@PathVariable long id) {
        if(cartaoRepo.existsById(id)) {
            cartaoRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartao não encontrado.");
        }
    }
}