package com.github.williamjbf.dacdeliveryapi.empresa;

import com.github.williamjbf.dacdeliveryapi.empresa.model.Empresa;
import com.github.williamjbf.dacdeliveryapi.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
