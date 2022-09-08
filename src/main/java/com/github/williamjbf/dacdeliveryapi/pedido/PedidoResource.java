package com.github.williamjbf.dacdeliveryapi.pedido;

import com.github.williamjbf.dacdeliveryapi.exception.ClienteNaoExisteException;
import com.github.williamjbf.dacdeliveryapi.exception.PedidoNaoExisteException;
import com.github.williamjbf.dacdeliveryapi.pedido.dto.PedidoDto;
import com.github.williamjbf.dacdeliveryapi.pedido.model.Pedido;
import com.github.williamjbf.dacdeliveryapi.pedido.model.StatusPedido;
import com.github.williamjbf.dacdeliveryapi.pedido.repository.PedidoRepository;
import com.github.williamjbf.dacdeliveryapi.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PedidoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> find(@PathVariable("id") Long id) {
        Optional<Pedido> pedido = repository.findById(id);
        if (pedido.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(pedido.get());
        }
        throw new PedidoNaoExisteException(id);
    }

    @GetMapping
    public List<Pedido> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@Valid @RequestBody PedidoDto pedido) {
        final Pedido PedidoSalvo = service.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(PedidoSalvo);
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<Pedido> atualizarStatus(@PathVariable("id") Long id, @PathVariable("status") StatusPedido novoStatus) {
        Optional<Pedido> pedido = repository.findById(id);
        if (pedido.isPresent()) {
            pedido.get().setStatus(novoStatus);
            repository.save(pedido.get());
            return ResponseEntity.status(HttpStatus.OK).body(pedido.get());
        }
        throw new PedidoNaoExisteException(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@Valid @RequestBody Pedido pedido, @PathVariable("id") Long id) {
        if (repository.findById(id).isPresent()) {
            pedido.setId(id);
            final Pedido pedidoAtualizado = repository.save(pedido);
            return ResponseEntity.status(HttpStatus.OK).body(pedidoAtualizado);
        }
        throw new PedidoNaoExisteException(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        throw new PedidoNaoExisteException(id);

    }
}