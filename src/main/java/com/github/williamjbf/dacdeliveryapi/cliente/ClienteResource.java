package com.github.williamjbf.dacdeliveryapi.cliente;

import com.github.williamjbf.dacdeliveryapi.cliente.model.Cliente;
import com.github.williamjbf.dacdeliveryapi.cliente.repository.ClienteRepository;
import com.github.williamjbf.dacdeliveryapi.exception.ClienteNaoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteRepository repository;
    private final PasswordEncoder encoder;

    public ClienteResource(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> find(@PathVariable("cpf") String cpf){
        Optional<Cliente> cliente = repository.findById(cpf);
        return cliente.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public List<Cliente> listAll(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente){
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        final Cliente ClienteSalvo = repository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteSalvo);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Cliente> update(@Valid @RequestBody Cliente cliente, @PathVariable("cpf") String cpf){
        if(repository.findById(cpf).isPresent()){
            cliente.setCpf(cpf);
            final Cliente clienteAtualizado = repository.save(cliente);
            return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);
        }
        throw new ClienteNaoExisteException(cpf);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity delete(@PathVariable("cpf") String cpf) {
        if (repository.findById(cpf).isPresent()) {
            repository.deleteById(cpf);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        throw new ClienteNaoExisteException(cpf);
    }
}
