package com.github.williamjbf.dacdeliveryapi.empresa;

import com.github.williamjbf.dacdeliveryapi.empresa.model.Empresa;
import com.github.williamjbf.dacdeliveryapi.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaResource {

    @Autowired
    private EmpresaRepository repository;

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa){
        final Empresa empresaSalva = repository.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaSalva);
    }
    @GetMapping
    public List<Empresa> listAll(){
        return repository.findAll();
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<Empresa> update(@RequestBody Empresa empresa, @PathVariable("cnpj") String cnpj){
        empresa.setCnpj(cnpj);
        final Empresa empresaAtualizada = repository.save(empresa);
        return ResponseEntity.status(HttpStatus.OK).body(empresaAtualizada);
    }

    @DeleteMapping("/{cnpj}")
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable("cnpj") String id){
        repository.deleteById(id);
    }
}
