package com.github.williamjbf.dacdeliveryapi.endereco;

import com.github.williamjbf.dacdeliveryapi.endereco.model.Endereco;
import com.github.williamjbf.dacdeliveryapi.endereco.repository.EnderecoRepository;
import com.github.williamjbf.dacdeliveryapi.endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {
    @Autowired
    EnderecoService service;
    @Autowired
    EnderecoRepository repository;

    @GetMapping
    public List<Endereco> listAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> find(@PathVariable("id") Long id){
        Endereco endereco = service.findById(id);
        if(endereco!= null){
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@Valid @RequestBody Endereco endereco){
        final Endereco EnderecoSalvo = service.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(EnderecoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@Valid @RequestBody Endereco endereco, @PathVariable("id") Long id){
        return service.update(endereco, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Endereco endereco = service.findById(id);
        if (endereco != null) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(endereco);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
